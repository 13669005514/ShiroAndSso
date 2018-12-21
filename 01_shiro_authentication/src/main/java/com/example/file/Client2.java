package com.example.file;

import java.io.IOException;

/**
 * @Description:
 * 读取指定文件 按格式排放
 * @Auther: zhangfx
 * @Date: 2018/12/18/ 11:41
 */
public class Client2 {

    public static void main(String[] args) throws IOException {
        try {
            //读取文件
            FileUntil2.read();
            System.out.println(FileUntil2.list1.size());
            System.out.println(FileUntil2.list2.size());
            System.out.println(FileUntil2.list3.size());
            //写入文件
            FileUntil2.write();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
