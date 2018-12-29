package com.example.controller.userBasic;


import com.example.entiy.userBasic.UserBasic;
import com.example.entiy.userBasic.UserBasicResponse;
import com.example.service.userBasic.IUserBasicService;
import com.example.until.Result;
import com.example.until.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户信息基本表服务接口
 * @author : zhangfx 2018/12/27/ 17:17
 * @version 1.0
 */
@RestController
@RequestMapping("/userBasic")
public class UserBasicController {

    @Autowired
    private IUserBasicService userBasicService;

    /**
     * 根据id删除指定用户信息记录
     * @param id 用户信息id
     * @return 删除结果
     */
    @GetMapping(value = "/selectId")
    public Result selectByPrimaryKey(@RequestParam(name = "id")Integer id) {
        return  ResultUtil.success(userBasicService.selectByPrimaryKey(id));
    }

    /**
     * 插入一条用户信息记录
     * @param record 用户信息记录内容
     * @return 插入结果
     */
    @PostMapping(value = "/insert")
    public Result insertSelective(@RequestBody UserBasic record) {
        int i = userBasicService.insertSelective(record);
        return ResultUtil.success("增加行数:"+i);
    }

    /**
     * 根据id查找指定的用户信息记录
     * @param id 权限ID
     * @return 查询结果
     */
    @PostMapping(value = "/delete")
    public Result deleteByPrimaryKey(@RequestParam(name = "id")Integer id) {
        int i = userBasicService.deleteByPrimaryKey(id);
        return ResultUtil.success("删除行数:"+i);
    }

    /**
     * 通过新的用户信息记录更新旧的用户信息记录
     * @param record 新的用户信息纪录
     * @return 修改结果
     */
    @PostMapping(value = "/update")
    public Result updateByPrimaryKeySelective(@RequestBody UserBasicResponse record) {
        int i = userBasicService.updateByPrimaryKeySelective(record);
        return ResultUtil.success("修改行数:"+i);
    }
    /**
     * 查找全部用户信息记录
     * @return 用户信息记录
     */
    @GetMapping(value = "/selectAll")
    public Result selectAll() {
        return ResultUtil.success(userBasicService.selectAll());
    }
}
