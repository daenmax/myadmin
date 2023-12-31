package cn.daenx.system.domain.vo;

import cn.daenx.framework.common.vo.BasePageVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SysNoticePageVo extends BasePageVo {
    private String title;
    private String type;
    private String status;
    private String remark;
    private String createName;
}
