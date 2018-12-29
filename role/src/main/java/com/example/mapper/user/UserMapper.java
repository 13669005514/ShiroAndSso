package com.example.mapper.user;

import com.example.entiy.user.User;
import com.example.entiy.user.UserResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户表mapper接口
 * @author zhangfx 2018/12/27 15:49
 * @version 1.0
 */
@Mapper
public interface UserMapper {

    /**
     * 根据id删除指定用户记录
     * @param id 用户id
     * @return 删除结果
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 插入一条用户记录
     * @param record 用户记录内容
     * @return 插入结果
     */
    int insertSelective(User record);
    /**
     * 根据id查找指定的用户记录
     * @param id 用户ID
     * @return 查询结果
     */
    UserResponse selectByPrimaryKey(Integer id);

    /**
     * 通过新的用户记录更新旧的用户记录
     * @param record 新的用户纪录
     * @return 修改结果
     */
    int updateByPrimaryKeySelective(UserResponse record);

    /**
     * 查找全部用户记录
     * @return 用户记录
     */
    List<UserResponse> selectAll();

}