#SQL Databases

Database is an organized collection of informartion/data. Allows us to access and interact with the data.
SQL is standard language used to communicate with the database.
SQL is used to perform tasks on a database.

RDBMS is a collection of data organized into tables.

**Commands:**

SHOW DATABASES;

CREATE DATABASE test;

USE test;

SHOW TABLES;

DROP DATABASE test;

**Numeric Data Types**

INT - whole numbers
FLOAT(M,D) - Decimal Numbers(Approx)
DECIMAL(M,D) - Decimal Numbers(Precise)

**Non-Numeric Data Types**

char(N) - Fixed length character
varchar(N) - varying length character
enum('M','F') - value from a defined list
boolean - true or false values

**Date Types**

Date : (YYYY-MM-DD)
DATETIME : (YYYY-MM-DD HH-MM-SS)

Primary Key - It is a column or a set of columns which uniquely identifies a record within a table

Foreign Key - It is used to link two tables together. A foreign key is a column whose values match the values of another tables primary key.
A table can have multiple foreign keys.

% any number of characters
_ only one character
Select * from customer where last_name like 'Am%';

Select DISTINCT user_name from customer;

For Top 5 results

Select DISTINCT user_name from customer LIMIT 5;

5 Results after Top 5 results
Select DISTINCT user_name from customer LIMIT 5 OFFSET 5;

Alias
Select user_name AS NAME from customer;

Order by Default is ascending order.

**JOINS**

Join allows you to retrieve data from multiple tables in a single select statement.
To join 2 tables there needs to be a related column between them.

**INNER JOIN**

Will retrieve data only when there is matching values in both tables.
select products.name, orders.order_time From orders
INNER JOIN products ON orders.product_id = products.id;

Better Clean Query with Alias: INNER Join can be said as JOIN

select p.name, o.order_time From orders o
JOIN products p ON o.product_id = p.id;

**LEFT JOIN**

Will retrieve all data from the left table and matching rows from the right data.

select p.name, o.order_time From orders o
LEFT JOIN products p ON o.product_id = p.id; 

**RIGHT JOIN**

Will retrieve all data from the right table and matching rows from the left data.

select p.name, o.order_time From orders o
RIGHT JOIN products p ON o.product_id = p.id;

**Normalization**

It is the process of efficiently organizing data in a database.
- to eliminate redundant data
- to store only related data in a table

Example:Lets say we have a student table which contains subject with the teachers name. But we will have same
repeated teachers name for many students.
So we can split up this table with one as Students table and other as teachers table.
In this way we reduced data redundancy.

Benefits:
-Reduce Storage space
-Reduce insert, update and deletion anomalies
-Improve query performance

**Levels of Normalization**

1. 1st Normal form(1NF)
Tables are in 1NF:
-No repeated rows of data
-Columns only contain a single value
-The table has a primary key

2. 2nd Normal form(2NF)
Tables are in 2NF:
-They conform to 1NF
-Every column that is not a primary key of the table is dependent on the whole of the primary key.

3. 3rd Normal form(3NF)
Tables are in 3NF:
-They conform to 2NF
-Every column that is not a primary key is only dependent on the whole of the primary key.

**Aggregrate Functions**

Performs a calculation on data within a column and returns one result row.

Select Count(*) from customers where first_name is NULL;

Select SUM(no_seats) from rooms;

Select MIN(length_min) from films;

Select MAX(length_min) from films;

Select AVG(length_min) from films;

Select customer_id, COUNT(id) from bookings
GROUP BY customer_id;

Select customer_id, screening_id, COUNT(id) from bookings
GROUP BY customer_id, screening_id;

Select customer_id, screening_id, COUNT(id) from bookings
GROUP BY customer_id, screening_id
HAVING customer_id = 10;

Select id from screenings
where film_id IN (Select id from films where length_min > 120);

Select CONCAT(first_name, last_name) AS full_name from customers;

Select UPPER(first_name) AS name from customers;

Select * from screenings
WHERE DATE(start_time) BETWEEN '2020-05-05' AND '2020-08-08';

**SQL Constraints**

NOT NULL - Restricts NULL value from being inserted into a column.
CHECK - Verifies that all values in a field satisfy a condition.
DEFAULT - Automatically assigns a default value if no value has been specified for the field.
UNIQUE - Ensures unique values to be inserted into the field.
INDEX - Indexes a field providing faster retrieval of records.
PRIMARY KEY - Uniquely identifies each record in a table.
FOREIGN KEY - Ensures referential integrity for a record in another table.

Create With Primary Key

CREATE TABLE Students ( 	 /* Create table with multiple fields as primary key */
    ID INT NOT NULL
    LastName VARCHAR(255)
    FirstName VARCHAR(255) NOT NULL,
    CONSTRAINT PK_Student
    PRIMARY KEY (ID, FirstName)
);

Create with Foreign Key

CREATE TABLE Students ( 	 /* Create table with foreign key - Way 1 */
    ID INT NOT NULL
    Name VARCHAR(255)
    LibraryID INT
    PRIMARY KEY (ID)
    FOREIGN KEY (Library_ID) REFERENCES Library(LibraryID)
);

**Index**

A database index is a data structure that provides quick lookup of data in a column or columns of a table. 
It enhances the speed of operations accessing data from a database table at the cost of additional writes 
and memory to maintain the index data structure.

CREATE INDEX index_name 	 /* Create Index */
ON table_name (column_1, column_2);

