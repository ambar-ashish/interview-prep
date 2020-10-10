# Microservices

https://codingnconcepts.com/top-microservices-interview-questions/

**Monolith**

One app which has every service packed in it.
Advantages:
1. Simple to Develop
2. Simple to Deploy
3. Simple to Scale

Diadvantages:
1. Complex when more users in the system
2. Tech dependent(Only 1 language can be used)
3. Scaling data layer
4. Tight coupling hence managing services is a problem
5. Overloaded VM/containers
6. CI/CD Test, Build Conflicts
7. Not easy to understand for new joinees in the team

**Microservices Functional Decomposition**

- based on Functional Area/service
- each service can be scaled horizontally depending on the traffic for the particular service

Each service can have their own database (Polyglot persistence)

1. Key/Value database - Session data, shopping carts
2. MongoDB - Product catalog, User Accounts, Domain Objects
3. RDBMS - Payment systems, reporting
4. Graph Databases - Social Data, Recommendations

Disavantage of multiple Databases in Microservice architecture:
1. Joins are not easy at all

Advantages:
1. Scaling is easier(Lets say search is having high traffic so we can easily scale horizontally)
2. Deploy easy
3. No dependency on tech stack
4. Faster to develop and understand
5. Loosely coupled

Disadvantages:
1. Interprocess communication
2. Distributed transactions(2 phase commit or SAGA)
3. More resources
4. Debugging issues

**API Gateway**

Client calls API Gateway and API can internally act as a broker between client and server.
No Access to Backend APIs from outside world.

**Service Discovery/Registry**

Its like a database which contains all the service details with the IP addresses for routing
- The services keeps on updating the updated IPs or status to service registry(heart beat mechanism)
So the LoadBalancer/API Gateway will connect to service registry for services mappings with IPs for routing requests.

**Circuit Breaking**

Circuit Breaker caches the response of other services. So it knows which service had sent error response previously.
FallBack mechanism - Since it knows which service replica is down hence re-routes the request to
 other up and working service replica.
 
**Microservice Deployment Strategy**

Criterias:
1. Scalability and throughput
2. Reliable and available
3. Isolation
4. Resource Limit
5. Monitor
6. Cost-effective

Patterns:
1. Multiple service per host
2. Service per VM/container
3. Serverless - Focus on code, no worries about scaling, pay as you go

**How do you troubleshoot an issue using logs in microservices based application ?**

1. We should have a centralized logging system where each microservice push their logs to Splunk 
or ELK (Elastic Logstash Kibana) and we can use their built in dashboards to look at the logs for debugging.

2. We can generate a requestId for each external request, which is passed to all the microservices 
which are involved in handling the request. Include this requestId in all log messages pushed to splunk or ELK. 
We can troubleshoot any request end to end using this requestId if something goes wrong.  

**How do you manage configuration in microservices based application ?**

We use externalize configuration to solve this problem by keeping the configuration information in an external store 
such as github, database, filesystem, or environment variables or even a configuration server. 
At startup, microservices load the configuration from the external store or configuration server.

Netflix Archaius and Spring Cloud Config Server provides ready made solution for externalize configuration.





