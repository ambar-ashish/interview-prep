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
After connecting to any broker, you will be able to connect to entire cluster.
Kafka automatically connects to the required partition.

Topics should have a replication factor > 1.(usually between 2 and 3).
This way if a broker is down, another broker can serve the data.

**Concept of leader for a partition**

At any time, only 1 broker can be the leader for a given partition.
Only a leader can receive data and serve data for a partition. Other brokers will sync the data.
Therefore, each partition has one leader and multiple ISR(in-sync replica)

**Producers**

Producers write data to topics.
Producers sending data to kafka, we only need to specify topic name and broker, kafka will automatically take care of
routing the data to the right brokers.
Producers can choose to receive acknowledgement for data writes.
-> ACK0 - Producers wont wait for acknowledgement(possible data loss)
-> ACK1 - Producer will wait for leader acknowledgement(limited data loss)
-> ACK-ALL - Leaders + replica acknowledgement - (no data loss)
Producers can choose to send a key with the message.
If a key is sent, then the producer has the guarantee that all the messages for that key 
will always go to the same partition. This enables ordering.

**Consumers**

Consumers can read data from topic. Just specify topic name and broker name.
Consumer-groups:
-Consumers read data in consumer groups

Cluster consists of multiple brokers(servers).
Each broker can have multiple topics.
Each topic has partitions and these partitions have offsets.

**Global unique identifier of a message**
Topic Name, Partition Number and Offset

**Difference between kafka and rabbitmq**

1. Distribution and parallelism
Kafka distributes consumers by topic partitions. Each consumer from the group is assigned to one partition. 
The partition mechanism can be used to send different sets of messages by business keys (e.g., location or user ID).

In RabbitMQ, the number of consumers can be scaled out, which means that each queue instance will have many consumers. 
This makes message processing spread to all active consumers, but a message can only be processed once.

2. High Availability
Both frameworks are highly available. However, Kafka has an edge as it uses Zookeeper to manage the state of the cluster. 
A Zookeeper keeps track of the status of Kafka cluster nodes, Kafka topics, partitions, etc.

3. Performance
Kafka supports the strength of sequential disk I/O and requires less hardware. 
This leads to a high throughput - several millions of messages per second - with a tiny number of nodes.

RabbitMQ can also process a million messages per second but it requires above 30 nodes.

4. Replication
Kafka has replicated the broker by design. This means that if the master broker is down, all the work is
automatically passed to another broker which has a full replica of the dead one; hence, no message is ever lost.

In RabbitMQ queues aren’t automatically replicable.

5. Message ordering
Since Kafka has partitions, messages can be received by ordering. This can’t be achieved in RabbitMQ.

6. Multi subscriber
In Kafka, a message can be subscribed by multiple consumers.

In RabbitMQ, a message can only be consumed once, and once it is consumed, the message disappears and becomes inaccessible.

7. Message protocols
Kafka supports primitives (int8, int16, int32, int64, string, arrays) and binary messages.

RabbitMQ supports almost all standard queue protocols like AMQP, STOMP, HTTP, and MQTT.

8. Message lifetime
Since Kafka is a log, messages are always there. RabbitMQ is a queue that removes messages once they are consumed.

9. Message acknowledgment
Both frameworks give confirmation to the producer when messages arrive in the topic/queue.

10. Flexible routing to a topic/queue
In Kafka, a message is sent to the topic by a key; however, in RabbitMQ, there are more options 
(e.g., sending a message using regular expressions).




 










