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
Extra TCP header will contain more data related to ordering and evreything else.

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
leader elecntion.
Redis is an in-memory key-value store used for persistent storage.Redis is also used for rate-limiting.

Peer-to-Peer network:
A collection of machines referred to as peers that divide a workload between themselves to presumbaly complete the workload faster
that would otherwise be possible. This network is often used in file-distribution networks.

Gossip protocol:
When a set of machines talk to each other in an uncoordinated manner in a cluster to spread info through a system without requiring
a central source of data.

Polling:
The act of fetching a resource or piece od data regularly at an interval to make sure your data is not too stale.

Streaming:
In networking, it usually refers to the act of continuously getting feed of info from a server by keeping an open connection between
the two machines or process.

Rate limiting:
The act of limiting the number of requests sent to of from a system.

Publish/Subscribe Pattern:
Publishers publish messages to topics/channels and subscriber subscribes to these topics and read messages coming through these topics.

Idempotent operations:
An operation that has the same ultimate outcome regardless of now many times its performed.

MapReduce:
A popular framework for processing very large datasets in a distributed setting efficiently, quickly and in a fault-tolerant manner.
3 steps:
a. the Map step which runs a map function on various chunks of dataset and transforms into key-value pairs.
b. the Shuffle step re-organizes the intermediate key-value pairs such that the pairs of the same key are routed to the same machine in the final step.
c. the Reduce step, which runs a reduce function on the newly shuffled key-value pairs and transforms them into more meaningful data.

        

  




