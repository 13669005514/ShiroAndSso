package com.example.entiy.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @Description:
 * @Auther: zhangfx
 * @Date: 2018/12/29/ 16:31
 */
public class ExcelInfo extends BaseRowModel {

    /**
     *序号
     */
    @ExcelProperty(index = 0)
    private String serialNumber;

    /**
     * 物理名
     */
    @ExcelProperty(index = 1)
    private String physicalName;

    /**
     * 伦理名
     */
    @ExcelProperty(index = 2)
    private String ethicalName;

    /**
     * 类型
     */
    @ExcelProperty(index = 3)
    private String type;

    /**
     * 是否必需
     */
    @ExcelProperty(index = 4)
    private String isMust;

    /**
     * 最小长度
     */
    @ExcelProperty(index = 5)
    private String minLength;

    /**
     * 最小长度
     */
    @ExcelProperty(index = 6)
    private String maxLength;

    /**
     * 最小值
     */
    @ExcelProperty(index = 7)
    private String minValue;

    /**
     * 最大值
     */
    @ExcelProperty(index = 8)
    private String maxValue;

    /**
     * 选择项
     */
    @ExcelProperty(index = 9)
    private String options;

    /**
     * 格式
     */
    @ExcelProperty(index = 10)
    private String format;

    /**
     * 备注
     */
    @ExcelProperty(index = 11)
    private String comment;
}
