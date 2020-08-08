# Client Server Model

Client requests data from server
Server responds to clients

Client does not know the address of the servers but knows that it can communicate with these servers
and can request stuff from these servers.

Example:
When we type https://www.google.com, our browser does a DNS Query and gets the IP address then only talk to the servers.

DNS Query is a special request which to goes to pre-determined servers to get the IP address of google.com and gives this
IP address back to the client.

IP address is a unique identifier of a machine.

How is IP address is assigned to any machine connected the internet?
-->

DNS:
HTTP:
way to send info to server. It sends a bunch of bytes in packets. The request will contain the client IP address as well.
The server then can use this client address to send back the response.

The server listens on specific port. The client should specify the port on which the communication needs to happen.
If a client is using HTTP then in general the port will be 80, HTTPS 443.

IP: Internet protocol
The network protocol outlines how almost all machine to machine communications should happen in the world.
TCP, UDP, HTTP are built are top of IP

TCP: Transmission Control protocol
Allows for ordered, reliable data delivery between machines over the public internet by creating a connection.

HTTP: Hyper Text Transmission Protocol
implemented over the top of TCP. Clients make HTTP requests and server responds with a response.HTTP

IP packet:
smallest unit used to describe data being sent over IP. The IP packet consists of:
IP header : contains source and destination IP address and other network info
IP Payload : The data which is being sent over the network.

2 versions of IP, IPv4 and IPv6
IP packets are limited in size, 2^16 bytes which in MB are very very less

TCP is meant to send IP packets in an ordered way and there is guarantee that all the packets will be received.
If any packet gets corrupted during communication there we will get to know in TCP and can be resent.
Extra TCP header will contain more data related to ordering and evreything else.

When a client tries to connect with server using TCP then it first it tries to create a TCP connection using handshake.

HTTP: introduces the idea of client-server communication using request-response protocol.
This protocol helps us create robust and maintainable systems.

# Storage

Databases - programs that either use disk or memory to do 2 things : record data and query data

Disk - Non-volatile storage
1. HDD : hard-disk drive
2. SSD : solid-state drive
SSD is far faster than HDD but also more expensive.

RAM - volatile memory


