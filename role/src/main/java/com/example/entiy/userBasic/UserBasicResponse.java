package com.example.entiy.userBasic;

/**
 * 用户基本表对应的全部字段
 * @author : zhangfx 2018/12/27/ 16:58
 * @version 1.0
 */
public class UserBasicResponse extends UserBasic{

    /**
     * 编号 自增长
     */
    private Integer id;

    /**
     * 删除标志 0:可用 1:删除
     */
    private Short deleteFlag;

    /**
     * 获取编号
     * @return id编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置编号
     * @param id 编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取删除状态
     * @return 删除状态
     */
    public Short getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置删除状态
     * @param deleteFlag 删除状态
     */
    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
