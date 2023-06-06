package cn.daenx.myadmin.system.vo;

import cn.daenx.myadmin.common.vo.BasePageVo;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;


@Data
public class SysApiLimitPageVo extends BasePageVo {

    /**
     * 接口名称
     */
    private String apiName;

    /**
     * 接口uri
     */
    private String apiUri;

    /**
     * 限制类型，0=限流，1=停用
     */
    private String limitType;

    /**
     * 停用提示，当限制类型=1时，接口返回的提示内容
     */
    private String retMsg;

    /**
     * 限制状态，0=正常，1=停用
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

}