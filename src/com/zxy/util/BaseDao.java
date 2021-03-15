package com.zxy.util;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Company: 宝鸡大学
 * @author: 大宝
 * @date: 2021/3/7
 * @time: 21:04
 */
public class BaseDao {
    private Connection conn;
    private PreparedStatement pre;
    private ResultSet res;
   protected  int update(String sql,Object... params){
       conn = DBUtil.getConn();
       try {
           pre = conn.prepareStatement(sql);
           for (int i = 0; i < params.length; i++) {
               pre.setObject(i+1,params[i]);
           }
           int i = pre.executeUpdate();
           return i;
       } catch (Exception throwables) {
           throwables.printStackTrace();
       }finally {
           DBUtil.close();
       }
       return 0;
   }
   protected int queryCount(String sql,Object...params){
       conn = DBUtil.getConn();
       try {
           pre = conn.prepareStatement("select count(*)"+sql.substring(sql.indexOf(" from ")));
           System.out.println("select count(*)"+sql.substring(sql.indexOf(" from ")));
           for (int i = 0; i < params.length; i++) {
               pre.setObject(i+1,params[i]);
           }
           res = pre.executeQuery();
           int count=0;
           while (res.next()){
               count = res.getInt(1);
           }
           return count;
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }finally {
           DBUtil.close();
       }
       return 0;
   }
   protected <T> List<T> query(Class<T> aclass,String sql, Object...params){
       conn = DBUtil.getConn();
       List<T> list = new ArrayList<>();
       try {
           pre = conn.prepareStatement(sql);
           for (int i = 0; i < params.length; i++) {
               pre.setObject(i+1,params[i]);
           }
           res = pre.executeQuery();
           ResultSetMetaData metaData = res.getMetaData();
           int count = metaData.getColumnCount();
           while (res.next()){
                   T t  = aclass.getConstructor().newInstance();
                   for (int i = 0; i < count; i++) {
                       String columnName = metaData.getColumnName(i + 1);
                       Class<?> type = aclass.getDeclaredField(columnName).getType();
                       Method method = aclass.getDeclaredMethod("set" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1), type);
                       method.invoke(t,res.getObject(i+1));
                   }
                   list.add(t);
           }
           return list;
       } catch (Exception throwables) {
           throwables.printStackTrace();
       }finally {
           DBUtil.close();
       }
       return null;
   }

}
