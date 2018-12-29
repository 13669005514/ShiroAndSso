package com.example.entiy.dictionaryInfo;

/**
 * 字典表信息补充字段
 * @author zhangfx 2018/12/26
 * @version 1.0
 */
public class DictionaryInfoResponse extends  DictionaryInfo{
    /**
     * 主键 编号
     */
    private Integer id;

    /**
     * 删除标志
     */
    private Integer deleteFlag;

    /**
     * 获取主键编号
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键编号
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取删除标志内容
     * @return 删除标志内容
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置删除标记内容
     * @param deleteFlag 删除标记内容
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public DictionaryInfoResponse() {

    }

}