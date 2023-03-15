package cn.daenx.myadmin.system.service.impl;

import cn.daenx.myadmin.common.constant.RedisConstant;
import cn.daenx.myadmin.common.utils.RedisUtil;
import cn.daenx.myadmin.system.constant.SystemConstant;
import cn.daenx.myadmin.system.po.SysDict;
import cn.daenx.myadmin.system.vo.SysDictDetailPageVo;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.daenx.myadmin.system.mapper.SysDictDetailMapper;
import cn.daenx.myadmin.system.po.SysDictDetail;
import cn.daenx.myadmin.system.service.SysDictDetailService;

@Service
public class SysDictDetailServiceImpl extends ServiceImpl<SysDictDetailMapper, SysDictDetail> implements SysDictDetailService {
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private SysDictDetailMapper sysDictDetailMapper;

    /**
     * 根据字典编码查询字典详细信息
     *
     * @param dictCode
     * @return
     */
    @Override
    public List<SysDictDetail> getDictDetailByCodeFromRedis(String dictCode) {
        Object value = redisUtil.getValue(RedisConstant.DICT + dictCode);
        List<SysDictDetail> list = JSON.parseArray(JSON.toJSONString(value), SysDictDetail.class);
        return list;
    }

    @Override
    public IPage<SysDictDetail> getPage(SysDictDetailPageVo vo) {
        LambdaQueryWrapper<SysDictDetail> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ObjectUtil.isNotEmpty(vo.getDictCode()), SysDictDetail::getDictCode, vo.getDictCode());
        wrapper.like(ObjectUtil.isNotEmpty(vo.getLabel()), SysDictDetail::getLabel, vo.getLabel());
        wrapper.like(ObjectUtil.isNotEmpty(vo.getValue()), SysDictDetail::getValue, vo.getValue());
        wrapper.eq(ObjectUtil.isNotEmpty(vo.getStatus()), SysDictDetail::getStatus, vo.getStatus());
        wrapper.eq(ObjectUtil.isNotEmpty(vo.getRemark()), SysDictDetail::getRemark, vo.getRemark());
        String startTime = vo.getStartTime();
        String endTime = vo.getEndTime();
        wrapper.between(ObjectUtil.isNotEmpty(startTime) && ObjectUtil.isNotEmpty(endTime), SysDictDetail::getCreateTime, startTime, endTime);
        Page<SysDictDetail> sysDictDetailPage = sysDictDetailMapper.selectPage(vo.getPage(), wrapper);
        return sysDictDetailPage;
    }
}
