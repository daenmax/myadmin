package cn.daenx.myadmin.quartz.utils;


import cn.daenx.myadmin.common.utils.ExceptionUtil;
import cn.daenx.myadmin.quartz.constant.QuartzConstant;
import cn.daenx.myadmin.quartz.constant.ScheduleConstants;
import cn.daenx.myadmin.system.mapper.SysJobLogMapper;
import cn.daenx.myadmin.system.po.SysJob;
import cn.daenx.myadmin.system.po.SysJobLog;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 抽象quartz调用
 *
 */
@Component
@Slf4j
public abstract class AbstractQuartzJob implements Job {
    @Resource
    private SysJobLogMapper sysJobLogMapper;
    /**
     * 线程本地变量
     */
    private static ThreadLocal<LocalDateTime> threadLocal = new ThreadLocal<>();

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SysJob sysJob = new SysJob();
        BeanUtils.copyProperties(context.getMergedJobDataMap().get(ScheduleConstants.TASK_PROPERTIES), sysJob);
        try {
            before(context, sysJob);
            if (sysJob != null) {
                doExecute(context, sysJob);
            }
            after(context, sysJob, null);
        } catch (Exception e) {
            log.error("任务执行异常  - ：", e);
            after(context, sysJob, e);
        }
    }

    /**
     * 执行前
     *
     * @param context 工作执行上下文对象
     * @param sysJob  系统计划任务
     */
    protected void before(JobExecutionContext context, SysJob sysJob) {
        threadLocal.set(LocalDateTime.now());
    }

    /**
     * 执行后
     *
     * @param context 工作执行上下文对象
     * @param sysJob  系统计划任务
     */
    protected void after(JobExecutionContext context, SysJob sysJob, Exception e) {
        LocalDateTime startTime = threadLocal.get();
        threadLocal.remove();

        final SysJobLog sysJobLog = new SysJobLog();
        sysJobLog.setJobId(sysJob.getId());
        sysJobLog.setStartTime(startTime);
        sysJobLog.setEndTime(LocalDateTime.now());

        long runMs = Duration.between(sysJobLog.getStartTime(), sysJobLog.getEndTime()).toMillis();
        sysJobLog.setExecuteTime((int) runMs);
        sysJobLog.setJobMessage(sysJob.getJobName() + " 总共耗时：" + runMs + "毫秒");
        if (e != null) {
            sysJobLog.setStatus(QuartzConstant.JOB_FAIL);
            String errorMsg = StringUtils.substring(ExceptionUtil.getExceptionMessage(e), 0, 2000);
            sysJobLog.setExceptionInfo(errorMsg);
        } else {
            sysJobLog.setStatus(QuartzConstant.JOB_SUCCESS);
        }

        // 写入数据库当中
        sysJobLogMapper.insert(sysJobLog);
    }

    /**
     * 执行方法，由子类重载
     *
     * @param context 工作执行上下文对象
     * @param sysJob  系统计划任务
     * @throws Exception 执行过程中的异常
     */
    protected abstract void doExecute(JobExecutionContext context, SysJob sysJob) throws Exception;
}
