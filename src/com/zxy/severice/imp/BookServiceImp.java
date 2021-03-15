package com.zxy.severice.imp;

import com.zxy.dao.BookDao;
import com.zxy.dao.imp.BookDaoImp;
import com.zxy.entity.Book;
import com.zxy.severice.BookService;
import com.zxy.util.PageBean;

import java.util.List;

/**
 * @Company: 宝鸡大学
 * @author: 大宝
 * @date: 2021/3/8
 * @time: 12:58
 */
public class BookServiceImp implements BookService {
   private BookDao dao = new BookDaoImp();
    @Override
    public PageBean<Book> queryByPage(int curPage,Book book) {
        PageBean<Book> pageBean = dao.selectByPage(curPage,book);
        List<Book> list = pageBean.getList();
//        for (Book book : list) {
//            if(book.getIs_borrow()==0){
//                book.setIs_borrow("");
//            }
//        }

        return pageBean;
//        return null;
    }

    @Override
    public int add_book(Book book) {
        return 0;
    }

    @Override
    public int del_book(int book_id) {
        return 0;
    }

    @Override
    public int borrow(int book_id,int update_id) {
        BookDao bookDao = new BookDaoImp();
        int i = bookDao.update_state(book_id,update_id);
        return i;
    }

    @Override
    public int update_book(Book book) {
        return 0;
    }
}
