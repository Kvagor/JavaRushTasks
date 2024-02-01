drop table if exists users;

create table users
(
    user_id    int not null auto_increment primary key,
    first_name varchar(255) not null ,
    last_name  varchar(255) not null ,
    date date not null default (curdate()),
    weight float(10)

);
