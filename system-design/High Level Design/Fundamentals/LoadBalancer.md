# Load Balancer

1. Load Balancer Definition
In general LB sits between client and servers and it balances workload on resources.
Clients will be sending request to load balancer, hence the system will get better throughput and latency.
LBs are kind of reverse proxy sitting between client and server and acting on behalf of servers.
LBs can be between client and nodes or in between nodes and databases.

2. What is reverse proxy?

3. Types of load balancers
    a. Software LB
    b. Hardware LB

Some mechanism should be present so that if node is added/removed, the LB should be able to register the same and send the requests accordingly.
 
4. Strategy to select nodes done by LB
Different ways:
a. Random selection - can cause problem, by chance one server can be overloaded
b. Round Robin selection - goes in one order and then follow the same order again and again
c. Weighted Round Robin - a little more request for more powerful server 
d. Based on performance - LB does a health check for all the servers(how long the server is taking to respond), accordingly LB will redirect the request to better performant server
e. IP based - Hash the IP address of the client and with this hash value, select the node. This can help in increase cache hit as we can use the same has to select the cache
f. Path based - 

5. How to make sure that LB is not single point of failure?


6. How to scale load balancers?
