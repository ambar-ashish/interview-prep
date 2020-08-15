# Sharding/Partitioning

Sharding a database is a common scalability strategy used when designing server side systems. 
The server side system architecture uses concepts like sharding to make systems more scalable, reliable and performant.

Sharding is horizontal partitioning of data according to a shard key. 
This shard key determines which database the entry to be persisted is sent to. Some common strategies for this are reverse proxies.

Database interviews ask for concepts like sharding to make databases more performant and available. 
This makes horizontal partitioning a logical choice.

With sharding, both read and write performance goes up if implemented properly.

Example:

We can partition the database using the userId/requestId of the user. We can have 7 partitions from userID from A-D, then E-F.. and so on.
In this way we are reducing the load of each partition.
Consistency with this sharding is required.

Another example is Tinder, where we can shard data based on location.

**Problems:**

1. Joins across shards are expensive.
2. Shards are kinda hardcoded now, not flexible. To solve this problem Consistent hashing can be used.
(Also to fix this problem, we can have shards within these shards)
3. Consistency is a big problem to achieve in Sharding. 

What happens when one of the shards fail?
Have master slave architecture for each shard, each write happens in the master and slaves polls the master for continuous replica fo data.
The reads can be done via the slaves.

**In conclusion, indexing or using no-sql databases can be used as another option in place of Sharding as its very complex**