package com.zxy.entity;

import java.util.Date;

/**
 * @Company: 宝鸡大学
 * @author: 大宝
 * @date: 2021/3/8
 * @time: 12:56
 */
public class Book {
    private int book_id;
    private String book_code;
    private String book_name;
    private int type_id;
    private String book_author;
    private String publish_press;
    private Date publish_date;
    private int is_borrow;
    private String createBy;
    private Date creation_time;
    private Date last_updatetime;
    private String type_name;
    private String book_img;

    public String getBook_img() {
        return book_img;
    }

    public void setBook_img(String book_img) {
        this.book_img = book_img;
    }

    public Book() {
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_code() {
        return book_code;
    }

    public void setBook_code(String book_code) {
        this.book_code = book_code;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int book_type) {
        this.type_id = book_type;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getPublish_press() {
        return publish_press;
    }

    public void setPublish_press(String publish_press) {
        this.publish_press = publish_press;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public int getIs_borrow() {
        return is_borrow;
    }

    public void setIs_borrow(int is_borrow) {
        this.is_borrow = is_borrow;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(Date creation_time) {
        this.creation_time = creation_time;
    }

    public Date getLast_updatetime() {
        return last_updatetime;
    }

    public void setLast_updatetime(Date last_updatetime) {
        this.last_updatetime = last_updatetime;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_code='" + book_code + '\'' +
                ", book_name='" + book_name + '\'' +
                ", book_type=" + type_id +
                ", book_author='" + book_author + '\'' +
                ", publish_press='" + publish_press + '\'' +
                ", publish_date=" + publish_date +
                ", is_borrow=" + is_borrow +
                ", createBy='" + createBy + '\'' +
                ", creation_time=" + creation_time +
                ", last_updatetime=" + last_updatetime +
                ", type_name='" + type_name + '\'' +
                ", book_img='" + book_img + '\'' +
                '}';
    }
}
