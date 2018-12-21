package com.example.file;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @Description:
 * 读取指定文件对数据处理输出为文本或表格
 * @Auther: zhangfx
 * @Date: 2018/12/18/ 11:43
 */
public class FileUntil2 {

    //读取文件路径
    private static String readerFilePath = null;
    //写入文件路径
    private static String writerFilePath = null;
    //设置每层行数
    private static int lineSum = 0;
    //设置每层列数
    private static int columnSum = 0;
    //每行数据的长度相加和
    private static int sum = 0;
    //
    private static int index = 0;
    //存放第一层数据
    public static List<String> list1 = new ArrayList<>();
    //存放第二层数据
    public static List<String> list2 = new ArrayList<>();
    //存放第三层数据
    public static List<String> list3 = new ArrayList<>();
    /**
     * DOC 读取信息
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void read() throws FileNotFoundException, IOException {
        //读取配置文件
        getConfig();

        File file = new File(readerFilePath);// 指定要读取的文件
        // 获得该文件的缓冲输入流
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = "";// 用来保存每次读取一行的内容
        while ((line = bufferedReader.readLine()) != null) {
            //1.去掉左右空格
            String trim = line.trim();
            String[] split = trim.split("\\s+ ");
            if (split.length == 8 || split.length == 10) {
                    System.out.println(trim+"   "+trim.length());
                    System.out.println(split.length);
                    sum+=split.length;
                    if (sum <= (90 * 188)*4) {
                            list1.addAll(new ArrayList<String>(Arrays.asList(split)));
                    } else  {
                        if (sum <= (90 * 188) * 7) {
                            list2.addAll(new ArrayList<String>(Arrays.asList(split)));
                        } else {
                            list3.addAll(new ArrayList<String>(Arrays.asList(split)));
                        }
                    }
            }
        }
        System.out.println(sum);
        bufferedReader.close();// 关闭输入流
    }

    /**
     * 根据输出路径判断输出文件格式从而调用相应的方法输出对应的文件
     * @throws IOException
     */
    public static void write() throws Exception {
        if (writerFilePath.endsWith(".xlsx")) {
            writeExcel();
        } else if (writerFilePath.endsWith(".txt")) {
            writeTxt();
        } else {
            throw new Exception("输出文件格式错误: 请以txt或xlsx结尾");
        }
    }

    /**
     * DOC 写入信息
     * @throws IOException
     */
    private static void writeTxt() throws IOException {
        File file = new File(writerFilePath);// 指定要写入的文件
        if (!file.exists()) {// 如果文件不存在则创建
            file.createNewFile();
        }
        // 获取该文件的缓冲输出流
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        //层号
        int layerNumber = 1;
        //行号
        int lineNumber = 1;
        //列号
        int columnNumber = 0;
        // 写入信息
        for (int i = 0; i < list1.size(); i++) {
            columnNumber++;
            if (columnNumber > columnSum) {
                columnNumber = 1;
                lineNumber++;
            }
            if (lineNumber > lineSum) {
                lineNumber = 1;
                layerNumber++;
            }
            if (list2.size() <= i) {
                list2.add(i,"0");
            }
            if (list3.size() <= i) {
                list3.add(i,"0");
            }
            bufferedWriter.write("层号 :"+layerNumber+" 行号:"+lineNumber+" 列号"+columnNumber+"  "+list1.get(i)+"  "+list2.get(i)+"  "+list3.get(i));
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();// 清空缓冲区
        bufferedWriter.close();// 关闭输出流
    }

    /**
     * 根据config.properties配置文件设置相关参数
     */
    private static void getConfig() throws IOException {
        Properties properties = new Properties();
        // 使用ClassLoader加载properties配置文件生成对应的输入流
        InputStream in = ClassLoader.getSystemResourceAsStream("config2.properties");
        // 使用properties对象加载输入流
        properties.load(in);
        //获取key对应的value值
        writerFilePath = properties.getProperty("writerFilePath");
        readerFilePath = properties.getProperty("readerFilePath");
        lineSum = Integer.valueOf(properties.getProperty("lineSum","90"));
        columnSum =Integer.valueOf(properties.getProperty("columnSum", "188"));
        //关闭输入流
        in.close();
    }

    /**
     * 使用 StringList 来写入Excel
     */
    private static void writeExcel() throws IOException {
        File file = new File(writerFilePath);// 指定要写入的文件
        if (!file.exists()) {// 如果文件不存在则创建
            file.createNewFile();
        }
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
        ExcelTypeEnum excelTypeEnum = ExcelTypeEnum.XLSX;
        Table table = new Table(0);
        List<List<String>> arrayLists = new ArrayList<>();
        //设置标题头
        List<String> headerList = new ArrayList<String>();
        headerList.add("层号 ");
        headerList.add("行号");
        headerList.add("列号");
        headerList.add("value1");
        headerList.add("value2");
        headerList.add("value3");
        arrayLists.add(headerList);
        //层号
        int layerNumber = 1;
        //行号
        int lineNumber = 1;
        //列号
        int columnNumber = 0;
        // 写入信息
        for (int i = 0; i < list1.size(); i++) {
            columnNumber++;
            if (columnNumber > columnSum) {
                columnNumber = 1;
                lineNumber++;
            }
            if (lineNumber > lineSum) {
                lineNumber = 1;
                layerNumber++;
            }
            if (list2.size() <= i) {
                list2.add(i,"0");
            }
            if (list3.size() <= i) {
                list3.add(i,"0");
            }
            List<String> lineList = new ArrayList<String>();
            lineList.add(String.valueOf(layerNumber));
            lineList.add(String.valueOf(lineNumber));
            lineList.add(String.valueOf(columnNumber));
            lineList.add(list1.get(i));
            lineList.add(list2.get(i));
            lineList.add(list3.get(i));
            arrayLists.add(lineList);
        }
        //这里指定不需要表头，因为String通常表头已被包含在data里
        ExcelWriter writer = new ExcelWriter(outputStream, excelTypeEnum,false);
        //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系,无表头
        Sheet sheet1 = new Sheet(0, 0);
        writer.write0(arrayLists,sheet1,table);
        writer.finish();
    }

}
