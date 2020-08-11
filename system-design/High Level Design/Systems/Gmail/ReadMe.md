# Gmail Design

**Requirements:**
1. Registering a user
2. Login (2-factor auth)
3. Profile creation
4. Set preferences
5. Sending emails (with attachments)
6. Searching Emails
7. Tagging Emails
8. Spam and Virus Detection

**Design Points**
The client can be the website, mobile app so it wont be directly connected to our service.
We will be having a Proxy Server/Gateway in between.
This gateway can have the following responsibilities, but ideally we should decouple them:
1. Routing external requests
2. Blacklist IPs(having rate limiter inside)
3. Translates the requests(The client requests can be in HTTP but internal services communication protocol can be different)

Lets say there are multiple services like Auth service, Profile service etc.
Then gateway will have a logic of sending the requests to the correct internal service.
Example:
Lets say the request is:
gmail.com/auth?username=user1&password=XXX

Here gmail.com will be directed to out Gateway using DNS(DNS has a mapping of domain name with IP address) 
and then auth will be redirected to AUTH service
 
if(request.name == "auth"){
    request.fowardTo(AuthService);
}else.....

Generally gateway will have a mapping saved with it:
Like : if register -> Auth Servuce, if updateProfile -> ProfileService

Update on the above design:
1. We can give this mapping to a difference service called Service Manager and decouple Gateway
2. Now Gateway will check with Service Manager and then gateway will send the request to corresponding service.

Once the Auth service gets the request, it will save the data in one table called as
USER which columns lets say userid, password(encrypted), phone number and other table
CODE_VERIFICATION will have column such as userid, code, isVerified(default false) and timestamp(for code expiry)

This code is sent by Notification Service which has SMS template for the same.

Once the user enters the code, again sends a request gmail.com/verify?username=user1&code=1234,
this request is again to sent to Auth, which verifies the code and expiry time, internally sets isVerified = true 
and then registers the user.

Now user can create a profile -> [POST request] gmail.com/createProfile

In our current system here, ALL THE SERVICES ARE DISTRIBUTED SERVICES, hence Service Manager need to verify constantly 
if all the registered Services servers are up or not. Need some HEARTBEAT MECHANISM[service discovery] here

**LOGIN**

Once the user has been authenticated, then we should return back a auth token(JWT token) and this token is stored
in tokens table with userid, token and TTL.
So now, every time the user sends request to our system with userid and this token. 
This token can be invalidated by the system(Auth service) as well.

So rather than for every request, we hit Auth service for verifying token, we can have a global cache with userid and token.
The updation of this cache can he handled by Auth service. Message queue can be used to notify this cache.

**API requests and contracts**
Lets say we are sending a post request with JSON object to gateway, then this JSON object is converted to Java/Language object.

**Sending Email**
When we upload an image/file in our mail, the image/file is uploaded to a blob storage[Drive service will take of this job] 
and the email contains the URL for this blob storage.

SendEmail service will have table called EmailStore which has columns as Id, To, From, Subject, Timestamp and
another table called Content which has columns as Id and Content. This Content will contain a json body with message content and
message attachments.

VirusChecker service will be checking in Content table and as well as drive service which uploads the attachments.

SpamDetector service can be on Contents table and as well as on Subject column in Emailstore table. It tags the emails with Spam tags.
SpamDetector can either be a cronjob or the Emailstore can publish data to queue[Kafka or any mesasging queue] and SpamDetector can subscribe to this queue.

VirusChecker and SpamDetector are eventual consistent.

**Search Functionality**
In the background, a search engine can run such as ElasticSearch(very good for text search).
This search engine can subscribe to the Emailstore queue to search emails efficiently.












 






   
 
