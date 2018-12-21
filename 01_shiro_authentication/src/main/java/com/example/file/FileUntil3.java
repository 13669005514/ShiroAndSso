package com.example.file;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.*;
import java.util.*;

/**
 * @Description:
 * 读取指定文件对数据处理输出为文本或表格
 * @Auther: zhangfx
 * @Date: 2018/12/18/ 11:43
 */
public class FileUntil3 {

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
    //标识当前到第几面数据
    private static String index = null;
    //存放分组layer数量
    public static Map<String,Integer> map = new HashMap<>();
    //存放全部数据
    public static List<List<String>> dataList = new ArrayList<>();
    //存放一层数据
    public static List<String> layerList = new ArrayList<>();
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
            if (line.indexOf("Layer") != -1) {
                trim = trim.substring(trim.length() - 1,trim.length());
                Integer count = map.get(trim);
                index = trim;
                System.out.println(index);
                map.put(trim,(count == null) ? 1 : count + 1);
            }
            String[] split = trim.split("\\s+ ");
            //只读取需要的数据
            if (split.length == 8 || split.length == 10) {
                sum+=split.length;
                if (sum > (map.get(String.valueOf(index)) * 90 * 188)) {
                    System.out.println((map.get(String.valueOf(index)) * 90 * 188));
                    sum = 0;
                    dataList.add(layerList);
                    layerList = new ArrayList<>();
                }
                layerList.addAll(new ArrayList<String>(Arrays.asList(split)));
            }
        }
        if (!dataList.contains(layerList)) {
            dataList.add(layerList);
        }
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
            throw new Exception("输出文件格式错误:  请以txt或xlsx结尾");
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
        for (int i = 0; i < dataList.get(0).size(); i++) {
            columnNumber++;
            if (columnNumber > columnSum) {
                columnNumber = 1;
                lineNumber++;
            }
            if (lineNumber > lineSum) {
                lineNumber = 1;
                layerNumber++;
            }
            StringBuffer sb = new StringBuffer();
            sb.append("层号：").append(layerNumber).append(" 行号：").append(lineNumber).append(" 列号：").append(columnNumber).append("  ");
            for (int j = 0; j < dataList.size() ; j++) {
                if (dataList.get(j).size() <= i) {
                    dataList.get(j).add(i,"0");
               }
                sb.append(dataList.get(j).get(i)).append("  ");
            }
            bufferedWriter.write(sb.toString());
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
        InputStream in = ClassLoader.getSystemResourceAsStream("config3.properties");
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
        //层号
        int layerNumber = 1;
        //行号
        int lineNumber = 1;
        //列号
        int columnNumber = 0;
        // 写入信息
        for (int i = 0; i < dataList.get(0).size(); i++) {
            columnNumber++;
            if (columnNumber > columnSum) {
                columnNumber = 1;
                lineNumber++;
            }
            if (lineNumber > lineSum) {
                lineNumber = 1;
                layerNumber++;
            }
            List<String> lineList = new ArrayList<String>();
            lineList.add(String.valueOf(layerNumber));
            lineList.add(String.valueOf(lineNumber));
            lineList.add(String.valueOf(columnNumber));
            for (int j = 0; j < dataList.size() ; j++) {
                if (dataList.get(j).size() <= i) {
                    dataList.get(j).add(i,"0");
                }
                lineList.add(dataList.get(j).get(i));
            }
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
