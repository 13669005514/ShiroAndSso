package com.example.file;

import java.io.*;

/**
 * @Description:
 * @Auther: zhangfx
 * @Date: 2018/12/18/ 11:43
 */
public class FileUntil {
    /**
     * DOC 读取信息.
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void read() throws FileNotFoundException, IOException {
        File file = new File("G:\\springBoot\\ShiroAndSso\\01_shiro_authentication\\src\\resouces\\JHQ.BAS");// 指定要读取的文件
        // 获得该文件的缓冲输入流
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = "";// 用来保存每次读取一行的内容
        while ((line = bufferedReader.readLine()) != null) {
            String trim = line.trim();
            //System.out.println(line.trim());
            if (trim.indexOf("Layer 1") != -1) {
                System.out.println(trim);
            }
        }
        bufferedReader.close();// 关闭输入流
    }

    /**
     * DOC 写入信息.
     *
     * @throws IOException
     */
    public static void write() throws IOException {
        File file = new File("E:\\a.txt");// 指定要写入的文件
        if (!file.exists()) {// 如果文件不存在则创建
            file.createNewFile();
        }
        // 获取该文件的缓冲输出流
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        // 写入信息
        bufferedWriter.write("你好世界");
        bufferedWriter.newLine();// 表示换行
        bufferedWriter.write("hello world");
        bufferedWriter.flush();// 清空缓冲区
        bufferedWriter.close();// 关闭输出流
    }



}
