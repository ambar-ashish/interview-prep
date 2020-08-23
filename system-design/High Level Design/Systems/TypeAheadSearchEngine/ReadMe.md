# TypeAhead Search Engine Design

Tries will be used to store all the words.
Each Trie node will store a list of most frequent words on that prefix node as well.

Steps:
1. Client will send a request to Load balancers.
2. Load balancers will send the request to the any of the distributed nodes with the keyword for search(ex: azure).
3. The node will check in global cache if the keyword exists and if present then the node will return the list of frequent words
back to the load balancer to the cache.
4. If not present then the node will check with Zookeeper which Service to check for the prefix because:
T1 will be storing from a-h starting data.
T2 will be storing from i-p
T3 will be storing from q-z
5. Since our keyword (azure) starts from a, the zookeeper will return T1 to our node
6. Our Node will check in T1 and T1 will return will be sent to the client.
 