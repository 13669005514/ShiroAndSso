package com.example.service.roleRelation.impl;

import com.example.entiy.roleRelation.RoleRelation;
import com.example.entiy.roleRelation.RoleRelationResponse;
import com.example.mapper.roleRelation.RoleRelationMapper;
import com.example.service.roleRelation.IRoleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限关系表的增删改查操作实现类
 * @author : zhangfx 2018/12/27/ 11:46
 * @version 1.0
 */
@Service
public class RoleRelationServiceImpl  implements IRoleRelationService {

    @Autowired
    private RoleRelationMapper roleRelationMapper;

    /**
     * 根据id删除指定权限关系记录
     * @param id 权限id
     * @return 删除结果
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.roleRelationMapper.deleteByPrimaryKey(id);
    }
    /**
     * 插入一条权限关系记录
     * @param record 权限关系记录内容
     * @return 插入结果
     */
    @Override
    public int insertSelective(RoleRelation record) {
        return this.roleRelationMapper.insertSelective(record);
    }
    /**
     * 根据id查找指定的权限关系记录
     * @param id 权限ID
     * @return 查询结果
     */
    @Override
    public RoleRelationResponse selectByPrimaryKey(Integer id) {
        return this.roleRelationMapper.selectByPrimaryKey(id);
    }
    /**
     * 通过新的权限关系记录更新旧的关系记录
     * @param record 新的权限关系纪录
     * @return 修改结果
     */
    @Override
    public int updateByPrimaryKeySelective(RoleRelation record) {
        return this.roleRelationMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 按父类roleCode查找权限关系记录
     * @param parentRoleCode 父类roleCode
     * @return 权限关系记录
     */
    @Override
    public List<RoleRelationResponse> selectByParentRoleCode(String parentRoleCode) {
        return this.roleRelationMapper.selectByParentRoleCode(parentRoleCode);
    }

    /**
     * 查找全部权限关系记录
     * @return 权限关系记录
     */
    @Override
    public List<RoleRelationResponse> selectAll() {
        return this.roleRelationMapper.selectAll();
    }
}
