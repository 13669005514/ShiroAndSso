package com.example.service.dictionaryInfo.impl;

import com.example.entiy.dictionaryInfo.DictionaryInfo;
import com.example.entiy.dictionaryInfo.DictionaryInfoResponse;
import com.example.mapper.dictionaryInfo.DictionaryInfoMapper;
import com.example.service.dictionaryInfo.IDictionaryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典表的增删改查操作服务实现类
 * @author : zhangfx 2018/12/26/ 14:52
 * @version 1.0
 */
@Service
public class IDictionaryInfoServiceImpl implements IDictionaryInfoService {

    @Autowired
    private DictionaryInfoMapper dictionaryInfoMapper;

    /**
     * 按主键id删除记录
     * @param id 编号
     * @return 删除结果
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dictionaryInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加一条字典记录
     * @param record 字典内容
     * @return 添加结果
     */
    @Override
    public int insertSelective(DictionaryInfo record) {

        return dictionaryInfoMapper.insertSelective(record);
    }
    /**
     * 按主键id查找指定的一条字典记录
     * @param id 编号
     * @return 记录内容
     */
    @Override
    public DictionaryInfo selectByPrimaryKey(Integer id) {

        return dictionaryInfoMapper.selectByPrimaryKey(id);
    }
    /**
     * 按主键id修改一条字典记录
     * @param record 新的记录内容
     * @return 修改结果
     */
    @Override
    public int updateByPrimaryKeySelective(DictionaryInfoResponse record) {
        return dictionaryInfoMapper.updateByPrimaryKeySelective(record);
    }
    /**
     * 按父类码查找字典记录
     * @param parentCode 父类码
     * @return 字典记录
     */
    @Override
    public List<DictionaryInfoResponse> selectByParentCode(String parentCode) {

        return dictionaryInfoMapper.selectByParentCode(parentCode);
    }
    /**
     * 查找全部字典记录
     * @return 字典记录
     */
    @Override
    public List<DictionaryInfoResponse> selectAll() {
        return dictionaryInfoMapper.selectAll();
    }
}
