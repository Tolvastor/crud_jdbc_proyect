create  database crud_jdbc_proyect;
create table user
(
    id       int auto_increment
        primary key,
    username varchar(250) not null,
    password varchar(255) not null
);

