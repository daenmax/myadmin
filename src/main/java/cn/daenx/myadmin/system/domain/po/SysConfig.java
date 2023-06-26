package cn.daenx.myadmin.system.domain.po;

import cn.daenx.myadmin.framework.serializer.annotation.Dict;
import cn.daenx.myadmin.framework.excel.DictConverter;
import cn.daenx.myadmin.common.vo.BaseEntity;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 系统参数
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_config")
//导出时忽略没有@ExcelProperty的字段
@ExcelIgnoreUnannotated
public class SysConfig extends BaseEntity implements Serializable {
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 参数名称
     */
    @ExcelProperty(value = "参数名称")
    @TableField(value = "`name`")
    private String name;

    /**
     * 参数键值
     */
    @ExcelProperty(value = "参数键值")
    @TableField(value = "`key`")
    private String key;

    /**
     * 参数键值
     */
    @ExcelProperty(value = "参数键值")
    @TableField(value = "`value`")
    private String value;

    /**
     * 系统内置，0=否，1=是
     */
    @ExcelProperty(value = "系统内置", converter = DictConverter.class)
//    @Dict(custom = {@DictDetail(value = "0", label = "否"), @DictDetail(value = "1", label = "是")})
    @Dict(dictCode = "sys_yes_no", custom = {})
    @TableField(value = "`type`")
    private String type;

    /**
     * 参数状态，0=正常，1=禁用
     */
    @ExcelProperty(value = "参数状态", converter = DictConverter.class)
//    @Dict(custom = {@DictDetail(value = "0", label = "正常"), @DictDetail(value = "1", label = "禁用")})
    @Dict(dictCode = "sys_normal_disable", custom = {})
    @TableField(value = "`status`")
    private String status;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    @TableField(value = "remark")
    private String remark;

}
