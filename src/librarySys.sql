create database librarySys;
create table book_info(
    book_id int primary key auto_increment,
    boook_code varchar(50) not null,
    book_name varchar(50) not null,
    book_type int not null,
    book_author varchar(20) not null,
    publish_press varchar(200) not null,--出版社
    publish_date date not null,
    is_borrow int not null,-- 是否借阅
    createBy varchar(50) not null,--创建人
    creation_time date not null,-- 创建时间
    last_updatetime date not null-- 最新更新时间
);


insert into book_info values(null,"x001","朝花夕拾",1,"鲁迅","北京出版社","1928-01-01",0,"张三",now(),now());
create table book_type(
    id int primary key auto_increment,
    type_name varchar(20) not null
);
create table users(
    user_id int primary key auto_increment,
    user_code varchar(50) not null,
    password varchar(6) not null,
    email varchar(50) not null,
    gender varchar(7) not null,
    register_time date not null,
    last_logintime date not null-- 最后登录日期
);
insert into users values(null,"001","123456","001@163.com","女",now(),now());
insert into book_type values(null,"小说");
ALTER table add book_img varchar(225);