package com.example.entiy.user;

/**
 * 用户表全部字段
 * @author : zhangfx 2018/12/27/ 15:44
 * @version 1.0
 */
public class UserResponse extends User {

    /**
     *  编号 自增长
     */
    private Integer id;

    /**
     * 0:账号可用 1：账号停用
     */
    private Short status;

    /**
     * 删除标志 0:可用 1:删除
     */
    private Short deleteFlag;

    /**
     * 获取id 编号
     * @return id编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id 编号
     * @param id 编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取删除标志
     * @return 删除标志
     */
    public Short getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置删除标志
     * @param deleteFlag 删除标志
     */
    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 获取账号状态
     * @return 账号状态
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置账号状态
     * @param status 账号状态
     */
    public void setStatus(Short status) {
        this.status = status;
    }
}
