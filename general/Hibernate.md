# Hibernate Interview Questions

Hibernate is an open-source and lightweight ORM tool that is used to store, manipulate, and retrieve data from the database.

The core interfaces of Hibernate framework are:
-Configuration
-SessionFactory
-Session
-Query
-Criteria
-Transaction

ORM has the following advantages over JDBC:

-Application development is fast.
-Management of transaction.
-Generates key automatically.
-Details of SQL queries are hidden.

The main difference between save and saveOrUpdate method is that save() generates a new identifier 
and INSERT record into the database while saveOrUpdate can either INSERT or UPDATE based upon the existence of a record. 
Clearly, saveOrUpdate is more flexible in terms of use but it involves extra processing to find out whether 
a record already exists in the table or not.

Usually, a Java JEE application has just one SessionFactory, and individual threads, which are servicing 
client’s requests obtain hibernate Session instances from this factory, that’s why any implementation of 
SessionFactory interface must be thread-safe.

**Lazy Loading**

Lazy loading in hibernate improves the performance. It loads the child objects on demand.
Since Hibernate 3, lazy loading is enabled by default, and you don't need to do lazy="true". 
It means not to load the child objects when the parent is loaded.

