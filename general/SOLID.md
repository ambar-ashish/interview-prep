# SOLID, ACID

**Single-responsibility principle**

A class should only have a single responsibility, that is, only changes to one part of the software's specification 
should be able to affect the specification of the class.

**Open–closed principle**

Software entities ... should be open for extension, but closed for modification.

**Liskov substitution principle**

Objects in a program should be replaceable with instances of their subtypes without 
altering the correctness of that program.

**Interface segregation principle**

Many client-specific interfaces are better than one general-purpose interface.

**Dependency inversion principle**

One should "depend upon abstractions, [not] concretions.

**ACID**

1. Atomicity

A transaction is an atomic unit; hence, all the instructions within a transaction will successfully execute, 
or none of them will execute.

The following transaction transfers 20 dollars from Alice’s bank account to Bob’s bank account. 
If any of the instructions fail, the entire transaction should abort and rollback.

2. Consistency

A database is initially in a consistent state, and it should remain consistent after every transaction. 
Suppose that the transaction in the previous example fails after Write(A_b) and the transaction is not rolled back;
then, the database will be inconsistent as the sum of Alice and Bob’s money,
after the transaction, will not be equal to the amount of money they had before the transaction.

3. Isolation

If the multiple transactions are running concurrently, they should not be affected by each other; 
i.e., the result should be the same as the result obtained if the transactions were running sequentially,

4. Durability

Changes that have been committed to the database should remain even in the case of software and hardware failure. 
For instance, if Bob’s account contains $120, this information should not disappear upon hardware or software failure.