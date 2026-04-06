CREATE TABLE department (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50),
    location VARCHAR(50)
);

CREATE TABLE employee (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(100),
    age INT,
    salary DECIMAL(10,2),
    dept_id INT,
    job_role VARCHAR(50)
);

INSERT INTO department (dept_id, dept_name, location) VALUES 
(10, 'HR', 'Chennai'),
(20, 'IT', 'Madurai'),
(30, 'Finance', 'Trichy'),
(40, 'Sales', 'Coimbatore');

INSERT INTO employee (emp_id, emp_name, age, salary, dept_id, job_role) VALUES 
(101, 'Arun', 23, 25000, 20, 'Developer'),
(102, 'Bala', 30, 40000, 10, 'Recruiter'),
(103, 'Charan', 27, 35000, 20, 'Tester'),
(104, 'Divya', 35, 50000, 30, 'Accountant'),
(105, 'Eswar', 29, 28000, 40, 'Sales Executive'),
(106, 'Farhana', 26, 32000, 20, 'Developer'),
(107, 'Gokul', 31, 45000, 30, 'Analyst'),
(108, 'Hari', 24, 22000, 10, 'Assistant');


SELECT 
    e.emp_name, 
    d.dept_name
FROM 
    employee e
JOIN 
    department d ON e.dept_id = d.dept_id;


SELECT 
    e.emp_name, 
    e.salary, 
    d.location
FROM 
    employee e
JOIN 
    department d ON e.dept_id = d.dept_id;


SELECT 
    e.emp_name, 
    e.job_role, 
    d.dept_name
FROM 
    employee e
JOIN 
    department d ON e.dept_id = d.dept_id
WHERE 
    d.dept_name = 'IT';


SELECT 
    e.emp_name, 
    e.job_role, 
    d.location
FROM 
    employee e
JOIN 
    department d ON e.dept_id = d.dept_id
WHERE 
    d.location = 'Chennai';


SELECT 
    e.emp_name, 
    e.salary, 
    d.dept_name
FROM 
    employee e
JOIN 
    department d ON e.dept_id = d.dept_id
WHERE 
    e.salary > 30000;


SELECT 
    d.dept_name, 
    COUNT(e.emp_id) AS total_employees
FROM 
    department d
LEFT JOIN 
    employee e ON d.dept_id = e.dept_id
GROUP BY 
    d.dept_name;


SELECT 
    d.dept_name, 
    COUNT(e.emp_id) AS employee_count
FROM 
    department d
JOIN 
    employee e ON d.dept_id = e.dept_id
GROUP BY 
    d.dept_name
HAVING 
    COUNT(e.emp_id) > 1;

