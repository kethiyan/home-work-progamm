-- Create Table
CREATE TABLE bank_account (
    acc_no INT PRIMARY KEY,
    name VARCHAR(50),
    balance DECIMAL(10, 2)
);

-- Insert Records
INSERT INTO bank_account VALUES (101, 'Alice', 5000.00), (102, 'Bob', 3000.00);

-- Update and Rollback
SET AUTOCOMMIT = 0; -- Disable autocommit to use transactions
START TRANSACTION;
UPDATE bank_account SET balance = balance + 1000 WHERE acc_no = 101;
ROLLBACK; -- This undoes the update




-- Assuming a table 'employees' exists with columns 'name' and 'salary'
CREATE VIEW employee_names AS
SELECT name FROM employees;

-- Grant Permission
GRANT SELECT ON employee_names TO 'guest'@'localhost';