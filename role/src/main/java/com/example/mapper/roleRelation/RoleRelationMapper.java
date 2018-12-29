package com.example.mapper.roleRelation;

import com.example.entiy.roleRelation.RoleRelation;
import com.example.entiy.roleRelation.RoleRelationResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 权限关系表mapper接口
 * @author zhangfx 2018/12/27 11:37
 * @version 1.0
 */
@Mapper
public interface RoleRelationMapper {
    /**
     * 根据id删除指定权限关系记录
     * @param id 权限id
     * @return 删除结果
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 插入一条权限关系记录
     * @param record 权限记录内容
     * @return 插入结果
     */
    int insertSelective(RoleRelation record);
    /**
     * 根据id查找指定的权限关系记录
     * @param id 权限ID
     * @return 查询结果
     */
    RoleRelationResponse selectByPrimaryKey(Integer id);
    /**
     * 通过新的权限关系记录更新旧的关系记录
     * @param record 新的权限关系纪录
     * @return 修改结果
     */
    int updateByPrimaryKeySelective(RoleRelation record);
    /**
     * 按父类roleCode查找权限关系记录
     * @param parentRoleCode 父类roleCode
     * @return 权限关系记录
     */
    List<RoleRelationResponse> selectByParentRoleCode(String parentRoleCode);

    /**
     * 查找全部权限关系记录
     * @return 权限关系记录
     */
    List<RoleRelationResponse> selectAll();

}