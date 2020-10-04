 # Load Balancer

**1. Load Balancer Definition**

In general LB sits between client and servers and it balances workload on resources.
Clients will be sending request to load balancer, hence the system will get better throughput and latency.
LBs are kind of reverse proxy sitting between client and server and acting on behalf of servers.
LBs can be between client and nodes or in between nodes and databases.
LBs can route requests geographically.

LBs can store IPs and port ranges mapping with backend server to store which request is coming from which range 
then route the request accordingly.

**2. What is reverse proxy?**

A reverse proxy is a server that sits in front of web servers and forwards client (e.g. web browser) requests to those web servers. 
Reverse proxies are typically implemented to help increase security, performance, and reliability. 

**3. Types of load balancers**

    a. Software LB - the LB software can be installed in any servers like AWS EC2
    b. Hardware LB - sotware is embedded in the specific hardware

Some mechanism should be present so that if node is added/removed, the LB should be able to register the same and send the requests accordingly.
 
**4. Strategy to select nodes done by LB**

Different ways:
a. Random selection - can cause problem, by chance one server can be overloaded
b. Round Robin selection - goes in one order and then follow the same order again and again
c. Weighted Round Robin - a little more request for more powerful server 
d. Based on performance - LB does a health check for all the servers(how long the server is taking to respond), 
accordingly LB will redirect the request to better performant server
e. IP based - Hash the IP address of the client and with this hash value, select the node. 
This can help in increase cache hit as we can use the same has to select the cache
f. Using Consistent Hashing - Use requestID from client request and hash this value, 
    then this hash value can be mapped to particular servers.
 
**5. How to make sure that LB is not single point of failure and scale load balancers?**

Have multiple replicas of LB which can be mapped with DNS so that any user who types google.com, 
then the DNS query hits either of the Load balancer IPs.

**6. How LB understands to route request to the closest servers or CDN**

**How to handle Session Persistence for same user**

Example : Shopping cart of a user
maybe use cache

**Production Issues**

1. LB can be a single point of failure hence multiple load balancers replica should be present.
2. Normal Round robin will not work well if one of the servers goes down or some servers have low memory/capacity
    (choose weighted round robin)
3. Cache Overflow

**Load Balancers Layer4 vs Layer 7**

**Major Functions of load balancers**

1. Distributes client request
2. Ensures high availability(Use heartbeat mechanism if the servers are up or not) 
3. Provides flexibility to add or remove servers from server farm

**NGINX**

NginX is an open source web server written in C and can also be used as a reverse proxy and a load balancer.
Can be used as:
1. Load Balancing
2. Backend Routing
3. Caching




