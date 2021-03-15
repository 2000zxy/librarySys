package com.zxy.severice;

import com.zxy.entity.Book;
import com.zxy.util.PageBean;

/**
 * @Company: 宝鸡大学
 * @author: 大宝
 * @date: 2021/3/8
 * @time: 12:57
 */
public interface BookService {
    public PageBean<Book> queryByPage(int curPage,Book book);
    public int add_book(Book book);
    public int del_book(int book_id);
    public int borrow(int book_id,int update_id);
    public int update_book(Book book);
}
