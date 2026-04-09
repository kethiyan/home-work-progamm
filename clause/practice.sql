
CREATE TABLE department (
    dept_id INT ,
    dept_name VARCHAR(50),
    location VARCHAR(50)
);

INSERT INTO department VALUES
(10, 'IT', 'Chennai'),
(20, 'HR', 'Bangalore'),
(30, 'Sales', 'Mumbai'),
(40, 'Marketing', 'Delhi');

CREATE TABLE employee (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50),
    salary DECIMAL(10, 2),
    age INT,
    dept_id INT,
    job_role VARCHAR(50),
    FOREIGN KEY (dept_id) REFERENCES department(dept_id)
);

INSERT INTO employee (emp_id, emp_name, salary, age, dept_id, job_role) VALUES
(101, 'Arun', 25000.00, 26, 10, 'Developer'),      
(102, 'Divya', 32000.00, 29, 20, 'Tester'),        
(103, 'Karthik', 45000.00, 30, 10, 'Developer'),   
(104, 'Farhan', 28000.00, 25, 30, 'Sales Exec'),   
(105, 'David', 35000.00, 27, 20, 'Manager'),       
(106, 'Sara', 42000.00, 24, 10, 'Developer'),      
(107, 'John', 22000.00, 31, 40, 'Analyst'),        
(108, 'Mark', 38000.00, 28, 20, 'HR Exec');        



SELECT emp_name, salary, (salary * 12) AS annual_salary FROM employee;
SELECT emp_name, salary, (salary + 5000) AS salary_with_bonus FROM employee;
SELECT emp_name, (salary - 2000) AS deducted_salary FROM employee;


SELECT * FROM employee WHERE salary > 30000;
SELECT * FROM employee WHERE age < 28;
SELECT * FROM employee WHERE salary = 25000;
SELECT * FROM employee WHERE age != 30;


SELECT * FROM employee WHERE salary > 25000 AND dept_id = 20;
SELECT * FROM employee WHERE dept_id = 10 OR dept_id = 30;
SELECT * FROM employee WHERE salary >= 30000;
SELECT * FROM employee WHERE age > 25 AND salary < 45000;

SELECT * FROM employee WHERE salary BETWEEN 25000 AND 40000;
SELECT * FROM employee WHERE dept_id IN (10, 20);
SELECT * FROM employee WHERE emp_name LIKE 'A%';
SELECT * FROM employee WHERE emp_name LIKE '%a';
SELECT * FROM employee WHERE emp_name LIKE '%ar%';
SELECT * FROM employee WHERE dept_id NOT IN (30, 40);



SELECT * FROM employee;
SELECT emp_name, salary FROM employee;
SELECT dept_name, location FROM department;

SELECT * FROM employee WHERE dept_id = 20;
SELECT * FROM employee WHERE salary > 35000;
SELECT * FROM employee WHERE age < 30;

SELECT * FROM employee ORDER BY salary ASC;
SELECT * FROM employee ORDER BY age DESC;
SELECT emp_name FROM employee ORDER BY emp_name ASC;

SELECT dept_id, COUNT(*) AS total_employees FROM employee GROUP BY dept_id;
SELECT dept_id, MAX(salary) AS max_salary FROM employee GROUP BY dept_id;
SELECT dept_id, MIN(salary) AS min_salary FROM employee GROUP BY dept_id;
SELECT dept_id, AVG(salary) AS avg_salary FROM employee GROUP BY dept_id;

SELECT dept_id, COUNT(*) FROM employee GROUP BY dept_id HAVING COUNT(*) > 2;
SELECT dept_id, AVG(salary) FROM employee GROUP BY dept_id HAVING AVG(salary) > 30000;
SELECT dept_id, MAX(salary) FROM employee GROUP BY dept_id HAVING MAX(salary) > 40000;

SELECT DISTINCT dept_id FROM employee;
SELECT DISTINCT job_role FROM employee;

SELECT * FROM employee LIMIT 3;
SELECT * FROM employee ORDER BY salary DESC LIMIT 2;


SELECT * FROM employee WHERE salary > 25000 ORDER BY salary DESC;
SELECT * FROM employee WHERE dept_id = 20 AND age BETWEEN 24 AND 30;
SELECT dept_id, COUNT(*) FROM employee GROUP BY dept_id HAVING AVG(salary) > 30000;
SELECT * FROM employee WHERE emp_name LIKE 'D%' OR emp_name LIKE 'F%';
SELECT * FROM employee WHERE job_role IN ('Developer', 'Tester');
SELECT * FROM employee WHERE salary NOT BETWEEN 25000 AND 35000;
SELECT dept_id, SUM(salary) AS total_salary FROM employee GROUP BY dept_id;
SELECT dept_id, SUM(salary) FROM employee GROUP BY dept_id HAVING SUM(salary) > 60000;


SELECT e.emp_name, d.dept_name 
FROM employee e JOIN department d ON e.dept_id = d.dept_id;

SELECT e.emp_name, e.salary, d.location 
FROM employee e JOIN department d ON e.dept_id = d.dept_id;

SELECT e.* FROM employee e JOIN department d ON e.dept_id = d.dept_id 
WHERE d.dept_name = 'IT';

SELECT e.* FROM employee e JOIN department d ON e.dept_id = d.dept_id 
WHERE d.location = 'Chennai';

SELECT e.emp_name, e.salary, d.dept_name 
FROM employee e JOIN department d ON e.dept_id = d.dept_id 
WHERE e.salary > 30000;

SELECT d.dept_name, COUNT(e.emp_id) AS total_employees 
FROM department d LEFT JOIN employee e ON d.dept_id = e.dept_id 
GROUP BY d.dept_name;

SELECT d.dept_name, COUNT(e.emp_id) 
FROM department d JOIN employee e ON d.dept_id = e.dept_id 
GROUP BY d.dept_name 
HAVING COUNT(e.emp_id) > 1;