
CREATE TABLE departments (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(50) NOT NULL,
    location VARCHAR(50) NOT NULL
);
INSERT INTO departments (department_id, department_name, location)
VALUES 
    (1, 'HR', 'Chennai'),
    (2, 'Development', 'Bangalore'),
    (3, 'Testing', 'Chennai'),
    (4, 'Support', 'Hyderabad');
	-- Display the departments where location is Chennai.
SELECT * FROM departments 
WHERE location = 'Chennai';

CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50) NOT NULL,
    age INT CHECK (age >= 18),
    salary INT CHECK (salary > 0),
    department_id INT,
    manager_id INT,
    FOREIGN KEY (department_id) REFERENCES departments(department_id),
    FOREIGN KEY (manager_id) REFERENCES employees(emp_id) -- Self Link
);

INSERT INTO employees (emp_id, emp_name, age, salary, department_id, manager_id)
VALUES 
    (101, 'Arun', 30, 40000, 2, NULL),
    (102, 'Bala', 28, 30000, 2, 101),
    (103, 'Charan', 35, 50000, 1, NULL),
    (104, 'Dinesh', 25, 25000, 3, 103),
    (105, 'Ezhil', 27, 28000, 4, 101);

	-- Display the employees where salary is greater than 30000
SELECT * FROM employees WHERE salary > 30000;

-- Update Bala's salary to 35000
UPDATE employees SET salary = 35000 WHERE emp_name = 'Bala';

-- Delete Dinesh record
DELETE FROM employees WHERE emp_name = 'Dinesh';
