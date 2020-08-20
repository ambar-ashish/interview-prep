#Apache Kafka

Apache Kafka is a community distributed event streaming platform capable of handling trillions of events a day. 
Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.
Kafka has quickly evolved from messaging queue to a full-fledged event streaming platform.

-Distributed, Resilient Architecture and Fault tolerant
-Horizontal Scalable
-High performance(latency of less than 10ms)

It can be used as:
-Messaging system
-Activity tracking
-Gather metrics
-Application Log gathering
-Stream processing
-De-coupling of system dependencies

**Kafka Ecosystem**

-kafka can be managed by Zookeeper

1. In general, clients(Data producers) like Apps, Website, Financial Systems, Email, Customer data, Databases push data to Kafka.
2. [Real Time Work]Then this kafka can be connected to Spark, Storm etc to Real Time analytics, Dashboards, Alerts.
3. [Batch work]this kafka can be connected to hadoop, Amazon S3, RDBMS for Data science, Audit, reporting ot backup.

**Topics and Partition**

Topics
-a particular stream of data
-Similar to a table in database(without all the constraints)
-Can have as many topics as you want
-A topic is identified by its name

Topics are split into Partitions. Each partition is ordered.
Data is kept only for a limited time. Once the data is written in partition, it cant be changed.
Data is assigned randomly to a partition unless a key is assigned.

**Brokers**

A Kafka cluster is composed of multiple brokers(servers).
Each broker is identified with its ID(integer).
Each broker contains certain topic partitions.[data is distributed, hence any partition can be on any broker]
After connecting to broker, you will be able to connect to entire cluster.
Kafka automatically connects to the required partition.

Topics should have a replication factor > 1.(usually between 2 and 3).
This way if a broker is down, another broker can serve the data.

At any time, only 1 broker can be the leader for a given partition.
Only a leader can receive data and serve data for a partition. Other brokers will sync the data.

Producers sending data to kafka, we only need to specify topic name and broker, everything else is handled by Kafka.
Consumers can read data from topic. Just specify topic name and broker name.


 










