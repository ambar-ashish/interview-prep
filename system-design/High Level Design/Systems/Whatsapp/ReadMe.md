# Whatsapp System Design

The connection between users will be a duplex connection which is a bi-directional connection.

The connection here with client and server can be TCP, UDP, Long Polling or Web Sockets.

When userA sends a message then the message should be fist saved in users phone(in built SQL lite DB).
Once the connection happens with the messaging server then the message is pushed to messaging server from local DB.

Lets say the userB which was supposed to receive the messages is offline, then the message is stored in Server DB.
Once userB comes online, then the message is pushed to userB.

So in overall architecture, the client tries to establish connection with the servers everytime.

**Acknowledgement**

Single Tick - when server acknowledges that it has received the message
Two Tick - When the server is able to connect to userB, then sends 2 tick to userA.
Blue Tick - When the userB opens the app and sees the message, the userB sends to server and this in turn sent to userA.

**Messaging Server**

When UserA connect to messaging Server, one process(pID)/thread is allocated to userA and it is fully responsible for all
the messaging handling for userA till he disconnects from the server.
This process will be connected to a Queue(acts as a buffer for messages).

The table will contains pID and UserId details.
When userA wants to send message to userB then userA pid checks in the database the pid of userB.
So pidA sends the messages to pidB's queue and pidB send this message to already established connection to userB.

Edge Case:
when userA sends message to userB and userB is not connected then there is no PidB.
So the userBId and message is stored in a different table.
So now when userB connects to the system, then the first pid and userid table is updated and it checks
in the database if there are any unread messages and then starts sending to userB.

**How to implement Last Seen feature?**

We will use a heart beat mechanism where lets say userA send to server every 5 seconds that user is active in the system.
A table with userId and Timestamp. (Epoch Time, the column is udpated every 5 seconds)

**Media upload/download**

Whenever media(pic/video) is uploaded, it does not user the chat connections.
Instead the image is directly uploaded to server(AWS S3) and the url is returned back(S3 presigned url).
And then the details like sentuserId, media type, media url, receiveruserId is updated in the table.
Now the message containing url of media is sent to receiver in the chat connection and receiver directly downloads
from the server.

**Encryption**

Two types:
1. Both parties use the same key to encrypt/decrpyt messages.
2. Asymmetric - UserA will both public and private key and sends this public key to other users for decryption.

Tech Stack used by Whatsapp:
1. Erlang - fast performance(Whatsapp team is able to manage 10 million connections in 1 server)
2. FreeBSD OS
3. Amnesia DB - KV store
4. YAWS for connections



