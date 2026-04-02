CREATE TABLE student (
    stu_id INT,
    stu_name VARCHAR(50) primary key,
    age INT,
	mark INT
);
drop table student 
select * from  student
insert into student values(101,'arun',18,85),(102,'bala',19,72),
(103,'charan',20,91),(104,'dinesh',17,65),(105,'ezhil',18,88)

select * from student where mark<70

update student set mark=80 where stu_name='bala'
delete from student where stu_name= 'dinesh'


CREATE TABLE employees (
    emp_id INT ,
    emp_name VARCHAR(50) NOT NULL,
    emp_role VARCHAR(50) NOT NULL,
    salary INT 
);
INSERT INTO employees 
VALUES 
    (201, 'Ravi', 'Manager', 50000),
    (202, 'Kumar', 'Developer', 30000),
    (203, 'Siva', 'Tester', 25000),
    (204, 'Mani', 'Clerk', 15000),
    (205, 'Raj', 'HR', 20000);
select *from employees 	

SELECT * FROM employees 
WHERE salary > 25000;

UPDATE employees 
SET salary = 35000 
WHERE emp_name = 'Kumar';

DELETE FROM employees 
WHERE emp_name = 'Mani';

CREATE TABLE products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(50) NOT NULL,
    price INT ,
    stock INT 
);

select * from products

INSERT INTO products VALUES 
    (301, 'Pen', 10, 100),
    (302, 'Book', 50, 200),
    (303, 'Bag', 500, 50),
    (304, 'Bottle', 150, 0),
    (305, 'Box', 80, 20);

SELECT * FROM products 
WHERE stock = 0;

UPDATE products 
SET price = 550 
WHERE product_name = 'Bag';


DELETE FROM products 
WHERE product_name = 'Pen';

create table  order_table(
order_id int,customer_name varchar(50),
product_name varchar(50),quantity int,
status for match ref as to

)




