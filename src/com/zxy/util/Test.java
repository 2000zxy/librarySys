package com.zxy.util;

/**
 * @Company: 宝鸡大学
 * @author: 大宝
 * @date: 2021/3/9
 * @time: 23:28
 */
public class Test {
    @org.junit.Test
    public void test(){
        int i = "adeff".indexOf("ef");
        String sql="select count(*) from book limit 1,3";
        System.out.println("select count(*)"+sql.substring(sql.indexOf(" from ")));

    }
}
