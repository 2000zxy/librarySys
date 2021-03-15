package com.zxy.dao;

import com.zxy.entity.Book;
import com.zxy.util.PageBean;

/**
 * @Company: 宝鸡大学
 * @author: 大宝
 * @date: 2021/3/8
 * @time: 12:56
 */
public interface BookDao {
    public int insert_book(Book book);
    public int del_book(int book_id);
    public int update_state(int book_id,int update_id);
    public PageBean<Book> selectByPage(int curPage,Book book);
    public int update_book(Book book);
}
