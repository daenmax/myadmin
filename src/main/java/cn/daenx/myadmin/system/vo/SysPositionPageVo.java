package cn.daenx.myadmin.system.vo;

import cn.daenx.myadmin.common.vo.BasePageVo;
import lombok.Data;

@Data
public class SysPositionPageVo extends BasePageVo {
    private String name;
    private String code;
    private String summary;
    private String status;
    private String remark;
}
