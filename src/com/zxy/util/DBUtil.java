package com.zxy.util;

import java.sql.*;

/**
 * @Company: 宝鸡大学
 * @author: 大宝
 * @date: 2021/3/8
 * @time: 17:22
 */
public class DBUtil {
    private static String driver = Config.properties.getProperty("mysql_driver");
    private static String url = Config.properties.getProperty("mysql_url");
    private static String user = Config.properties.getProperty("mysql_user");
    private static String pass = Config.properties.getProperty("mysql_pass");
    private static Connection con;
    private static PreparedStatement pre;
    private static ResultSet res;
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn(){
//        System.out.println(driver);
        try {
            con = DriverManager.getConnection(url, user, pass);
            return con;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void test(){
        getConn();
    }
    public static void close(){
        try{
            if(res!=null){
                res.close();
            }
            if(pre!=null){
                pre.close();
            }
            if(con!=null){
                con.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
