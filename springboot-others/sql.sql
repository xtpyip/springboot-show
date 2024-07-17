create database springbootdata;
use springbootdata;
drop table if exists t_article;
create table t_article(
    id int(20) not null auto_increment comment '文章id',
    title varchar(200) default null comment "文章标题",
    content longtext comment '文章内容',
    primary key(id)
)Engine=Innodb auto_increment=2 default charset=utf8;

INsert into t_article values ('1','Spring Boot基础入门','从入门到精通');
INsert into t_article values ('2','Spring cloud基础入门','从入门到精通');

drop table if exists t_comment;
create table t_comment(
    id int(20) not null auto_increment comment '评论id',
    content longtext comment '评论内容',
    author varchar(200) default null comment '评论作者',
    a_id int(20) default null comment '关联的文章id',
    primary key (id)
)Engine=Innodb auto_increment=2 default charset=utf8;
INsert into t_comment values ('1','很全，很详细','luccy','1');
INsert into t_comment values ('2','赞一个','tom','1');
INsert into t_comment values ('3','很详细','eric','1');
INsert into t_comment values ('4','很好，非常详细','张三','1');
INsert into t_comment values ('5','很不错','李四','2');