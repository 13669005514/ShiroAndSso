package com.example.service.userBasic;

import com.example.entiy.user.UserResponse;
import com.example.entiy.userBasic.UserBasic;
import com.example.entiy.userBasic.UserBasicResponse;

import java.util.List;

/**
 * 用户信息基本表增删改查service
 * @author zhangfx 2018/12/27 17:10
 * @version 1.0
 */
public interface IUserBasicService {

    /**
     * 根据id删除指定用户信息记录
     * @param id 用户信息id
     * @return 删除结果
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 插入一条用户信息记录
     * @param record 用户信息记录内容
     * @return 插入结果
     */
    int insertSelective(UserBasic record);
    /**
     * 根据id查找指定的用户信息记录
     * @param id 用户信息ID
     * @return 查询结果
     */
    UserBasicResponse selectByPrimaryKey(Integer id);
    /**
     * 通过新的用户信息记录更新旧的用户信息记录
     * @param record 新的用户信息纪录
     * @return 修改结果
     */
    int updateByPrimaryKeySelective(UserBasicResponse record);

    /**
     * 查找全部用户信息记录
     * @return 用户信息记录
     */
    List<UserResponse> selectAll();
}
