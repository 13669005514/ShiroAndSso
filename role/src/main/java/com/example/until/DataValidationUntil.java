package com.example.until;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.example.entiy.dictionaryInfo.DictionaryInfoResponse;
import com.example.entiy.excel.ExcelInfo;
import com.example.excel.ExcelListener;
import com.example.excel.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

import static jdk.nashorn.internal.objects.Global.print;
import static org.apache.tomcat.util.file.ConfigFileLoader.getInputStream;

/**
 * 数据校验工具 对输入的参数进行合法性校验
 * @author : zhangfx 2018/12/29/ 14:20
 */
public class DataValidationUntil {

    /**
     * 1.通过反射获取对象属性和属性值
     * @param inputData 对象
     */
    public  static  Map<String,Object> getReflectionContent(Object inputData) throws IllegalAccessException {
        Class<?> clazz = inputData.getClass();
        Map<String,Object> map = new HashMap<>();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                System.out.println(field.getName());
                if (field.get(inputData) != null) {
                    System.out.println(field.get(inputData));
                    map.put(field.getName(),field.get(inputData));
                } else {
                    map.put(field.getName(),null);
                }
            }
        }
        return map;

    }

    /**
     * 读取excel文件
     * @throws IOException
     */
    public static List<Object> readExcel() throws IOException {
        InputStream inputStream =new FileInputStream("G:\\check.xlsx");
        List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(2, 1, ExcelInfo.class));
        inputStream.close();
        return data;
    }
    public static void main(String[] args) throws IllegalAccessException, IOException {
//        DictionaryInfoResponse dictionary = new DictionaryInfoResponse();
//        dictionary.setId(1);
//        dictionary.setDeleteFlag(0);
//        dictionary.setCode("1223");
//        Map<String, Object> content = getReflectionContent(dictionary);
//        System.out.println("====");
        List<Object> datas = readExcel();

        System.out.println("===");

    }

}
