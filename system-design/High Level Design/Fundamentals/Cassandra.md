# Cassandra

It is a Open Source and NoSql distributed database technology.
It provides massive scalabilty and high availability.

Cassandra's group of nodes is known as cluster. Each node has functionality as other.
A cassandra cluster can easily be spread across multiple data centres.

Snitch is how the nodes in a cluster know about the topology of the cluster.

Ways to define Snitch:
1. Dynamic snitching
2. Simple Snitch - this is the default Cassandra snitch
3. GossipingPropertyFileSnitching etc

Gossip is how the nodes in a cluster communicate with each other.
Every one second, each node communicates with up to three other nodes, exchanging info about itself and
all other nodes that it has info about.

Data distribution is done through consistent hashing, to strive for even distribution of data across the nodes in a cluster.

To distribute the rows across the nodes, a partitioner is used.
The partitioner uses an algo to determine which node a given row of data will go to. 
The default partitioner in Cassandra is Murmur3.

Each node in a cluster is assigned one token range.

A replication factor must be specified whenever a database is defined.
The replication factor specifies how many instances of the data there will be within a given database.
Ex: if the replication factor is 3 then data will be written in 3 nodes.

In Casssandra, a database is defined as a keyspace.
Within keyspace, multiple tables can be defined.

**Consistency**

Consistency has to do with the accuracy of data when there is more than one replica of the data.
A consistency level is specified per read or write request with a default consistency level set by the client driver.
The default consistency level is one, unless changed.

Different consistency levels: One, Two, Three, Quorum, Local Quorum and All.

**Data Modelling**

->Cassandra deals with unstructured data.
->Cassandra has a flexible schema.
->In Cassandra, a table is a list of “nested key-value pairs”. (ROW x COLUMN key x COLUMN value)









