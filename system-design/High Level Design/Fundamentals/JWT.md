# Json Web Token

**What is JWT and why is it used?**

**How to maintain session in distributed systems??**

Avoid using sessions, and just use an signed cookie to identify the users (and possibly contain a few additional information).
A JSON web token could be a good solution. Get everything else from the database when you need it. 
This ensures scalability and failover, and, IMO, often makes things simpler on the server instead of making it more complicated.