package com.example.service.userBasic.impl;

import com.example.entiy.user.UserResponse;
import com.example.entiy.userBasic.UserBasic;
import com.example.entiy.userBasic.UserBasicResponse;
import com.example.mapper.userBasic.UserBasicMapper;
import com.example.service.userBasic.IUserBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户信息基本表增删改查实现
 * @author zhangfx 2018/12/27 17:10
 * @version 1.0
 */
@Service
public class UserBasicServiceImpl implements IUserBasicService {

    @Autowired
    private UserBasicMapper userBasicMapper;

    /**
     * 根据id删除指定用户信息记录
     * @param id 用户信息id
     * @return 删除结果
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.userBasicMapper.deleteByPrimaryKey(id);
    }
    /**
     * 插入一条用户信息记录
     * @param record 用户信息记录内容
     * @return 插入结果
     */
    @Override
    public int insertSelective(UserBasic record) {
        return this.userBasicMapper.insertSelective(record);
    }
    /**
     * 根据id查找指定的用户信息记录
     * @param id 用户信息ID
     * @return 查询结果
     */
    @Override
    public UserBasicResponse selectByPrimaryKey(Integer id) {
        return this.userBasicMapper.selectByPrimaryKey(id);
    }
    /**
     * 通过新的用户信息记录更新旧的用户信息记录
     * @param record 新的用户信息纪录
     * @return 修改结果
     */
    @Override
    public int updateByPrimaryKeySelective(UserBasicResponse record) {
        return this.userBasicMapper.updateByPrimaryKeySelective(record);
    }
    /**
     * 查找全部用户信息记录
     * @return 用户信息记录
     */
    @Override
    public List<UserResponse> selectAll() {
        return this.userBasicMapper.selectAll();
    }
}
