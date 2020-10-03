# Hashing

**What Is Hashing?**

A hash function is a function that maps one piece of data—typically describing some kind of object, 
often of arbitrary size—to another piece of data, typically an integer, known as hash code, or simply hash.

**Consistent Hashing**

A type of hashing that minimizes the number of keys that needs to be remapped when a hash table gets resized.
Its often used by load balancers to distribute traffic to servers; it minimizes the number of requests that get forwarded
to different servers when new servers are added or when existing servers are brought down.

Consistent hashing allows you to scale up and down easier, and makes ensuring availability easier.
Easier ways to replicate data allows for better availability and fault-tolerance.
Easier ways to reshuffle data when nodes come and go means simpler ways to scale up and down.

SHA: Secure Hash algorithms
collection cryptographic hash functions used in the industry. SHA-3 popular nowadays.

  




