package cn.daenx.myadmin.system.controller;

import cn.daenx.myadmin.common.exception.MyException;
import cn.daenx.myadmin.common.utils.ExcelUtil;
import cn.daenx.myadmin.common.vo.Result;
import cn.daenx.myadmin.system.dto.SysUserPageDto;
import cn.daenx.myadmin.system.po.SysRole;
import cn.daenx.myadmin.system.service.SysDeptService;
import cn.daenx.myadmin.system.service.SysRoleService;
import cn.daenx.myadmin.system.service.SysUserService;
import cn.daenx.myadmin.system.vo.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/role")
public class SysRoleController {
    @Resource
    private SysRoleService sysRoleService;
    @Resource
    private SysDeptService sysDeptService;
    @Resource
    private SysUserService sysUserService;


    /**
     * 分页列表
     *
     * @param vo
     * @return
     */
    @SaCheckPermission("system:role:list")
    @GetMapping(value = "/list")
    public Result list(SysRolePageVo vo) {
        IPage<SysRole> page = sysRoleService.getPage(vo);
        return Result.ok(page);
    }

    /**
     * 导出
     */
    @SaCheckPermission("system:role:export")
    @PostMapping("/export")
    public void export(SysRolePageVo vo, HttpServletResponse response) {
        List<SysRole> list = sysRoleService.getAll(vo);
        ExcelUtil.exportXlsx(response, "角色", "角色数据", list, SysRole.class);
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    @SaCheckPermission("system:role:query")
    @GetMapping(value = "/{id}")
    public Result query(@PathVariable String id) {
        SysRole sysRole = sysRoleService.getInfo(id);
        return Result.ok(sysRole);
    }

    /**
     * 修改
     *
     * @param vo
     * @return
     */
    @SaCheckPermission("system:role:edit")
    @PutMapping
    public Result edit(@Validated @RequestBody SysRoleUpdVo vo) {
        sysRoleService.editInfo(vo);
        return Result.ok();
    }

    /**
     * 新增
     *
     * @param vo
     * @return
     */
    @SaCheckPermission("system:role:add")
    @PostMapping
    public Result add(@Validated @RequestBody SysRoleAddVo vo) {
        sysRoleService.addInfo(vo);
        return Result.ok();
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @SaCheckPermission("system:role:remove")
    @DeleteMapping()
    public Result remove(@RequestBody List<String> ids) {
        if (CollUtil.isEmpty(ids)) {
            throw new MyException("参数错误");
        }
        sysRoleService.deleteByIds(ids);
        return Result.ok();
    }

    /**
     * 获取对应角色部门列表树
     *
     * @param roleId
     * @return
     */
    @GetMapping(value = "/roleDeptTreeSelect/{roleId}")
    public Result roleDeptTreeSelect(@PathVariable("roleId") String roleId) {
        List<Tree<String>> list = sysDeptService.deptTree(new SysDeptPageVo());
        Map<String, Object> map = new HashMap<>();
        map.put("checkedKeys", sysDeptService.selectDeptListByRoleId(roleId));
        map.put("depts", list);
        return Result.ok(map);
    }


    /**
     * 修改数据权限
     *
     * @param vo
     * @return
     */
    @SaCheckPermission("system:role:edit")
    @PutMapping("/dataScope")
    public Result dataScope(@Validated @RequestBody SysRoleDataScopeUpdVo vo) {
        sysRoleService.dataScope(vo);
        return Result.ok();
    }


    /**
     * 查询已分配该角色的用户列表
     */
    @SaCheckPermission("system:role:list")
    @GetMapping("/authUser/allocatedList")
    public Result allocatedList(SysUserPageVo vo, String roleId) {
        IPage<SysUserPageDto> page = sysUserService.allocatedList(vo, roleId);
        return Result.ok(page);
    }

    /**
     * 查询未分配该角色的用户列表
     */
    @SaCheckPermission("system:role:list")
    @GetMapping("/authUser/unallocatedList")
    public Result unallocatedList(SysUserPageVo vo, String roleId) {
        if (ObjectUtil.isEmpty(roleId)) {
            throw new MyException("roleId不能为空");
        }
        IPage<SysUserPageDto> page = sysUserService.unallocatedList(vo, roleId);
        return Result.ok(page);
    }
}