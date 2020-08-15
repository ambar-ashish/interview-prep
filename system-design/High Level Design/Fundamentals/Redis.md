# Redis

Redis stands for Remote Dictionary Server.Its an open source, in-memory data store. Its a key-value store.
It can be use for the following:
1. Caching
2. Session Management
3. Publisher-Subscriber based messaging
4. Process information very quickly(like leaderboard)

Redis is much faster then database since it stored the data in memory where as DB stores in hard-drives.

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

Understand TTL in Redis 

