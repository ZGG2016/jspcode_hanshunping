create table userss
(
    id     int primary key auto_increment comment '编号',
    name   varchar(50)   not null comment '用户名',
    passwd varchar(50)   not null comment '密码',
    email  varchar(100)  not null comment '邮箱',
    phone  varchar(100)  not null comment '电话',
    grade  int default 1 not null comment '等级'
) auto_increment = 1;

insert into userss
(name, passwd, email, phone, grade)
values
    ('test01', 'test01', 'test01@sohu.com', '111', 1),
    ('test02', 'test02','test02@sohu.com', '112', 1),
    ('test03', 'test03','test03@sohu.com', '113', 2),
    ('test04', 'test04','test04@sohu.com', '114', 2),
    ('test05', 'test05','test05@sohu.com', '115', 3),
    ('test06', 'test06','test06@sohu.com', '116', 3),
    ('test07', 'test07','test07@sohu.com', '117', 4),
    ('test08', 'test08','test08@sohu.com', '118', 4);

create table books
(
    id           int primary key auto_increment comment '编号',
    name         varchar(50)      not null comment '书名',
    author       varchar(100)     not null comment '作者',
    publishHouse varchar(100)     not null comment '出版社',
    price        int              not null comment '价格',
    nums         int default 1000 not null comment '库存'
) auto_increment = 1;

insert into books
(name, author, publishHouse, price, nums)
values
    ('book01', 'book01','book01@sohu.com', '111', 111),
    ('book02', 'book02','book02@sohu.com', '112', 222),
    ('book03', 'book03','book03@sohu.com', '113', 333),
    ('book04', 'book04','book04@sohu.com', '114', 444),
    ('book05', 'book05','book05@sohu.com', '115', 555),
    ('book06', 'book06','book06@sohu.com', '116', 666),
    ('book07', 'book07','book07@sohu.com', '117', 777),
    ('book08', 'book08','book08@sohu.com', '118', 888);

-- 订单表
create table orders
(
    ordid      int primary key auto_increment comment '订单编号',
    userid     int                        not null comment '下订单的用户编号',
    totalPrice float default 0            not null comment '订单总价格',
    ordTime  TIMESTAMP  default CURRENT_TIMESTAMP not null comment '订单时间',
    constraint user_id_fk foreign key (userid) references userss (id)
) auto_increment = 1;

-- 订单细节表(该订单买了什么商品)
create table orderitem
(
    id      int primary key auto_increment comment '增长的编号',
    ordid int not null comment '订单编号',
    bookid  int comment '书籍编号',
    booknum int default 0 not null comment '书的数量',
    constraint ord_id_fk foreign key (ordid) references orders (ordid),
    constraint book_id_fk foreign key (bookid) references books (id)
) auto_increment = 1;









































