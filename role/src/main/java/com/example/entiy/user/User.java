package com.example.entiy.user;

/**
 * 用户表的部分字段
 * @author zhangfx 2018/12/27
 * @version 1.0
 */
public class User {

    /**
	* 登录账号

	*/
    private String username;

    /**
	* 登录密码
	*/
    private String password;

    /**
	* 创建时间 YYYY-MM-DD HH:MM:SS
	*/
    private String crationTime;


    /**
     * 权限码
     */
    private String roleCode;

    /**
     * 获取用户名
     * @return 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取登录密码
     * @return 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取创建时间
     * @return 创建时间
     */
    public String getCrationTime() {
        return crationTime;
    }

    /**
     * 设置创建时间
     * @param crationTime 创建时间
     */
    public void setCrationTime(String crationTime) {
        this.crationTime = crationTime;
    }

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
}