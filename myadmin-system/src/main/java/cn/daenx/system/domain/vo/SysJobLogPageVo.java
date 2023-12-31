package cn.daenx.system.domain.vo;

import cn.daenx.framework.common.vo.BasePageVo;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class SysJobLogPageVo extends BasePageVo {

    /**
     * 日志ID
     */
    private String id;

    /**
     * 任务名称
     */
    private String jobName;

    /**
     * 执行结果，0=成功，1=失败
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

}
