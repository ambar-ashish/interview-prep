# Redis

Redis stands for Remote Dictionary Server.Its an open source, in-memory data store. Its a key-value store.
It can be use for the following:
1. Caching
2. Session Management
3. Publisher-Subscriber based messaging
4. Process information very quickly(like leaderboard)

Redis is much faster than database since it stored the data in memory where as DB stores in hard-drives.

Redis is a No-SQL db
Uses data structures to store data
1. String
2. Lists
3. Sets
4. Sorted Sets
5. Hashes

Advantages:
1. very very fast - 120,000 requests per second or even more
2. Simple and flexible - no need to define rows and columns, no insert, select
3. Durability - has option to write on disk, can be used as caching system or as full fledged database
4. Multiple language/Client support
5. Can be used as a second database to make transations faster
6. Redis has a very good master-slave Replication feature
---> Master can be write only, one slave can read only and other slave can write data to disk
7. Redis has a single text file for all the configurations
8. Single Threaded - only one action at a time
9. Pipeline feature to send all the commands to Redis at once

Cache performance will depend on Cache Policy(LRU is highly used policy)

Write through cache - First write in cache then in DB
Write back cache - First write in DB then in cache
Both the above has their advantages and disadvantages, we need to have a hybrid logic

Redis Main Data types
1. Strings
2. Lists
3. Sets
4. Sorted Sets
5. Hashes

Example:
ip:set student Jordan
op:OK

ip:get student
op:Jordan

Setting up TTL for any key(We have option of expiry in seconds or milliseconds)
set student Jordan ex 25 -> This key will expire in 25 seconds

Command to check how much time is remaining for expiry for any key
ttl student

NX - means set the key if not exists
XX - means set the key if exists

Maximum size of the list can be 2^32 - 1.(more than 4 billion elements)

List:
lpush - left push
rpush - right push

lpush list ele1 ele2 ele3

Sets:
sadd emails email1 email2 email3

Sorted Sets:
zadd names 10 A 20 B 30 C

Hash
hset student name ambar

Object with multiple values can also be stored in Hash

**Redis Persistence Options**

1. RDB(Redis Database file) - makes a snapshot of the dataset at specific intervals
2. AOF(Append Only File) - AOF logs each write operation received by the server that will be played again at
server startup, restoring the original dataset
3. Hybrid(RDB and AOF)

**Redis Sentinel**

Redis sentinel is a system, designed to help manage redis instances.
The main purpose of it is to make redis highly available.

Sentinel performs main 3 tasks:
1. Monitoring - check if master slave is working properly or not
2. Notification - notify other programs or system admin if some instances have gone down
3. Automatic failover - On master failure, sentinel makes one of the slaves as master and informs other slaves as well.

**Redis Cluster**

Redis Cluster is a data sharding solution with automatic management, failover and replication.

**Redis Sentinel vs Cluster**

If you need an automatic failover solution without going to a full cluster solution, then use Sentinel.
For getting a complete clustering solution which splits your database in between multiple nodes then go for Clustering.

 


