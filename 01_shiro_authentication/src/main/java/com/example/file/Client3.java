package com.example.file;

import java.io.IOException;

/**
 * @Description:
 * 读取指定文件 按格式排放
 * @Auther: zhangfx
 * @Date: 2018/12/18/ 11:41
 */
public class Client3 {

    public static void main(String[] args) throws IOException {
        try {
            //读取文件
            FileUntil4.read();
            System.out.println(FileUntil4.map2);
            //System.out.println(FileUntil3.dataList);
            //System.out.println(FileUntil3.dataList);
            System.out.println("");
            //写入文件
            //FileUntil3.write();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