GROUP BY clause in SQL is used to group records with identical data and can be used in
conjuction with some aggregation functions to produce summarized results from the database.

HAVING clause in SQL is used to filter records in combination with the GROUP BY clause.
It is different from WHERE, since WHERE clause cannot filter aggregated records.

**Interview Questions**

Consider the two tables below. Write a query that retrieves all employees recruited by John Do.
 How would you write a second query to retrieve all employees that were not recruited by any recruiter? 
 Employee Table
Id	Name	RecruitedBy
1	Jean Grayson	NULL
2	Paul Smith	1
3	John Do	NULL
4	Alex Lee	3
5	Lisa Kim	3
6	Bob Thompson	NULL

Recruiter Table
Id	Name
1	Bob Smith
2	Paul Allen
3	John Do

The following query will retrieve all recruiters recruited by John Do. SELECT Employee. 

Name FROM Employee
JOIN Recruiter ON Employee.RecruitedBy = Recruiter.Id
WHERE RecruitedBy = 3

To retrieve all employees who were not recruited by anyone in the recruiter table, you could use the following query:
 
SELECT Employee.Name FROM Employee
JOIN Recruiter ON Employee.RecruitedBy = Recruiter.Id
WHERE RecruitedBy Is Null

Write a SQL query to find the 10th tallest peak (“Elevation”) from a “Mountain” table.
Assume that there are at least 10 records in the Mountain table. Explain your answer.

SELECT Elevation FROM
(
  SELECT DISTINCT Elevation FROM Mountain ORDER BY Elevation DESC LIMIT 10
) AS Mt ORDER BY Elevation ASC LIMIT 1;

SQL LEFT JOIN Example

SELECT Customers.CustomerName, Orders.OrderID
FROM Customers
LEFT JOIN Orders ON Customers.CustomerID = Orders.CustomerID
ORDER BY Customers.CustomerName;

SELECT Customers.CustomerName, Orders.OrderID
FROM Customers
FULL OUTER JOIN Orders ON Customers.CustomerID=Orders.CustomerID
ORDER BY Customers.CustomerName;

**SQL Self JOIN Example**
The following SQL statement matches customers that are from the same city:

SELECT A.CustomerName AS CustomerName1, B.CustomerName AS CustomerName2, A.City
FROM Customers A, Customers B
WHERE A.CustomerID <> B.CustomerID
AND A.City = B.City 
ORDER BY A.City;

The SQL GROUP BY Statement
The GROUP BY statement groups rows that have the same values into summary rows, 
like "find the number of customers in each country".

The GROUP BY statement is often used with aggregate functions (COUNT, MAX, MIN, SUM, AVG) 
to group the result-set by one or more columns.

The SQL HAVING Clause
The HAVING clause was added to SQL because the WHERE keyword could not be used with aggregate functions.

SELECT COUNT(CustomerID), Country
FROM Customers
GROUP BY Country
HAVING COUNT(CustomerID) > 5;

**Write q query to find all the employees whose salary is between 50000 to 100000**

SELECT * FROM EmployeePosition WHERE Salary BETWEEN '50000' AND '100000';

**Write a query to find the names of employees that begin with ‘S’**

SELECT * FROM EmployeeInfo WHERE EmpFname LIKE 'S%';

**Write a query to fetch top N records.**

SELECT * FROM EmpPosition ORDER BY Salary DESC LIMIT N;

**Write a query to fetch details of employees whose EmpLname ends with an alphabet ‘A’ and contains five alphabets.**

SELECT * FROM EmployeeInfo WHERE EmpLname LIKE '____a';

**Write a query to fetch details of all employees excluding the employees with first names, 
“Sanjay” and “Sonia” from the EmployeeInfo table.**

SELECT * FROM EmployeeInfo WHERE EmpFname NOT IN ('Sanjay','Sonia');

**Write a query to fetch all employees who also hold the managerial position.**

SELECT E.EmpFname, E.EmpLname, P.EmpPosition 
FROM EmployeeInfo E INNER JOIN EmployeePosition P ON
E.EmpID = P.EmpID AND P.EmpPosition IN ('Manager');

**Write a query to find the third-highest salary from the EmpPosition table.**

SELECT TOP 1 salary
FROM(
SELECT TOP 3 salary
FROM employee_table
ORDER BY salary DESC) AS emp
ORDER BY salary ASC;

**SQL Query to find second highest salary of Employee**

select MAX(Salary) from Employee WHERE Salary NOT IN (select MAX(Salary) from Employee ); 

**SQL Query to find Max Salary from each department**

SELECT DeptID, MAX(Salary) FROM Employee  GROUP BY DeptID. 

**Write an SQL Query to print the name of the distinct employee whose DOB is between 01/01/1960 to 31/12/1975.**

SELECT DISTINCT EmpName FROM Employees WHERE DOB  BETWEEN ‘01/01/1960’ AND ‘31/12/1975’;

**Write an SQL Query find number of employees according to gender  whose DOB is between 01/01/1960 to 31/12/1975.**

SELECT COUNT(*), sex from Employees WHERE DOB BETWEEN '01/01/1960' AND '31/12/1975' GROUP BY sex;

SELECT student, marks from table where marks > SELECT AVG(marks) from table)

SELECT * from Employees WHERE UPPER(EmpName) like '%JOE%';

**How do you find all employees which are also manager?**

SELECT e.name, m.name FROM Employee e, Employee m WHERE e.mgr_id = m.emp_id;

  



 

 
