#Databases

**How to choose the right database for a system?**

1. Integration Requirements
2. Scaling Requirements
3. Support Consideration [Do you have team capability to manage new type of database?]
4. Budget Considerations
5. CAP considerations

CA - MySQL
CP - HBase, MongoDB
AP - Cassandra

Nowadays, CAP theorem is not a hard and fast rule. These trade-offs have become a little bit loose.
Example : Casssandra looks like Ap but Consistency can be configured.[We get all three to an extent].

Example 1:
If you are building an internal phone directory app with
-scale : limited
-consistency : eventual is fine
-availability : not mission critical
-mysql is probably installed on your web server
Here, we can go with MySql

Example 2:
If you want to build a movie recommendation system
-huge company with massive scale
-downtime is not tolerated
-must be fast
-eventual consistency OK - it just read
Here, we can go with Cassandra

Example 3:
If you want to build massive stock trading system
-Consistent is more important than anything
-"Big Data" is present
-Professional support is required and you have enough budget to pay for it.
Here, we can go with MongoDB

**SQL vs NoSQL**

-> Sql can scale upto a limit
-> Nowadays no more organized data and different types of data which sql can not fit

NoSql
-> Horizontal Partitioning in-built(Internally Dynamo DB/Cosmos DB have internal partitions/clusters)
-> You achieve limitless storage as well as throughput
-> No schema management
-> It is a pain to do schema changes in relational databases, sometimes downtime is required to do it.

Disadvantages of NoSql Database:
-> We lose consistency since our database is distributed now(CAP Theorem)
->  Eventual Consistency is still present.(Most apps are good with it.)
-> NoSql queries:
   a. No relation data so no joins now
   b. These join and other logic moves to application layer
   
NoSql indexing is different, you have local and global indexes.

Data is stored in de-normalized way in NoSql DB so that no joins are required.
You save the data as per the way you are ggoing to fetch it.
You keep some redundant data so that you can avoid joins.

If data is huge then you can go with NoSQL db.
SQL - When ACID is required and volume/velocity of data is less.

What happens if you have BIG Data and need joins?
- Go with Hybrid approach here.
- Use SQL to get all the join benefits
- manually do Horizontal Partitioning.

   
   
