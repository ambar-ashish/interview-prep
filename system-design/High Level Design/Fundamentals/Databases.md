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

**Reasons to go for SQL**

1. Schema
2. ACID property

-Complex data can be represented can be easily designed
-Schema helps us to make sure null or garbage values are not populated and constraints are in check

**NoSql**

1. Key value store - like HashMap 
    Ex : Redis, Dynamo DB, Memcache
    
2. Document based database -
    - No fixed schema - when not sure about the fields evolving in the future.
    - supports heavy reads/writes
    - dont want joins and all data in one document
    
Storage method - List of jsons(Collection of documents)
[
{
    name : "Ambar",
    id : 1
},
{
    name : "Ashish",
    id : 2
}
]
Example : Storing product details of multiple items    

Example : MongoDB
Advantages:

1. Highly scalable
2. Sharding
3. Dynamic date flexibility
4. Special Query Operations/Aggregation

Disadvantages of Document based databases:
1. Null values can come up which needs to be handled in application layer
2. Does not support ACID so not sure if updation was correct or not

3. Column Databases
--- Heavy reads
--- No ACID property
Example : Cassandra, HBase

4. Search Databases
-- Elastic, Solr

**Factors for choosing a database**

1. If the data is structured/unstructured?
2. Query patterns
3. Scalability

Cache Solution:
1. Cache the response for future requests
2. Key value store
3. Redis, MemCache

File Storage Solution:
1. Videos, images
2. Blob storages should be used
3. AWS S3

CDN:
1. Same image cached to different geo servers(different locations)
2. Use CDN with all kind of Blob Storages to speed things up

Search Capability
1. Text Search, Fuzzy Search
2. Elastic Search, Solr

Elastic Search is a search engine so this should not the source of truth.
Make sure the original data is stored in a different database which is the primary source of truth.

Time Series Database:
1. Kind of extension of relational DB
2. Application Tracking system like Grafana, Prometheus which are pushing metrics to the DB
3. Ex : OpenTSDB

Datastore for Analytics:
1. Datawarehouse will be required for offline reporting
2. Ex: Hadoop

Relational database:
1. If structured data then relational Database makes sense.
2. ACID is required
3. MySQL, Oracle, Postgres
4. Payment System

Not Structured Data Type 1:
1. Catalog kind of info is stored, item details
2. These data have alot of attributes and wide variety of queries can come in
3. DocumentDB - MongoDB, CouchBase
    
Not Structured Data Type 2:
1. Ever increasing data
2. Finite number of queries and large amount of data
3. Columnar DB : Cassandra, HBase
4. Cassandra is easy to deploy

Example: Order Management has evergrowing data and transaction capability is required(ACID).
We can have a combo here by using RDBMS for doing transaction and once done then move data to Cassandra.
   
