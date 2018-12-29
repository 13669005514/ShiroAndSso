package com.example.entiy.userBasic;

/**
 * 用户基本表对应的部分字段
 * @author : zhangfx 2018/12/27/ 16:58
 * @version 1.0
 */
public class UserBasic {


    /**
	* 用户登录账号
	*/
    private String userId;

    /**
	* 用户姓名
	*/
    private String name;

    /**
	* 用户性别
	*/
    private String sex;

    /**
	* 用户出生日期 YYYY-MM-DD
	*/
    private String birthday;

    /**
	* 手机号
	*/
    private String mobile;

    /**
	* 居住地址
	*/
    private String address;

    /**
	* 邮箱地址
	*/
    private String email;

    /**
	* 描述信息
	*/
    private String comment;

    /**
     * 获取用户ID 登录账号
     * @return 登录账号
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置登录账号
     * @param userId 登录账号
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取用户姓名
     * @return 用户姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户姓名
     * @param name 用户姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取用户性别
     * @return 用户性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置用户性别
     * @param sex 用户性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取用户出生日期 格式 YYYY-MM-DD
     * @return 用户出生日期
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 设置用户出生日期 格式 YYYY-MM—DD
     * @param birthday 出生日期
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取用户手机号
     * @return 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置用户手机号
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取居住地址
     * @return 居住地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置用户地址
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取邮箱
     * @return 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
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