# Distributed Transactions

**1st solution:**

Let's have 2 microservices share the same database

**2nd Solution:**

Two phase commit:
1. Prepare phase
2. Commit phase

The orchestrator will take care of 2 phase commit.
1. The orchestrator creates the transation id.
2. It will ask customer wallet and order wallet to prepare as the transaction is going to happen.
   If the wallets have balance then both rows are locked via DB transaction. And both services will reply ok to orchestrator. 
3. Now the second phase will start, COMMIT.
   And both the wallets are committed now as they are good to go.
   
The coordinator should have a time-out to abort transaction.
Strong consistent model for transaction.
The resources are locked which is not good as it creates latency.    

**3rd solution**

Three Phase Commit:

1. One Extra Steps in between called as PreCommit which means Commit is now authorized to be done.
    Checks all the participants have agreed for transaction or not.
    
**4th Solution - SAGA**

Other solutions were synchronous.
SAGA is asynchronous. 

Used Queues for this SAGA pattern.
Different microservices will be required for successfull as well as rollback/timeout scenarios to be handled.  

Sequential events + Local transactions = Isolation  
 



