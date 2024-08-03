use springboot-dao;
create table tbl_user(
                         id int(11) not null auto_increment,
                         name varchar(20) not null,
                         tel varchar(20) null,
                         PRIMARY KEY(id)
);