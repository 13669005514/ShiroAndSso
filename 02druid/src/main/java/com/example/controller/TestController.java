package com.example.controller;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.example.controller.config.DBPoolConnection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description:
 * @author: fxzhang
 * @Date: 2019/1/22 21:16
 */

@RestController
public class TestController {

    @GetMapping("/hello")
    public String say() {
        try {
            DruidPooledConnection connection = DBPoolConnection.getInstance().getConnection();
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = connection.createStatement();
            //要执行的SQL语句
            String sql = "select * from user";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            String job = null;
            String id = null;
            while(rs.next()){
                //获取stuname这列数据
                job = rs.getString("id");
                //获取stuid这列数据
                id = rs.getString("loginName");

                //输出结果
                System.out.println(id + "\t" + job);
            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "hello";
    }

}
