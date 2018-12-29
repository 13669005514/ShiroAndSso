package com.example.entiy.roleRelation;

/**
 * 权限基本表全部字段
 * @author zhangfx 2018/12/28
 * @version 1.0
 */
public class RoleRelationResponse extends RoleRelation {
    /**
	* 主键自增
	*/
    private Integer id;

    /**
	* 删除标志 0:可用 1:删除
	*/
    private Short deleteFlag;

    /**
     * 获取编号
     * @return 编号
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