package cn.daenx.test.service;


import cn.daenx.framework.common.vo.ComStatusUpdVo;
import cn.daenx.test.domain.dto.TestDataPageDto;
import cn.daenx.test.domain.po.TestData;
import cn.daenx.test.domain.vo.TestDataAddVo;
import cn.daenx.test.domain.vo.TestDataImportVo;
import cn.daenx.test.domain.vo.TestDataPageVo;
import cn.daenx.test.domain.vo.TestDataUpdVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface TestDataService extends IService<TestData> {

    /**
     * 测试数据分页列表_MP分页插件
     *
     * @param vo
     * @return
     */
    IPage<TestData> getPage1(TestDataPageVo vo);

    /**
     * 测试数据分页列表_自己写的SQL
     *
     * @param vo
     * @return
     */
    IPage<TestDataPageDto> getPage2(TestDataPageVo vo);

    /**
     * 测试数据分页列表_MP自定义SQL
     *
     * @param vo
     * @return
     */
    IPage<TestDataPageDto> getPage3(TestDataPageVo vo);

    /**
     * 新增
     *
     * @param vo
     */
    void addInfo(TestDataAddVo vo);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    TestData getInfo(String id);

    /**
     * 修改
     *
     * @param vo
     */
    void editInfo(TestDataUpdVo vo);

    /**
     * 删除
     *
     * @param ids
     */
    void deleteByIds(List<String> ids);

    /**
     * 获取所有列表，用于导出
     *
     * @param vo
     * @return
     */
    List<TestDataPageDto> getAll(TestDataPageVo vo);

    /**
     * 导入数据
     *
     * @param dataList
     * @return
     */
    Integer importInfo(List<TestDataImportVo> dataList);

    /**
     * 测试数据-修改状态
     *
     * @param vo
     */
    void changeStatus(ComStatusUpdVo vo);

}
