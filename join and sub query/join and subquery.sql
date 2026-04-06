
CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR(100),
    city VARCHAR(100)
);

CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    amount DECIMAL(10,2)
);

INSERT INTO customers (customer_id, customer_name, city) VALUES 
(1, 'Raja', 'Chennai'), 
(2, 'Priya', 'Madurai'), 
(3, 'Karthik', 'Coimbatore');

INSERT INTO orders (order_id, customer_id, amount) VALUES 
(101, 1, 6000), 
(102, 2, 4000), 
(103, 3, 8000), 
(104, 1, 4500);

SELECT  o.order_id, c.customer_name, c.city, o.amount
FROM  orders o INNER JOIN  customers c ON o.customer_id = c.customer_id
WHERE  o.amount > 5000;




CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    amount DECIMAL(10,2)
);

INSERT INTO orders (order_id, customer_id, amount) VALUES 
(101, 1, 6000), 
(102, 2, 4000), 
(103, 3, 8000), 
(104, 1, 4500);


SELECT  order_id,  customer_id,  amount
FROM  orders WHERE  amount > (SELECT AVG(amount) FROM orders);


CREATE TABLE departments (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(100)
);

CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(100),
    dept_id INT,
    salary DECIMAL(10,2)
);

INSERT INTO departments (dept_id, dept_name) VALUES 
(10, 'HR'), 
(20, 'IT'), 
(30, 'Finance');

INSERT INTO employees (emp_id, emp_name, dept_id, salary) VALUES 
(1, 'Arun', 10, 35000),  
(2, 'Bala', 10, 25000),  
(3, 'Chitra', 20, 45000); 

SELECT  e.emp_name,d.dept_name, e.salary FROM (SELECT * FROM employees WHERE salary > 30000) e
INNER JOIN (SELECT * FROM departments WHERE dept_name = 'HR') d ON  e.dept_id = d.dept_id;
