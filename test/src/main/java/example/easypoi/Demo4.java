package example.easypoi;


import com.github.sd4324530.fastexcel.annotation.MapperCell;

/**
 * @Description:
 * @author: fxzhang
 * @Date: 2018/12/31 21:26
 */
public class Demo4 {

    /**
     * 序号
     */
    @MapperCell(cellName= "序号")
    private String serialNumber;

    /**
     * 物理名
     */
    @MapperCell(cellName= "物理名")
    private String physicalName;

    /**
     * 伦理名
     */
    @MapperCell(cellName= "伦理名")
    private String ethicalName;

    /**
     * 类型
     */
    @MapperCell(cellName= "类型")
    private String type;

    /**
     * 是否必需
     */
    @MapperCell(cellName= "是否必须")
    private String isMust;

    /**
     * 最小长度
     */
    @MapperCell(cellName= "最小长度")
    private String minLength;

    /**
     * 最小长度
     */
    @MapperCell(cellName= "最大长度")
    private String maxLength;

    /**
     * 最小值
     */
    @MapperCell(cellName= "最小值")
    private String minValue;

    /**
     * 最大值
     */
    @MapperCell(cellName= "最大值")
    private String maxValue;

    /**
     * 选择项
     */
    @MapperCell(cellName= "选择项")
    private String options;

    /**
     * 格式
     */
    @MapperCell(cellName= "格式")
    private String format;

    /**
     * 备注
     */
    @MapperCell(cellName= "备注")
    private String comment;

    public String getSerialNumber() {
        return serialNumber;
    }

    public Demo4 setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public String getPhysicalName() {
        return physicalName;
    }

    public Demo4 setPhysicalName(String physicalName) {
        this.physicalName = physicalName;
        return this;
    }

    public String getEthicalName() {
        return ethicalName;
    }

    public Demo4 setEthicalName(String ethicalName) {
        this.ethicalName = ethicalName;
        return this;
    }

    public String getType() {
        return type;
    }

    public Demo4 setType(String type) {
        this.type = type;
        return this;
    }

    public String getIsMust() {
        return isMust;
    }

    public Demo4 setIsMust(String isMust) {
        this.isMust = isMust;
        return this;
    }

    public String getMinLength() {
        return minLength;
    }

    public Demo4 setMinLength(String minLength) {
        this.minLength = minLength;
        return this;
    }

    public String getMaxLength() {
        return maxLength;
    }

    public Demo4 setMaxLength(String maxLength) {
        this.maxLength = maxLength;
        return this;
    }

    public String getMinValue() {
        return minValue;
    }

    public Demo4 setMinValue(String minValue) {
        this.minValue = minValue;
        return this;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public Demo4 setMaxValue(String maxValue) {
        this.maxValue = maxValue;
        return this;
    }

    public String getOptions() {
        return options;
    }

    public Demo4 setOptions(String options) {
        this.options = options;
        return this;
    }

    public String getFormat() {
        return format;
    }

    public Demo4 setFormat(String format) {
        this.format = format;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Demo4 setComment(String comment) {
        this.comment = comment;
        return this;
    }

    @Override
    public String toString() {
        return "Demo4{" +
                "serialNumber='" + serialNumber + '\'' +
                ", physicalName='" + physicalName + '\'' +
                ", ethicalName='" + ethicalName + '\'' +
                ", type='" + type + '\'' +
                ", isMust='" + isMust + '\'' +
                ", minLength='" + minLength + '\'' +
                ", maxLength='" + maxLength + '\'' +
                ", minValue='" + minValue + '\'' +
                ", maxValue='" + maxValue + '\'' +
                ", options='" + options + '\'' +
                ", format='" + format + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
