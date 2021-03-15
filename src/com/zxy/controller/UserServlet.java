package com.zxy.controller;

import com.zxy.entity.User;
import com.zxy.severice.UserService;
import com.zxy.severice.imp.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Company: 宝鸡大学
 * @author: 大宝
 * @date: 2021/3/7
 * @time: 21:07
 */
@WebServlet("/users")
public class UserServlet extends BaseServlet {
    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_code = request.getParameter("user_code");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        PrintWriter out  = response.getWriter();
        User user = new User();
        user.setEmail(email);
        user.setUser_code(user_code);
        user.setPassword(pass);
        user.setGender(gender);
        UserService service = new UserServiceImp();
        int register = service.register(user);
        if(register==0){
            out.print("<script>alert('注册失败');window.location.href='login.jsp'</script>");
        }else {
            out.print("<script>alert('注册成功');window.location.href='login.jsp'</script>");
        }
    }
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(123);
        String user_code = req.getParameter("user_code");
        String password = req.getParameter("password");
        String code = req.getParameter("usrcode");
        PrintWriter out  = resp.getWriter();
        HttpSession session = req.getSession();
        UserService service = new UserServiceImp();
        User loginUser = service.login(user_code, password);
        if(loginUser==null){
            out.print("<script>alert('用户名或密码有误');window.location.href='login.jsp'</script>");
        }else {
            String session_code = (String) session.getAttribute("code");
            if(session_code.equals(code)){
                session.setAttribute("user",loginUser);

                out.print("<script>$(document).ready(function(){alert('登陆成功');window.location.href='index.jsp'})</script>");
                resp.sendRedirect("index.jsp");
            }else {
                out.print("<script>alert('验证码有误');window.location.href='login.jsp'</script>");
            }

        }
    }
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session!=null){
            session.invalidate();
            resp.sendRedirect("login.jsp");
        }
    }
    protected void checkUser_code(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_code = req.getParameter("user_code");
        UserService service = new UserServiceImp();
        boolean b = service.check_user_code(user_code);
        System.out.println(b);
        resp.getWriter().print(b);
    }

}