package com.zxy.listenter; /**
 * @Company: 宝鸡大学
 * @author: 大宝
 * @date: 2021/3/7
 * @time: 21:08
 */

import com.zxy.util.Config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@WebListener()
public  class LoadListener implements ServletContextListener {

    private void loadConfig(String file) {
        Properties properties = new Properties();
        InputStream s = this.getClass().getResourceAsStream(file);
        try {
            properties.load(s);
            Config.properties = properties;
//            System.out.println(Config.properties.getProperty("mysql_driver"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void contextInitialized(ServletContextEvent sce) {
//        System.out.println("========监听器=======");
        String file = sce.getServletContext().getInitParameter("file");
//        System.out.println(file);
        loadConfig(file);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }


}
