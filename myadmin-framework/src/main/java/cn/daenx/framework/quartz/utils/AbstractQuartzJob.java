package cn.daenx.framework.quartz.utils;


import cn.daenx.framework.common.constant.CommonConstant;
import cn.daenx.framework.common.utils.ExceptionUtil;
import cn.daenx.framework.common.vo.system.other.SysJobLogVo;
import cn.daenx.framework.common.vo.system.other.SysJobVo;
import cn.daenx.framework.quartz.constant.QuartzConstant;
import cn.daenx.framework.quartz.constant.ScheduleConstants;
import cn.hutool.extra.spring.SpringUtil;
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
 */
@Component
@Slf4j
public abstract class AbstractQuartzJob implements Job {

    /**
     * 线程本地变量
     */
    private static ThreadLocal<LocalDateTime> threadLocal = new ThreadLocal<>();

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SysJobVo sysJob = new SysJobVo();
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
    protected void before(JobExecutionContext context, SysJobVo sysJob) {
        threadLocal.set(LocalDateTime.now());
    }

    /**
     * 执行后
     *
     * @param context 工作执行上下文对象
     * @param sysJob  系统计划任务
     */
    protected void after(JobExecutionContext context, SysJobVo sysJob, Exception e) {
        LocalDateTime startTime = threadLocal.get();
        threadLocal.remove();

        final SysJobLogVo sysJobLog = new SysJobLogVo();
        sysJobLog.setJobId(sysJob.getId());
        sysJobLog.setStartTime(startTime);
        sysJobLog.setEndTime(LocalDateTime.now());

        long runMs = Duration.between(sysJobLog.getStartTime(), sysJobLog.getEndTime()).toMillis();
        sysJobLog.setExecuteTime((int) runMs);
        sysJobLog.setJobMessage(sysJob.getJobName() + " 总共耗时：" + runMs + "毫秒");
        if (e != null) {
            sysJobLog.setStatus(QuartzConstant.JOB_FAIL);
            String errorMsg = StringUtils.substring(ExceptionUtil.getExceptionMessage(e), 0, CommonConstant.SAVE_LOG_LENGTH);
            sysJobLog.setExceptionInfo(errorMsg);
            sysJob.setErrorMsg(errorMsg);
            //发送异常通知
            SpringUtil.getApplicationContext().publishEvent(sysJob);
        } else {
            sysJobLog.setStatus(QuartzConstant.JOB_SUCCESS);
        }

        // 写入数据库当中
        SpringUtil.getApplicationContext().publishEvent(sysJobLog);
    }

    /**
     * 执行方法，由子类重载
     *
     * @param context 工作执行上下文对象
     * @param sysJob  系统计划任务
     * @throws Exception 执行过程中的异常
     */
    protected abstract void doExecute(JobExecutionContext context, SysJobVo sysJob) throws Exception;
}
