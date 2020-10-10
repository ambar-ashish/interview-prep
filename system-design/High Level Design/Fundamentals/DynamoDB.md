# Dynamo DB

DynamoDB is a fully managed, Internet scalable, easily administrated and cost-effective NoSQL database.

Cross-region Replication
Any mode of changes in the table will be consequently propagated to all replicas.

TTL (Time to Live)
TTL is a process that gives you an opportunity to set a specific timestamp to delete expired data from your tables. 
Once the timestamp expires, the relating item is marked as expired and is subsequently deleted from the table

Items in DynamoDB correspond to rows in SQL, and attributes in DynamoDB correspond to columns in SQL.

DynamoDB supports the following data types:
1. Scalar data types: Number, String, Binary, Boolean
2. Collection data types: Set, List, Map