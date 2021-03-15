package com.zxy.controller;

import com.alibaba.fastjson.JSONObject;
import com.zxy.entity.Book;
import com.zxy.severice.BookService;
import com.zxy.severice.imp.BookServiceImp;
import com.zxy.util.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Company: 宝鸡大学
 * @author: 大宝
 * @date: 2021/3/7
 * @time: 21:10
 */
@WebServlet("/book")
public class BookServlet extends BaseServlet{
    private BookService service = new BookServiceImp();
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer curPage = req.getParameter("curPage")==null?0:Integer.parseInt(req.getParameter("curPage"));
        System.out.println(curPage);
        Book book = new Book();
        String book_author = req.getParameter("book_author");
        String is_borrow = req.getParameter("is_borrow");
        if(is_borrow==""){
            book.setIs_borrow(-1);
        }else if(is_borrow.equals("未借阅")){
            book.setIs_borrow(0);
        }else  {
            book.setIs_borrow(1);
        }
        String type_name = req.getParameter("type_name");

        book.setBook_author(book_author);
        book.setType_name(type_name);
        System.out.println("=="+book_author+"=="+is_borrow+"=="+type_name+"==");
        PageBean<Book> bookPageBean = service.queryByPage(curPage,book);
        System.out.println(curPage);
        System.out.println(bookPageBean);
        resp.getWriter().print(JSONObject.toJSON(bookPageBean));
    }
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    protected void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    protected void borrow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService service = new BookServiceImp();
        Integer id = Integer.valueOf(req.getParameter("book_id"));
        Integer update_id = Integer.valueOf(req.getParameter("update_id"));
        int borrow = service.borrow(id,update_id);
        System.out.println(borrow);
        resp.getWriter().print(borrow);
    }

}
