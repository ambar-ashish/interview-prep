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



 

 
