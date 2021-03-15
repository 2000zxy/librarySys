package com.zxy.controller;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Company: 宝鸡大学
 * @author: 大宝
 * @date: 2021/3/9
 * @time: 14:52
 */
@WebServlet("/pic")
public class PicServlet extends HttpServlet {
    private String source = "abcdefghijkmnopqrstuvwxyz0123456789";

    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
        arg1.setContentType("image/jpeg");

        BufferedImage buffer = new BufferedImage(100, 50, BufferedImage.TYPE_INT_RGB);// 画布
        Graphics g = buffer.getGraphics();// 画笔
        g.setColor(Color.blue);// 选色
        g.fillRect(0, 0, 100, 50);// 上色

        g.setColor(Color.white);
        g.setFont(new Font("宋体", Font.BOLD, 30));
        String checkcode=getCode(4);
        HttpSession session=arg0.getSession();
        session.setAttribute("code", checkcode);
        g.drawString(checkcode, 10, 40);

        Random r = new Random();
        for (int i = 1; i <= 5; i++) {
            g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
            g.drawLine(r.nextInt(100), r.nextInt(50), r.nextInt(100), r.nextInt(50));
        }
        g.dispose();// 放下画笔

        JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(arg1.getOutputStream());
        en.encode(buffer);
    }

    /*
     * 返回len个长度字符串
     */
    private String getCode(int len) {
        Random r = new Random();
        char[] cc = new char[len];
        for (int i = 1; i <= len; i++) {
            // char c = source.charAt(r.nextInt(source.length()));//
            // 从字符串的随机下标中取出一个字符
            cc[i-1] = source.charAt(r.nextInt(source.length()));
        }
        return new String(cc, 0, len);//['a','c','o','a']-->"acoa"
    }
}
