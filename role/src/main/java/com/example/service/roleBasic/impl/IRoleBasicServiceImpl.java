package com.example.service.roleBasic.impl;

import com.example.entiy.roleBasic.RoleBasic;
import com.example.entiy.roleBasic.RoleBasicResponse;
import com.example.mapper.roleBasic.RoleBasicMapper;
import com.example.service.roleBasic.IRoleBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限基本表的增删改查操作实现
 * @author : zhangfx 2018/12/27/ 10:06
 * @version 1.0
 */
@Service
public class IRoleBasicServiceImpl implements IRoleBasicService {

    @Autowired
    private RoleBasicMapper roleBasicMapper;


    /**
     * 根据id删除指定权限记录
     * @param id 权限id
     * @return 删除结果
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.roleBasicMapper.deleteByPrimaryKey(id);
    }

    /**
     * 插入一条权限基本记录
     * @param record 权限记录内容
     * @return 插入结果
     */
    @Override
    public int insertSelective(RoleBasic record) {
        return this.roleBasicMapper.insertSelective(record);
    }

    /**
     * 根据id查找指定的权限记录
     * @param id 权限ID
     * @return 查询结果
     */
    @Override
    public RoleBasicResponse selectByPrimaryKey(Integer id) {
        return this.roleBasicMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过新的权限记录更新旧的记录
     * @param record 新的权限纪录
     * @return 修改结果
     */
    @Override
    public int updateByPrimaryKeySelective(RoleBasic record) {
        return this.roleBasicMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 按父类RoleCode查找权限记录
     * @param parentRoleCode 父类RoleCode
     * @return 权限记录
     */
    @Override
    public List<RoleBasicResponse> selectByParentRoleCode(String parentRoleCode) {
        return this.roleBasicMapper.selectByParentRoleCode(parentRoleCode);
    }

    /**
     * 查找全部权限记录
     * @return 权限记录
     */
    @Override
    public List<RoleBasicResponse> selectAll() {
        return this.roleBasicMapper.selectAll();
    }
}
