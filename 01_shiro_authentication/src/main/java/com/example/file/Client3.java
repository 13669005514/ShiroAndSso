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
            FileUntil4 fileUntil4 = new FileUntil4();
            //读取文件
            fileUntil4 .read();
            //写入文件
            fileUntil4 .write();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }



}
