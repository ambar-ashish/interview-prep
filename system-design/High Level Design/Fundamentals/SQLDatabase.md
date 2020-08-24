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
 
