# Client Server Model

Client requests data from server
Server responds to clients

Client does not know the address of the servers but knows that it can communicate with these servers
and can request stuff from these servers.

Example:
When we type https://www.google.com, our browser does a DNS Query and gets the IP address then only talk to the servers.

DNS Query is a special request which to goes to pre-determined servers to get the IP address of google.com and gives this
IP address back to the client.

IP address is a unique identifier of a machine.

How is IP address is assigned to any machine connected the internet?
-->

DNS:
The process of DNS resolution involves converting a hostname (such as www.example.com) into a computer-friendly IP address 
(such as 192.168.1.1).
An IP address is given to each device on the Internet, and that address is necessary to find the appropriate Internet device -
like a street address is used to find a particular home. 
When a user wants to load a webpage, a translation must occur between what a user types into their web browser (example.com) 
and the machine-friendly address necessary to locate the example.com webpage.

HTTP:
way to send info to server. It sends a bunch of bytes in packets. The request will contain the client IP address as well.
The server then can use this client address to send back the response.

The server listens on specific port. The client should specify the port on which the communication needs to happen.
If a client is using HTTP then in general the port will be 80, HTTPS 443.

IP: Internet protocol
The network protocol outlines how almost all machine to machine communications should happen in the world.
TCP, UDP, HTTP are built are top of IP

TCP: Transmission Control protocol
Allows for ordered, reliable data delivery between machines over the public internet by creating a connection.

HTTP: Hyper Text Transmission Protocol
implemented over the top of TCP. Clients make HTTP requests and server responds with a response.HTTP

IP packet:
smallest unit used to describe data being sent over IP. The IP packet consists of:
IP header : contains source and destination IP address and other network info
IP Payload : The data which is being sent over the network.

2 versions of IP, IPv4 and IPv6
IP packets are limited in size, 2^16 bytes which in MB are very very less

TCP is meant to send IP packets in an ordered way and there is guarantee that all the packets will be received.
If any packet gets corrupted during communication there we will get to know in TCP and can be resent.
Extra TCP header will contain more data related to ordering and everything else.

When a client tries to connect with server using TCP then it first it tries to create a TCP connection using handshake.

HTTP: introduces the idea of client-server communication using request-response protocol.
This protocol helps us create robust and maintainable systems.

# Storage

Databases - programs that either use disk or memory to do 2 things : record data and query data

Disk - Non-volatile storage
1. HDD : hard-disk drive
2. SSD : solid-state drive
SSD is far faster than HDD but also more expensive.

RAM - volatile memory

Latency : The time taken to complete an operation in the system. Generally measured in seconds or milliseconds.

Throughput : The number of operations that a system can handle properly per time unit. It can be measured in
query per second or request per second.

Availability - The odds of particular server or service being up and running at any point in time, usually measured in %.

Redundancy - The process of replicating parts of a system in an effort to make it more reliable.

Cache - A piece of hardware or software that stores data, typically meant to retreive the data faster than normal retreival.
Caching can be used to decrease the network latency.
It can be used to a precompute and save a large computation to decrease the latency.

CDN : Content Delivery Network
A CDN is a third party service that acts like a cache for your servers. A CDN has servers all around the world, meaning that
the latency to a CDN's servers will almost always be far better than the latency to your servers.
CDNs are also referred as PoPs(Points of presence).
2 most popular CDNs are Cloudflare and Google Cloud CDN.

# Proxies

Forward Proxy:
A server that sits between a client and servers and acts on behalf of client, typically to mask client's identity(IP address).
Forward proxies are often referred as just proxies.

Reverse Proxy:
A server that sits between clients and servers and acts on behalf of servers, typically usedfor logging, load balancing and caching.

Nginx : popular webserver that is often used as a reverse proxy and load balancer.

SQL databases - ACID compliance

