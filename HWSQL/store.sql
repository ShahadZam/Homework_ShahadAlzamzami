#DDl
#1
create database store;

create table countries(
    code int primary key ,
    name varchar(20) UNIQUE ,
    continent_name varchar(20) not null
);

Create table users(
    id int primary key ,
    full_name varchar(20),
    email varchar(20) unique,
    gender char(1) check ( gender='f' or gender='m' ),
    date_of_birth varchar(15),
    created_at datetime default now(),
    country_code int,
    foreign key(country_code) references countries(code)
);

create table orders(
    id int primary key,
    user_id int,
    status varchar(6) check (status='start' or status='finish'),
    creaated_at datetime,
    foreign key (user_id) references users(id)
);

create table products(
    id int primary key ,
    name varchar(10) not null ,
    price int default(0),
    status varchar(10) check (status='valid' or status='expired'),
    created_at datetime
);

create table order_products(
    order_id int,
    product_id int,
    quantity int default 0,
    primary key (order_id,product_id),
    foreign key (order_id) references orders(id),
    foreign key (product_id) references products(id)
);


alter table users modify created_at datetime default(CURRENT_TIMESTAMP);
alter table orders modify creaated_at datetime default(CURRENT_TIMESTAMP);
alter table products modify created_at datetime default(CURRENT_TIMESTAMP);

#DML
#Add new row to the countries table.
insert into countries values (100,'Saudi Arabia','Asia');
# Add new row to the users table.
insert into users values(11,'Shahad','s@s.s','f','01-09-1990',CURRENT_TIMESTAMP,100);
# Add new row to the orders table.
insert into orders values (2,11,'start',null);
# Add new row to the products table.
insert into products values (10,'book',5,'valid',now());
insert into products values (11,'toy',15,'valid',now());

# Add new row to the order_products table.
insert into order_products values (2,10,90);
# Update row from countries table.
update countries set name='SA' where code=100;
# Delete row from products table.
delete from products where id=11;

select * from countries;
select * from users;
select * from orders;
select * from products;
select * from order_products;