create database softpay;
use softpay;

create table usuario(
id int unsigned auto_increment not null,
nome varchar(100) not null,
email varchar(100),
cpf int(11) not null,
senha varchar(45) not null,
tipo varchar(15) not null,
primary key(id)
)engine=innodb;

drop table usuario;

select * from usuario;