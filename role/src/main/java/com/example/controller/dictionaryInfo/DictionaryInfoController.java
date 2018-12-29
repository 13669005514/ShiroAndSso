package com.example.controller.dictionaryInfo;

import com.example.entiy.dictionaryInfo.DictionaryInfo;
import com.example.entiy.dictionaryInfo.DictionaryInfoResponse;
import com.example.service.dictionaryInfo.IDictionaryInfoService;
import com.example.until.Result;
import com.example.until.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 字典表服务接口
 * @author : zhangfx 2018/12/26/ 14:56
 * @version 1.0
 */
@RestController
@RequestMapping("/dictionary")
public class DictionaryInfoController {
    @Autowired
    private IDictionaryInfoService dictionaryInfoService;

    /**
     * 按主键id删除记录
     * @param id 编号
     * @return 删除结果
     */
    @GetMapping(value = "/selectId")
    public Result selectByPrimaryKey(@RequestParam(name = "id")Integer id) {
        return  ResultUtil.success(dictionaryInfoService.selectByPrimaryKey(id));
    }

    /**
     * 添加一条字典记录
     * @param record 字典内容
     * @return 添加结果
     */
    @PostMapping(value = "/insert")
    public Result insertSelective(@RequestBody DictionaryInfo record) {
        int i = dictionaryInfoService.insertSelective(record);
        return ResultUtil.success("增加行数:"+i);
    }

    /**
     * 按主键id查找指定的一条字典记录
     * @param id 编号
     * @return 记录内容
     */
    @PostMapping(value = "/delete")
    public Result deleteByPrimaryKey(@RequestParam(name = "id")Integer id) {
        int i = dictionaryInfoService.deleteByPrimaryKey(id);
        return ResultUtil.success("删除行数:"+i);
    }

    /**
     * 按主键id修改一条字典记录
     * @param record 新的记录内容
     * @return 修改结果
     */
    @PostMapping(value = "/update")
    public Result updateByPrimaryKeySelective(@RequestBody DictionaryInfoResponse record) {
        int i = dictionaryInfoService.updateByPrimaryKeySelective(record);
        return ResultUtil.success("修改行数:"+i);
    }

    /**
     * 按父类parentCode查找字典记录
     * @param parentCode 父类parentCode
     * @return 字典记录
     */
    @PostMapping(value = "/selectParentCode")
    public Result selectByParentId(@RequestParam(name = "parentCode")String parentCode) {
        return ResultUtil.success(dictionaryInfoService.selectByParentCode(parentCode));
    }

    /**
     * 查找全部字典记录
     * @return 字典记录
     */
    @GetMapping(value = "/selectAll")
    public Result selectAll() {
        return ResultUtil.success(dictionaryInfoService.selectAll());
    }
}
