# Json Web Token

**What is JWT and why is it used?**

-Open Standard(RFC 7519)
-Securely transfer information between two bodies
-Digitally signed - info is verified and trusted
-Compact [JWT can be sent via URL, POST request, HTTP header]
-Fast Transmission
-Self Contained
-Helps in avoiding multiple query the database more than once.

JWT is useful for authentication and for information exchange.

It consists of:
-Header
-Payload
-Signature

**How does JWT works?**

1. Browser/Client posts request to login with Credentials to the server.
2. The server generates JWT via Secret and then returns the JWT to the browser/client.
3. Now the browser/Client sends new requests with JWT on the Authorization header.
4. The server checks JWT Signature and gets user info and then sends back response to the client.


**How to maintain session in distributed systems??**

Avoid using sessions, and just use a signed cookie to identify the users (and possibly contain a few additional information).
A JSON web token could be a good solution. Get everything else from the database when you need it. 
This ensures scalability and failover, and, IMO, often makes things simpler on the server instead of making it more complicated.

**OAuth Understanding**

OAuth is used for Authorization. Used for Authorization between services.
Latest version is OAuth 2.0
Kind of an Access Delegation.
OAuth Access Token contains user-allowed permission and is trustable.
