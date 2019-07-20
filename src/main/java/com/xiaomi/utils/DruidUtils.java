package com.xiaomi.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Li Enzhen
 * 2019/6/27 0027 下午 4:37
 */
public class DruidUtils {
    private static DruidDataSource dataSource;
    static {
        try {//1.加载配置文件
            InputStream is = DruidUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(is);
            //2.初始化
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("初始化连接池失败");

        }
    }
    public  static DataSource getDataSource(){

        return dataSource;
    }
}
