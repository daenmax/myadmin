package cn.daenx.common.vo.system.other;

import cn.daenx.common.vo.BaseEntity;
import lombok.Data;
import java.io.Serializable;

/**
 * 岗位表
 */
@Data
public class SysPositionVo extends BaseEntity implements Serializable {
    private String id;

    /**
     * 岗位名称
     */
    private String name;

    /**
     * 岗位编码
     */
    private String code;

    /**
     * 岗位简介
     */
    private String summary;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 岗位状态，0=正常，1=禁用
     */
    private String status;

    /**
     * 备注
     */
    private String remark;
}
