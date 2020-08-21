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
Here, we can got with MySql

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
