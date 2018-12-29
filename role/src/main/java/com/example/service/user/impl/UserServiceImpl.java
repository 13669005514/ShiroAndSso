package com.example.service.user.impl;

import com.example.entiy.user.User;
import com.example.entiy.user.UserResponse;
import com.example.mapper.user.UserMapper;
import com.example.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户表增删改查实现
 * @author zhangfx 2018/12/27 16.02
 * @version 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据id删除指定用户记录
     * @param id 用户id
     * @return 删除结果
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 插入一条用户记录
     * @param record 用户记录内容
     * @return 插入结果
     */
    @Override
    public int insertSelective(User record) {
        return this.userMapper.insertSelective(record);
    }
    /**
     * 根据id查找指定的用户记录
     * @param id 用户ID
     * @return 查询结果
     */
    @Override
    public UserResponse selectByPrimaryKey(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);
    }
    /**
     * 通过新的用户记录更新旧的用户记录
     * @param record 新的用户纪录
     * @return 修改结果
     */
    @Override
    public int updateByPrimaryKeySelective(UserResponse record) {
        return this.userMapper.updateByPrimaryKeySelective(record);
    }
    /**
     * 查找全部用户记录
     * @return 用户记录
     */
    @Override
    public List<UserResponse> selectAll() {
        return this.userMapper.selectAll();
    }
}
