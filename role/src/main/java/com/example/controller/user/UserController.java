package com.example.controller.user;


import com.example.entiy.user.User;
import com.example.entiy.user.UserResponse;
import com.example.service.user.IUserService;
import com.example.until.DateUntil;
import com.example.until.Result;
import com.example.until.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户表服务接口
 * @author : zhangfx 2018/12/27/ 16:16
 * @version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 根据id删除指定用户记录
     * @param id 用户id
     * @return 删除结果
     */
    @GetMapping(value = "/selectId")
    public Result selectByPrimaryKey(@RequestParam(name = "id")Integer id) {
        return  ResultUtil.success(userService.selectByPrimaryKey(id));
    }

    /**
     * 插入一条用户记录
     * @param record 用户记录内容
     * @return 插入结果
     */
    @PostMapping(value = "/insert")
    public Result insertSelective(@RequestBody User record) {
        record.setCrationTime(DateUntil.dateToStrLong());
        int i = userService.insertSelective(record);
        return ResultUtil.success("增加行数:"+i);
    }

    /**
     * 根据id查找指定的用户记录
     * @param id 权限ID
     * @return 查询结果
     */
    @PostMapping(value = "/delete")
    public Result deleteByPrimaryKey(@RequestParam(name = "id")Integer id) {
        int i = userService.deleteByPrimaryKey(id);
        return ResultUtil.success("删除行数:"+i);
    }

    /**
     * 通过新的用户记录更新旧的用户记录
     * @param record 新的用户纪录
     * @return 修改结果
     */
    @PostMapping(value = "/update")
    public Result updateByPrimaryKeySelective(@RequestBody UserResponse record) {
        record.setCrationTime(DateUntil.dateToStrLong());
        int i = userService.updateByPrimaryKeySelective(record);
        return ResultUtil.success("修改行数:"+i);
    }
    /**
     * 查找全部用户记录
     * @return 用户记录
     */
    @GetMapping(value = "/selectAll")
    public Result selectAll() {
        return ResultUtil.success(userService.selectAll());
    }
}
