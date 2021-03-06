package com.example.controller.roleRelation;

import com.example.entiy.roleRelation.RoleRelation;
import com.example.entiy.roleRelation.RoleRelationResponse;
import com.example.service.roleRelation.IRoleRelationService;
import com.example.until.Result;
import com.example.until.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 权限基本表服务接口
 * @author : zhangfx 2018/12/27/ 10:17
 * @version 1.0
 */
@RestController
@RequestMapping("/roleRelation")
public class RoleRelationController {

    @Autowired
    private IRoleRelationService roleRelationService;

    /**
     * 根据id删除指定权限关系记录
     * @param id 权限id
     * @return 删除结果
     */
    @GetMapping(value = "/selectId")
    public Result selectByPrimaryKey(@RequestParam(name = "id")Integer id) {
        return  ResultUtil.success(roleRelationService.selectByPrimaryKey(id));
    }

    /**
     * 插入一条权限基本关系记录
     * @param record 权限关系记录内容
     * @return 插入结果
     */
    @PostMapping(value = "/insert")
    public Result insertSelective(@RequestBody RoleRelation record) {
        System.out.println(record.toString());
        int i = roleRelationService.insertSelective(record);
        return ResultUtil.success("增加行数:"+i);
    }

    /**
     * 根据id查找指定的权限关系记录
     * @param id 权限ID
     * @return 查询结果
     */
    @PostMapping(value = "/delete")
    public Result deleteByPrimaryKey(@RequestParam(name = "id")Integer id) {
        int i = roleRelationService.deleteByPrimaryKey(id);
        return ResultUtil.success("删除行数:"+i);
    }

    /**
     * 通过新的权限关系记录更新旧的关系记录
     * @param record 新的权限纪录
     * @return 修改结果
     */
    @PostMapping(value = "/update")
    public Result updateByPrimaryKeySelective(@RequestBody RoleRelationResponse record) {
        int i = roleRelationService.updateByPrimaryKeySelective(record);
        return ResultUtil.success("修改行数:"+i);
    }

    /**
     * 按父类RoleCode查找权限关系记录
     * @param parentRoleCode 父类RoleCode
     * @return 权限关系记录
     */
    @PostMapping(value = "/selectParentRoleCode")
    public Result selectByParentId(@RequestParam(name = "parentRoleCode")String parentRoleCode) {
        return ResultUtil.success(roleRelationService.selectByParentRoleCode(parentRoleCode));
    }

    /**
     * 查找全部权限关系记录
     * @return 权限关系记录
     */
    @GetMapping(value = "/selectAll")
    public Result selectAll() {
        return ResultUtil.success(roleRelationService.selectAll());
    }
}
