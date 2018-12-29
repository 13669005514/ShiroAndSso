package com.example.entiy.roleBasic;

/**
 * 权限基本表的全部字段
 * @author zhangfx 2018/12/27
 * @version 1.0
 */
public class RoleBasicResponse extends RoleBasic{
    /**
	* 主键标识 自增
	*/
    private Integer id;

    /**
	* 删除标志 0：可用 1：删除
	*/
    private Short deleteFlag;

    /**
     * 获取id编号
     * @return id编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id编号
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