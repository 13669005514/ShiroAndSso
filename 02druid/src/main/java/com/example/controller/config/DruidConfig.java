package com.example.controller.config;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @Description:
 * @author: fxzhang
 * @Date: 2019/1/22 21:34
 */
public class DruidConfig {

    public DruidDataSource getDruidData(DruidDataSource druidDataSource) {
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("zfx980912");
        return druidDataSource;
    }


}
