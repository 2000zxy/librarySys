package com.zxy.dao.imp;

import com.zxy.dao.BookDao;
import com.zxy.entity.Book;
import com.zxy.util.BaseDao;
import com.zxy.util.PageBean;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Company: 宝鸡大学
 * @author: 大宝
 * @date: 2021/3/8
 * @time: 12:56
 */
public class BookDaoImp extends BaseDao implements BookDao {
    @Override
    public int insert_book(Book book) {
        return 0;
    }

    @Override
    public int del_book(int book_id) {
        return 0;
    }

    @Override
    public int update_state(int book_id,int update_id) {
        String sql = "update book_info set is_borrow =? where book_id=?";
//        int id=!book_id;
        int update = update(sql, update_id, book_id);
        System.out.println(sql+"===="+update_id+"==="+book_id);
        return update;
    }

    @Override
    public PageBean<Book> selectByPage(int curPage,Book book) {
        PageBean<Book> pageBean = new PageBean<>();
        String sql="select * from book_info left join book_type on book_info.type_id=book_type.type_id where 1=1";
        pageBean.setCurPage(curPage);
        List<Object> params = new ArrayList<>();
        if(!book.getBook_author().isEmpty()){
            sql += " and book_author like ?";
            params.add("%"+book.getBook_author()+"%");
        }
        if(!book.getType_name().isEmpty()){
            sql += " and type_name like ?";
            params.add("%"+book.getType_name()+"%");
        }if(book.getIs_borrow()!=-1){
            sql += " and is_borrow=?";
            params.add(book.getIs_borrow());
        }

        pageBean.setTotalRows(getCount(sql,params.toArray()));
        pageBean.page();
        sql+=" order by book_id asc limit ?,?";
        params.add(pageBean.getStart());
        params.add(pageBean.getRowsPageCount());
        System.out.println(sql+"----"+params);
        List<Book> list = query(Book.class, sql, params.toArray());
        pageBean.setList(list);
        return pageBean;
    }
//    alter table book_type change id type_id
    public int getCount(String sql, Object...params){
        int query = queryCount(sql,params);
        return query;
    }
    @Override
    public int update_book(Book book) {
        return 0;
    }
}