Database Index : A special auxiliary data-structure that allows your database to perform certain queries much faster.
The disadvantage is that the db write becomes a bit slower as as writes need to happen in relevant index as well.

Key-value store:
A key-value store is a flexible NoSQL database that is used often for caching and dynamic configuration.
Ex: DynamoDB, Redis, Zookeeper

Zookeeper is strongly consistent, highly available key-value store. Its often used to store important configuration or to perform
leader election.
Redis is an in-memory key-value store used for persistent storage.Redis is also used for rate-limiting.

Peer-to-Peer network:
A collection of machines referred to as peers that divide a workload between themselves to presumbaly complete the workload faster
that would otherwise be possible. This network is often used in file-distribution networks.

Gossip protocol:
When a set of machines talk to each other in an uncoordinated manner in a cluster to spread info through a system without 
requiring a central source of data.

Polling:
The act of fetching a resource or piece od data regularly at an interval to make sure your data is not too stale.

Streaming:
In networking, it usually refers to the act of continuously getting feed of info from a server by keeping an open connection between
the two machines or process.

Rate limiting:
The act of limiting the number of requests sent to or from a system.

Publish/Subscribe Pattern:
Publishers publish messages to topics/channels and subscriber subscribes to these topics and read messages coming through these topics.

Idempotent operations:
An operation that has the same ultimate outcome regardless of now many times its performed.

MapReduce:
A popular framework for processing very large datasets in a distributed setting efficiently, quickly and in a fault-tolerant 
manner.
3 steps:
a. the Map step which runs a map function on various chunks of dataset and transforms into key-value pairs.
b. the Shuffle step re-organizes the intermediate key-value pairs such that the pairs of the same key are routed to the 
same machine in the final step.
c. the Reduce step, which runs a reduce function on the newly shuffled key-value pairs and transforms them into more
meaningful data.

Replication:
The act of duplicating the data from one database server to others. 

Sharding:
Sometimes called data partitioning, sharding is the act of splitting a database into two or more pieces called shards
and is typically done to increase the throughput of your database. Popular sharding strategies include:
a. Sharding based on a client's region
b. Sharding based on the type of data(eg. user data gets stored in one shard, payments data gets stored in another shard)
c. Sharding based on the hash of a column(only for structured data)

Example:
Lets say you have a sharded database and you want equal probability of request goings to these shards.
So what we you can do is have a reverse proxy in between application server and these shards. And the application servers 
acts as a client which will connect to this reverse proxy and this reverse proxy will have the hashing logic of sending 
the request to these shards.

Hot spot:
When distributing a workload across a set of servers, that workload might be spread unevenly. This can happen if your sharding key
or your hashing function are suboptimal, or if your workload is naturally skewed: some servers will receive a lot more traffic than
others thus creating a hot spot.

Leader Election:
The process by which nodes in a cluster(for instance, servers in a set of servers) elect a so-called "leader" them, responsible
for the primary operations of the service that these node support. When correctly implemented, leader election guarantees that all
nodes in the cluster know which one is the leader at any given time and can elect a new leader if the leader dies for whatever reason.

Consensus Algorithm:
A type of complex algos used to have multiple entities agree on a single data value, like who the "leader" is amongst a group of
machines. Two popular consensus algorithms are Paxos and Raft.            

**DDoS Attack**

A distributed denial-of-service (DDoS) attack is a malicious attempt to disrupt normal traffic of a targeted server, 
service or network by overwhelming the target or its surrounding infrastructure with a flood of Internet traffic. 
DDoS attacks achieve effectiveness by utilizing multiple compromised computer systems as sources of attack traffic.
Sometimes referred to as a layer 7 DDoS attack (in reference to the 7th layer of the OSI model), 
the goal of these attacks is to exhaust the resources of the target.
  
**XSS Attack**

