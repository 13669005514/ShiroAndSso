package com.example.mapper.dictionaryInfo;

import com.example.entiy.dictionaryInfo.DictionaryInfo;
import com.example.entiy.dictionaryInfo.DictionaryInfoResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 字典表mapper接口
 * @author zhangfx
 * @version 1.0
 */
@Mapper
public interface DictionaryInfoMapper {
    /**
     * 按主键id删除记录
     * @param id 编号
     * @return 删除结果
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加一条字典记录
     * @param record 字典内容
     * @return 添加结果
     */
    int insertSelective(DictionaryInfo record);

    /**
     * 按主键id查找指定的一条字典记录
     * @param id 编号
     * @return 记录内容
     */
    DictionaryInfo selectByPrimaryKey(Integer id);
    /**
     * 按主键id修改一条字典记录
     * @param record 新的记录内容
     * @return 修改结果
     */
    int updateByPrimaryKeySelective(DictionaryInfoResponse record);

    /**
     * 按父类码查找字典记录
     * @param parentCode 父类码
     * @return 字典记录
     */
    List<DictionaryInfoResponse> selectByParentCode(String parentCode);

    /**
     * 查找全部字典记录
     * @return 字典记录
     */
    List<DictionaryInfoResponse> selectAll();

}