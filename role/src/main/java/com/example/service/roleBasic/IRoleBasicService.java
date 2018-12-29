package com.example.service.roleBasic;

import com.example.entiy.roleBasic.RoleBasic;
import com.example.entiy.roleBasic.RoleBasicResponse;

import java.util.List;

/**
 * 权限基本表的增删改查操作service接口
 * @author : zhangfx 2018/12/27/ 10:06
 * @version 1.0
 */
public interface IRoleBasicService {

    /**
     * 根据id删除指定权限记录
     * @param id 权限id
     * @return 删除结果
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入一条权限基本记录
     * @param record 权限记录内容
     * @return 插入结果
     */
    int insertSelective(RoleBasic record);

    /**
     * 根据id查找指定的权限记录
     * @param id 权限ID
     * @return 查询结果
     */
    RoleBasicResponse selectByPrimaryKey(Integer id);

    /**
     * 通过新的权限记录更新旧的记录
     * @param record 新的权限纪录
     * @return 修改结果
     */
    int updateByPrimaryKeySelective(RoleBasic record);

    /**
     * 按父类RoleCode查找权限记录
     * @param parentRoleCode 父类RoleCode
     * @return 权限记录
     */
    List<RoleBasicResponse> selectByParentRoleCode(String parentRoleCode);


    /**
     * 查找全部权限记录
     * @return 权限记录
     */
    List<RoleBasicResponse> selectAll();

}
