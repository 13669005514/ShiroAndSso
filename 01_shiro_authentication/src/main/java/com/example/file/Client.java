package com.example.file;

import java.io.IOException;

/**
 * @Description:
 * 读取指定文件 按格式排放
 * @Auther: zhangfx
 * @Date: 2018/12/18/ 11:41
 */
public class Client {

    public static void main(String[] args) throws IOException {
        try {
            //读取文件
            FileUntil.read();
            //写入文件
            FileUntil.write();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" ");
    }



}
