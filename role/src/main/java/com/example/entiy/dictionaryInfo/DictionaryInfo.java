package com.example.entiy.dictionaryInfo;

/**
 * 字典表信息字段
 * @author zhangfx 2018/12/26 16:13
 * @version 1.0
 */
public class DictionaryInfo {

    /**
	* 字典码
	*/
    private String code;

    /**
	* 字典码对应的值
	*/
    private String name;

    /**
	* 上级父类字典码
	*/
    private String parentCode;

    /**
	* 同类内容的排列顺序
	*/
    private Integer index;

    /**
	* 描述信息
	*/
    private String comment;

    /**
     * 获取字典名称
     * @return 字典名称
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置字典名称
     * @param code 字典名称
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取字典名称对应的内容
     * @return 字典名称对应的内容
     */
    public String getName() {
        return name;
    }

    /**
     * 设置字典内容
     * @param name 字典内容
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取父类码
     * @return 父类码
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * 设置父类码
     * @param parentCode 父类码
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    /**
     * 获取同级内容下的排列顺序
     * @return 排列顺序
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * 设置同级内容下的排列顺序
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