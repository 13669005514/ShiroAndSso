package com.example.entiy.roleRelation;

/**
 * 权限关系表部分字段
 * @author zhangfx 2018/12/27
 * @version 1.0
 */
public class RoleRelation {

    /**
	* 权限码
	*/
    private String roleCode;

    /**
	* 父类权限码
	*/
    private String parentRoleCode;

    /**
	* 排列顺序
	*/
    private Integer index;

    /**
	* 描述信息
	*/
    private String comment;

    /**
     * 获取权限码
     * @return 权限码
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * 设置权限码
     * @param roleCode 权限码
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    /**
     * 获取父类权限码
     * @return 父类权限码
     */
    public String getParentRoleCode() {
        return parentRoleCode;
    }

    /**
     * 设置父类权限码
     * @param parentRoleCode 父类权限码
     */
    public void setParentRoleCode(String parentRoleCode) {
        this.parentRoleCode = parentRoleCode;
    }

    /**
     * 获取排列顺序
     * @return 排列顺序
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * 设置排列顺序
     * @param index 排列顺序
     */
    public void setIndex(Integer index) {
        this.index = index;
    }

    /**
     * 获取描述信息
     * @return 描述信息
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置描述信息
     * @param comment 描述信息
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

}