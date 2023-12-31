package cn.daenx.system.service;

import cn.daenx.system.domain.po.SysUserDetail;
import com.baomidou.mybatisplus.extension.service.IService;

public interface SysUserDetailService extends IService<SysUserDetail> {
    /**
     * 创建用户详细信息
     *
     * @param sysUserDetail
     * @return
     */
    Boolean createDetail(SysUserDetail sysUserDetail);
}
