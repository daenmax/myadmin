package cn.daenx.myadmin.system.po;

import cn.daenx.myadmin.common.annotation.Dict;
import cn.daenx.myadmin.common.excel.DictConverter;
import cn.daenx.myadmin.common.vo.BaseEntity;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
    * 登录日志表
    */
@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_log_login")
public class SysLogLogin extends BaseEntity implements Serializable {
    @ExcelProperty(value = "登录ID")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 用户账号
     */
    @ExcelProperty(value = "用户账号")
    @TableField(value = "username")
    private String username;

    /**
     * 登录IP
     */
    @ExcelProperty(value = "登录IP")
    @TableField(value = "ip")
    private String ip;

    /**
     * 登录地点
     */
    @ExcelProperty(value = "登录地点")
    @TableField(value = "`location`")
    private String location;

    /**
     * 浏览器
     */
    @ExcelProperty(value = "浏览器")
    @TableField(value = "browser")
    private String browser;

    /**
     * 操作系统
     */
    @ExcelProperty(value = "操作系统")
    @TableField(value = "os")
    private String os;

    /**
     * 登录结果，0=成功，1=失败
     */
    @ExcelProperty(value = "登录结果", converter = DictConverter.class)
    @Dict(dictCode = "sys_common_status", custom = {})
    @TableField(value = "`status`")
    private String status;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    @TableField(value = "remark")
    private String remark;

    /**
     * 是否删除，0=正常，1=删除
     */
    @TableField(value = "is_delete")
    private Integer isDelete;

}
