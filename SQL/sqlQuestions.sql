CREATE TABLE employee (
emp_id INT PRIMARY KEY,
name VARCHAR(50),
age INT,
department VARCHAR(50),
salary INT,
bonus INT,
manager_id INT,
city VARCHAR(50)
);


INSERT INTO employee VALUES
(1, 'John', 25, 'IT', 60000, 5000, NULL, 'New York'),
(2, 'Alice', 30, 'HR', 55000, NULL, 8, 'Chicago'),
(3, 'Bob', 28, 'IT', 75000, 7000, 1, 'Boston'),
(4, 'David', 35, 'Finance', 80000, 10000, 8, 'Chicago'),
(5, 'Emma', 40, 'HR', 90000, NULL, NULL, 'Seattle'),
(6, 'Liam', 29, 'IT', 62000, 4000, 1, 'New York'),
(7, 'Sophia', 32, 'Marketing', 70000, 3000, 5, 'Boston'),
(8, 'Noah', 45, 'Management', 120000, 20000, NULL, 'Seattle'),
(9, 'Olivia', 27, 'Finance', 65000, 2500, 4, 'Chicago'),
(10, 'James', 31, 'IT', 85000, NULL, 8, 'New York'),
(11, 'Mia', 26, 'Marketing', 58000, 3500, 7, 'Boston'),
(12, 'Ethan', 38, 'Finance', 95000, 12000, 8, 'Seattle'),
(13, 'Ava', 24, 'HR', 50000, NULL, 5, 'Chicago'),
(14, 'Lucas', 41, 'IT', 110000, 15000, 8, 'New York'),
(15, 'Charlotte', 36, 'Marketing', 72000, 5000, 7, 'Boston');



-- *******************************************************  QUESTIONS  ************************************************************


-- Find employees whose salary is greater than ALL Finance employees.
SELECT * FROM employee WHERE salary > ALL
(SELECT salary FROM employee WHERE department = 'finance');

-- Find employees whose salary is less than ANY IT employee.
SELECT * FROM employee WHERE salary < ANY 
(SELECT salary FROM employee WHERE department = 'finance');

SELECT * FROM employee WHERE salary < (
SELECT MAX(salary) FROM employee WHERE department = 'finance'
);

-- Find employees having NULL bonus.
SELECT * FROM employee WHERE bonus IS null;

-- Find employees earning between 60,000 and 90,000.
SELECT * FROM employee WHERE salary BETWEEN 60000 AND 90000;

-- Find employees not in Chicago.
SELECT * FROM employee WHERE city != 'chicago';

SELECT * FROM employee WHERE city <> 'chicago';

SELECT * FROM employee WHERE city NOT IN ('chicago');

-- Find total compensation (salary + bonus).
SELECT emp_id, name, department, salary, salary + COALESCE(bonus, 0) AS total, city FROM employee;

SELECT emp_id, name, department, salary, salary + IFNULL(bonus, 0) AS total, city FROM employee;

-- Find employees whose manager works in Seattle.
SELECT e.emp_id, e.name, m.name, m.city FROM employee AS e INNER JOIN employee AS m ON e.manager_id = m.emp_id WHERE m.city = 'Seattle';

SELECT * FROM employee AS e 
WHERE EXISTS (
SELECT 1 FROM employee AS m WHERE m.emp_id = e.manager_id AND m.city = 'Seattle');

-- Find departments having more than 3 employees.
SELECT COUNT(*), department FROM employee GROUP BY department HAVING COUNT(*) > 3;

-- Find the second highest salary using a CTE.
SELECT * FROM employee ORDER BY salary DESC LIMIT 1 OFFSET 1;

SELECT * FROM employee WHERE salary = 
	(SELECT MAX(salary) FROM employee WHERE salary < 
		(SELECT MAX(salary) FROM employee));

-- Find all employees who don't have a manager.
SELECT * FROM employee WHERE manager_id IS NULL;

SELECT * FROM employee AS e1 WHERE manager_id IS NOT NULL AND NOT EXISTS
(SELECT 1 FROM employee AS e2 WHERE e2.emp_id = e1.manager_id);

-- Find employees earning more than their manager.
SELECT e.name AS employee_name,
    e.salary AS employee_salary,
    m.name AS manager_name,
    m.salary AS manager_salary FROM employee AS e INNER JOIN employee m ON e.manager_id = m.emp_id WHERE e.salary > m.salary;

-- Find employees belonging to the same city as their manager.
SELECT e.name AS emp_name, e.city AS emp_city, m.name AS manager_name, m.city AS manager_city FROM employee AS e INNER JOIN employee AS m ON e.manager_id = m.emp_id WHERE e.city = m.city;
SELECT * FROM employee;

-- Find departments where every employee earns more than 50,000.
SELECT department FROM employee GROUP BY department HAVING MIN(salary) > 50000;

-- Find employees older than all employees in Marketing.
SELECT * FROM employee WHERE age > (SELECT MAX(age) FROM employee WHERE department = 'marketing');

SELECT * FROM employee WHERE age > ALL (SELECT age FROM employee WHERE department = 'marketing');

-- Find employees younger than any employee in Finance.
SELECT * FROM employee WHERE age < (SELECT MIN(age) FROM employee WHERE department = 'finance');