Cross-Site Scripting (XSS) attacks are a type of injection, in which malicious scripts are injected into otherwise benign and trusted websites. 
XSS attacks occur when an attacker uses a web application to send malicious code, generally in the form of a browser side script, to a different end user.
Flaws that allow these attacks to succeed are quite widespread and occur anywhere a web application uses input from a user within the output it generates without validating or encoding it.

The actual attack occurs when the victim visits the web page or web application that executes the malicious code.
The web page or web application becomes a vehicle to deliver the malicious script to the user’s browser. 
Vulnerable vehicles that are commonly used for Cross-site Scripting attacks are forums, message boards, and web pages that allow comments.

**How master-slave architecture works**

Master-Slave can be synchronous and asynchronous communication.
If asynchronous, then less load on master to sync every time but then master slave will take time to be in sync.
If synchronous, then more load on master as it needs to update slave every time.

Master-Master looks good and resilient but it can go wrong if their communication is down and hence will start 
behaving independently.
Hence, we need more masters in the system and hence distributed consensus will come into picture.
Many types of distributed consensus are there:
1. 2 phase commit [Understand this protocol as it will make sure master-slave are in sync]
2. 3 phase commit
3. MVCC

Why is master-slave required?
1. We get a backup of all the data
2. Scale out your read operations, can run analytics engine on slaves(more slaves can be present)
3. Use sharding to reduce the damage if once of the node fails(can have slaves for each shard)

**How TCP handshake works?**

THREE-WAY HANDSHAKE or a TCP 3-way handshake is a process which is used in a TCP/IP network to make a connection 
between the server and client.
It is a three-step process that requires both the client and server to exchange synchronization and acknowledgment packets 
before the real data communication process starts.

Three-way handshake process is designed in such a way that both ends help you to initiate, negotiate, and separate TCP socket connections at the same time. 
It allows you to transfer multiple TCP socket connections in both directions at the same time.

Step 1: In the first step, the client establishes a connection with a server. It sends a segment with SYN 
and informs the server about the client should start communication, and with what should be its sequence number.
Step 2: In this step server responds to the client request with SYN-ACK signal set. ACK helps you to signify 
the response of segment that is received and SYN signifies what sequence number it should able to start with the segments.
Step 3: In this final step, the client acknowledges the response of the Server, and they both create a stable connection 
will begin the actual data transfer process.

**How SSL works?**

SSL certificates are an essential component of the data encryption process that make internet transactions secure.
They are digital passports that provide authentication to protect the confidentiality and integrity of website communication with browsers.

The SSL certificate's job is to initiate secure sessions with the user’s browser via the secure sockets layer (SSL) protocol.
This secure connection cannot be established without the SSL certificate, which digitally connects company information to a cryptographic key.

Working:
-A browser or server attempts to connect to a website (i.e. a web server) secured with SSL. The browser/server requests that the web server identify itself.
-The web server sends the browser/server a copy of its SSL certificate.
-The browser/server checks to see whether or not it trusts the SSL certificate. If so, it sends a message to the web server.
-The web server sends back a digitally signed acknowledgement to start an SSL encrypted session.
-Encrypted data is shared between the browser/server and the web server.

**Message Queues**

Asynchronous, it means sender and receiver need not interact with the messaging at the same time.

**Production Issue**

1. Message Queue Overflow- lots of messages are sent to queue but not received
    How to avoid - Have an alerting mechanism 
    
**System Capacity Planning**

1. Ask how much can be the traffic?
    Example - Total users - 500 million
              Active users - 2 million
              Image size = 2kb
           
2. Database capacity planning
    
**4 fundamental system principles**

1. Security
2. Availability
3. latency
4. Cost

**API Best Practices**

1. APIs should be easy to learn and easy to use.
2. API should be hard to misuse
3. API should fail fast
4. API names should be self-explanatory
5. API should be split into modules
6. Maximise information hiding. Dont let information leak in logs, exceptions.
7. Minimize coupling between APIs
8. Document as much as possible
9. Keep performance in mind while API design

**How to distribute the cache**

                      