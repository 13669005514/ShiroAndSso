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
public class FileUntil4 {
    //读取文件路径
    private static String readerFilePath = null;
    //写入文件路径
    private static String writerFilePath = null;
    //分组方式
    private static String groupFormat = null;
    //设置每层行数
    private static int lineSum = 0;
    //设置每层列数
    private static int columnSum = 0;
    //每行列的数量
    private static List<String> columnNumbers = new ArrayList<>();;
    //每行数据的长度相加和
    private  int sum = 0;
    //标识当前到第几组数据
    private  int groupIndex = 0;
    //标识当前到第几组数据
    private  int groupIndex2 = 0;
    //存放分组layer数量
    private  Map<String,Integer> map = new HashMap<>();
    //存放分组layer数量2
    private  Map<String,List<String>> map2 = new HashMap<>();
    //使用方式一时存放分组列表
    private  List<String> groupList = new ArrayList<>();
    //存放全部数据
    private  List<List<String>> dataList = new ArrayList<>();
    //存放一层数据
    private  List<String> layerList = new ArrayList<>();
    /**
     * DOC 读取信息
     * @throws FileNotFoundException 文件不存在
     * @throws IOException IO异常
     */
    public  void read() throws Exception {
        //读取配置文件
        getConfig();
        if ("format1".equals(groupFormat)) {
            readGroupMethod01();
        } else if ("format2".equals(groupFormat)) {
            readGroupMethod02();
        } else {
            throw  new Exception("请配置正确的分组方式");
        }
    }

    /**
     * 按分组方式一存储数据
     *      分组方式一格式：
     * layer -1
     * layer -2
     * layer -3
     * --------------
     * layer -1
     * layer -2
     * .......
     * @throws IOException IO异常
     */
    private  void readGroupMethod01() throws IOException {
        File file = new File(readerFilePath);// 指定要读取的文件
        String line;// 用来保存每次读取一行的内容
        BufferedReader bufferedReader = null;
        try {
            // 获得该文件的缓冲输入流
            bufferedReader = new BufferedReader(new FileReader(file));
            while ((line = bufferedReader.readLine()) != null) {
                //1.去掉左右空格
                String trim = line.trim();
                if (line.contains("Layer")) {
                    trim = trim.substring(trim.length() - 1, trim.length());
                    System.out.println(trim);
                    if (groupList.contains(trim)) {
                        map2.put(String.valueOf(groupIndex), groupList);
                        groupList = new ArrayList<>();
                        groupIndex++;
                    }
                    groupList.add(trim);
                }
            }
            //将最后一个列表加入
            map2.put(String.valueOf(groupIndex), groupList);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭输入流
            bufferedReader.close();
        }
        //初始化groupIndex
        groupIndex=0;
        // 获得该文件的缓冲输入流
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader2 = new BufferedReader(new FileReader(file));
            while ((line = bufferedReader2.readLine()) != null) {
                //1.去掉左右空格
                String trim = line.trim();
                //忽略注释 和层数标识行
                if (trim.startsWith("#")||trim.contains("Layer")) {
                    continue;
                }
                String[] split = trim.split("\\s+");
                //只读取需要的数据
                if (columnNumbers.contains(String.valueOf(split.length))) {
                    sum+=split.length;
                    if (sum > (map2.get(String.valueOf(groupIndex)).size() * lineSum * columnSum)) {
                        sum = split.length;
                        groupIndex++;
                        dataList.add(layerList);
                        layerList = new ArrayList<>();
                    }
                    layerList.addAll(new ArrayList<String>(Arrays.asList(split)));
                }
            }
            //将最后一个列表数据存放到总数据中
            if (!dataList.contains(layerList)) {
                dataList.add(layerList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭输入流
            bufferedReader2.close();
        }
    }
    /**
     * 按分组方式一读取数据
     * 分组方式一格式：
     * layer -0
     * layer -0
     * layer -0
     * --------------
     * layer -1
     * layer -1
     * .......
     */
    private  void readGroupMethod02() throws IOException {
        File file = new File(readerFilePath);// 指定要读取的文件
        // 获得该文件的缓冲输入流
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            // 用来保存每次读取一行的内容
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                //1.去掉左右空格
                String trim = line.trim();
                if (line.contains("Layer")) {
                    trim = trim.substring(trim.length() - 1,trim.length());
                    Integer count = map.get(trim);
                    groupIndex2 = Integer.valueOf(trim);
                    map.put(trim,(count == null) ? 1 : count + 1);
                }
                //忽略注释 和层数标识行
                if (trim.startsWith("#")||trim.contains("Layer")) {
                    continue;
                }
                String[] split = trim.split("\\s+");
                //读取需要的数据
                if (columnNumbers.contains(String.valueOf(split.length))) {
                    sum+=split.length;
                    if (sum > (map.get(String.valueOf(groupIndex2)) * lineSum * columnSum)) {
                        sum = split.length;
                        dataList.add(layerList);
                        layerList = new ArrayList<>();
                    }
                    layerList.addAll(new ArrayList<>(Arrays.asList(split)));
                }
            }
            if (!dataList.contains(layerList)) {
                dataList.add(layerList);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭输入流
            bufferedReader.close();
        }
    }

    /**
     * 根据输出路径判断输出文件格式从而调用相应的方法输出对应的文件
     * @throws IOException IO
     */
    public  void write() throws Exception {
        if (writerFilePath.endsWith(".xlsx")) {
            writeExcel();
        } else if (writerFilePath.endsWith(".txt")) {
            writeTxt();
        } else {
            throw new Exception("输出文件格式错误： 请以txt或xlsx结尾");
        }
    }

    /**
     * DOC 写入信息txt文件
     * @throws IOException IO异常
     */
    private  void writeTxt() throws IOException {
        // 指定要写入的文件
        File file = new File(writerFilePath);
        // 如果文件不存在则创建
        if (!file.exists()) {
            file.createNewFile();
        }
        // 获取该文件的缓冲输出流
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
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
                StringBuilder sb = new StringBuilder();
                sb.append("层号：").append(layerNumber).append(" 行号： ").append(lineNumber).append(" 列号：").append(columnNumber).append("  ");
                for (int j = 0; j < dataList.size() ; j++) {
                    if (dataList.get(j).size() <= i) {
                        dataList.get(j).add(i,"0");
                   }
                    sb.append(dataList.get(j).get(i)).append("  ");
                }
                bufferedWriter.write(sb.toString());
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 清空缓冲区
            bufferedWriter.flush();
            // 关闭输出流
            bufferedWriter.close();
        }
    }

    /**
     * 根据config.properties配置文件设置相关参数
     */
    private  void getConfig() throws IOException {
        Properties properties = new Properties();
        // 使用ClassLoader加载properties配置文件生成对应的输入流
        InputStream in = null;
        try {
            in = ClassLoader.getSystemResourceAsStream("config3.properties");
            // 使用properties对象加载输入流
            properties.load(in);
            //获取key对应的value值
            writerFilePath = properties.getProperty("writerFilePath");
            readerFilePath = properties.getProperty("readerFilePath");
            lineSum =  Integer.valueOf(properties.getProperty("lineSum","90"));
            columnSum = Integer.valueOf(properties.getProperty("columnSum", "188"));
            groupFormat = properties.getProperty("groupFormat");
            String[] split = properties.getProperty("columnNumbers", "10,8").trim().split(",");
            columnNumbers.addAll(new ArrayList<>(Arrays.asList(split)));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭输入流
            in.close();
        }
    }

    /**
     * 写入excel表格
     * @throws IOException IO异常
     */
    private  void writeExcel() throws IOException {
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
