package cn.daenx.myadmin.system.service.impl;

import cn.daenx.myadmin.common.exception.MyException;
import cn.daenx.myadmin.common.utils.MyUtil;
import cn.daenx.myadmin.common.utils.TreeBuildUtils;
import cn.daenx.myadmin.system.constant.SystemConstant;
import cn.daenx.myadmin.system.mapper.SysRoleDeptMapper;
import cn.daenx.myadmin.system.mapper.SysRoleMapper;
import cn.daenx.myadmin.system.mapper.SysUserMapper;
import cn.daenx.myadmin.system.po.*;
import cn.daenx.myadmin.system.service.LoginUtilService;
import cn.daenx.myadmin.system.vo.*;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.daenx.myadmin.system.mapper.SysDeptMapper;
import cn.daenx.myadmin.system.service.SysDeptService;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

    @Resource
    private SysDeptMapper sysDeptMapper;
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private SysRoleDeptMapper sysRoleDeptMapper;
    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private LoginUtilService loginUtilService;

    /**
     * 分页列表
     *
     * @param vo
     * @return
     */
    @Override
    public IPage<SysDept> getPage(SysDeptPageVo vo) {
        LambdaQueryWrapper<SysDept> wrapper = getWrapper(vo);
        Page<SysDept> sysDeptPage = sysDeptMapper.selectPage(vo.getPage(false), wrapper);
        return sysDeptPage;
    }

    private LambdaQueryWrapper<SysDept> getWrapper(SysDeptPageVo vo) {
        SysLoginUserVo loginUser = loginUtilService.getLoginUser();
        List<SysRole> roleList = loginUser.getRoles();
        Map<String, List<SysRole>> roleMap = roleList.stream().collect(Collectors.groupingBy(SysRole::getDataScope));
        LambdaQueryWrapper<SysDept> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ObjectUtil.isNotEmpty(vo.getId()), SysDept::getId, vo.getId());
        wrapper.like(ObjectUtil.isNotEmpty(vo.getName()), SysDept::getName, vo.getName());
        wrapper.like(ObjectUtil.isNotEmpty(vo.getCode()), SysDept::getCode, vo.getCode());
        wrapper.like(ObjectUtil.isNotEmpty(vo.getSummary()), SysDept::getSummary, vo.getSummary());
        wrapper.like(ObjectUtil.isNotEmpty(vo.getRemark()), SysDept::getRemark, vo.getRemark());
        wrapper.eq(ObjectUtil.isNotEmpty(vo.getStatus()), SysDept::getStatus, vo.getStatus());
        wrapper.eq(SysDept::getIsDelete, 0);
        String startTime = vo.getStartTime();
        String endTime = vo.getEndTime();
        wrapper.between(ObjectUtil.isNotEmpty(startTime) && ObjectUtil.isNotEmpty(endTime), SysDept::getCreateTime, startTime, endTime);
        wrapper.orderByAsc(SysDept::getSort);
        if (!loginUser.isAdmin() && !roleMap.containsKey(SystemConstant.DATA_SCOPE_ALL)) {
            //不是管理员，也没有全部数据权限
            String deptId = loginUser.getDeptId();
            Set<String> deptSet = new HashSet<>();
            deptSet.add(deptId);
            if (roleMap.containsKey(SystemConstant.DATA_SCOPE_DEPT_DOWN)) {
                //数据权限，1=本部门数据
            }
            if (roleMap.containsKey(SystemConstant.DATA_SCOPE_DEPT_DOWN)) {
                //数据权限，2=本部门及以下数据
                List<SysDept> deptList = sysDeptMapper.getListByParentId(deptId, "1");
                List<String> deptIds = MyUtil.joinToList(deptList, SysDept::getId);
                deptSet.addAll(deptIds);
            }
            if (roleMap.containsKey(SystemConstant.DATA_SCOPE_CUSTOM)) {
                //数据权限，4=自定义权限
                List<SysRole> sysRoleList = roleMap.get(SystemConstant.DATA_SCOPE_CUSTOM);
                List<String> roleIds = sysRoleList.stream().map(SysRole::getId).collect(Collectors.toList());
                LambdaQueryWrapper<SysRoleDept> rdWrapper = new LambdaQueryWrapper<>();
                rdWrapper.select(SysRoleDept::getDeptId).in(SysRoleDept::getRoleId, roleIds);
                List<Object> list = sysRoleDeptMapper.selectObjs(rdWrapper);
                for (Object obj : list) {
                    deptSet.add(String.valueOf(obj));
                }
            }
            wrapper.in(SysDept::getId, deptSet);
        }
        return wrapper;
    }

    /**
     * 获取所有列表
     *
     * @param vo
     * @return
     */
    @Override
    public List<SysDept> getAll(SysDeptPageVo vo) {
        LambdaQueryWrapper<SysDept> wrapper = getWrapper(vo);
        List<SysDept> sysDeptList = sysDeptMapper.selectListX(wrapper);
        return sysDeptList;
    }

    /**
     * 获取所有列表
     * 不翻译leaderUser
     *
     * @param vo
     * @return
     */
    @Override
    public List<SysDept> getList(SysDeptPageVo vo) {
        LambdaQueryWrapper<SysDept> wrapper = getWrapper(vo);
        List<SysDept> sysDeptList = sysDeptMapper.selectList(wrapper);
        return sysDeptList;
    }

    /**
     * 获取部门树列表
     *
     * @return
     */
    @Override
    public List<Tree<String>> deptTree(SysDeptPageVo vo) {
        List<SysDept> all = getAll(vo);
        List<Tree<String>> trees = buildDeptTreeSelect(all);
        return trees;
    }

    /**
     * 构建前端所需要下拉树结构
     *
     * @param all 部门列表
     * @return 下拉树结构列表
     */
    public List<Tree<String>> buildDeptTreeSelect(List<SysDept> all) {
        if (CollUtil.isEmpty(all)) {
            return CollUtil.newArrayList();
        }
        return TreeBuildUtils.build(all, (dept, tree) ->
                tree.setId(dept.getId())
                        .setParentId(dept.getParentId())
                        .setName(dept.getName())
                        .setWeight(dept.getSort()));
    }

    /**
     * 通过父ID获取子成员
     *
     * @param parentId
     * @param keepSelf 是否包含自己
     * @return
     */
    @Override
    public List<SysDept> getListByParentId(String parentId, Boolean keepSelf) {
        return sysDeptMapper.getListByParentId(parentId, keepSelf ? null : "1");
    }

    /**
     * 根据角色ID查询部门树信息
     *
     * @param roleId 角色ID
     * @return 选中菜单列表
     */
    @Override
    public List<String> selectDeptListByRoleId(String roleId) {
        SysRole sysRole = sysRoleMapper.selectById(roleId);
        List<SysDept> deptListByRoleId = sysDeptMapper.getDeptListByRoleId(sysRole.getId(), sysRole.getDeptCheckStrictly());
        List<String> strings = MyUtil.joinToList(deptListByRoleId, SysDept::getId);
        return strings;
    }

    private Boolean checkScope(String id) {
        SysDeptPageVo sysDeptPageVo = new SysDeptPageVo();
        sysDeptPageVo.setId(id);
        LambdaQueryWrapper<SysDept> wrapper = getWrapper(sysDeptPageVo);
        List<SysDept> sysDeptList = sysDeptMapper.selectList(wrapper);
        for (SysDept sysDept : sysDeptList) {
            if (sysDept.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private Boolean checkChild(String id) {
        LambdaQueryWrapper<SysDept> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysDept::getParentId, id);
        return sysDeptMapper.exists(wrapper);
    }

    private Boolean checkHasUser(String id) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getDeptId, id);
        return sysUserMapper.exists(wrapper);
    }

    /**
     * 检查是否存在，已存在返回true
     *
     * @param code
     * @param nowId 排除ID
     * @return
     */
    @Override
    public Boolean checkCodeExist(String code, String nowId) {
        LambdaQueryWrapper<SysDept> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysDept::getCode, code);
        wrapper.ne(ObjectUtil.isNotEmpty(nowId), SysDept::getId, nowId);
        boolean exists = sysDeptMapper.exists(wrapper);
        return exists;
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    @Override
    public SysDept getInfo(String id) {
        if (!checkScope(id)) {
            throw new MyException("你无权限操作此数据");
        }
        return sysDeptMapper.selectById(id);
    }

    /**
     * 修改
     *
     * @param vo
     */
    @Override
    public void editInfo(SysDeptUpdVo vo) {
        if (!checkScope(vo.getId())) {
            throw new MyException("你无权限操作此数据");
        }
        if (checkCodeExist(vo.getCode(), vo.getId())) {
            throw new MyException("部门编号已存在");
        }
        //校验父ID
        SysDept sysDeptParent = sysDeptMapper.selectById(vo.getParentId());
        if (sysDeptParent == null) {
            throw new MyException("父级错误");
        }
        LambdaUpdateWrapper<SysDept> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(SysDept::getId, vo.getId());
        wrapper.set(SysDept::getParentId, vo.getParentId());
        wrapper.set(SysDept::getName, vo.getName());
        wrapper.set(SysDept::getCode, vo.getCode());
        wrapper.set(SysDept::getSummary, vo.getSummary());
        wrapper.set(SysDept::getLeaderUserId, vo.getLeaderUserId());
        wrapper.set(SysDept::getSort, vo.getSort());
        wrapper.set(SysDept::getStatus, vo.getStatus());
        wrapper.set(SysDept::getRemark, vo.getRemark());
        //修改level
        wrapper.set(SysDept::getLevel, sysDeptParent.getLevel() + 1);
        int update = sysDeptMapper.update(new SysDept(), wrapper);
        if (update < 1) {
            throw new MyException("修改失败");
        }
    }

    /**
     * 新增
     *
     * @param vo
     */
    @Override
    public void addInfo(SysDeptAddVo vo) {
        if (checkCodeExist(vo.getCode(), null)) {
            throw new MyException("部门编号已存在");
        }
        //校验父ID
        SysDept sysDeptParent = sysDeptMapper.selectById(vo.getParentId());
        if (sysDeptParent == null) {
            throw new MyException("父级错误");
        }
        SysDept sysDept = new SysDept();
        sysDept.setParentId(vo.getParentId());
        sysDept.setName(vo.getName());
        sysDept.setCode(vo.getCode());
        sysDept.setSummary(vo.getSummary());
        sysDept.setLeaderUserId(vo.getLeaderUserId());
        sysDept.setSort(vo.getSort());
        sysDept.setStatus(vo.getStatus());
        sysDept.setRemark(vo.getRemark());
        //设置level
        sysDept.setLevel(sysDeptParent.getLevel() + 1);
        int insert = sysDeptMapper.insert(sysDept);
        if (insert < 1) {
            throw new MyException("新增失败");
        }
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void deleteById(String id) {
        if (!checkScope(id)) {
            throw new MyException("你无权限操作此数据");
        }
        if (checkChild(id)) {
            throw new MyException("存在下级部门，请先删除下级部门");
        }
        if (checkHasUser(id)) {
            throw new MyException("该部门存在用户，请先处理相关用户");
        }
        int i = sysDeptMapper.deleteById(id);
        if (i < 1) {
            throw new MyException("删除失败");
        }
    }

    /**
     * 删除列表中的某一个部门及以下部门
     *
     * @param list
     * @param waitRemoveList
     */
    @Override
    public void removeList(List<SysDept> list, List<SysDept> waitRemoveList) {
        if (waitRemoveList == null || waitRemoveList.size() == 0) {
            return;
        }
        list.removeAll(waitRemoveList);
        List<SysDept> collect = list.stream().filter(item -> item.getParentId().equals(waitRemoveList.get(0).getId())).collect(Collectors.toList());
        removeList(list, collect);
    }
}
