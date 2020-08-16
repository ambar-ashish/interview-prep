# Content Delivery Network

Instead of getting the content from origin server, we get the content from closest available servers which is edge server.

Benefits:
1. Speed - you get the content from closest
2. Scalability - Performance Improvement
3. Origin - High Uptime
4. Security. DDos resistance

The content at edge server can be pushed by origin server or edge server can have capability of getting data from origin server.

Example:
We have 1 origin server and 5 edge servers in different parts of the world.
Now we can configure AWS Route53(configure DNS mapping) policy to figure out the closest edge server and send the request 
when a request comes from a client anywhere in the world.
So the browser points to the Domain URL and traffic gets distributed from Route53 to different edge servers.

Issues:
1. Delay in content to the customer.
2. Caching issues.

How AWS Route53 does Geo-based routing?
Geolocation works by mapping IP addresses to locations. However, some IP addresses aren't mapped to geographic locations, 
so even if you create geolocation records that cover all seven continents, Amazon Route 53 will receive some DNS queries from locations that it can't identify. 
You can create a default record that handles both queries from IP addresses that aren't mapped to any location and queries that come from locations 
that you haven't created geolocation records for. 
If you don't create a default record, Route 53 returns a "no answer" response for queries from those locations.



