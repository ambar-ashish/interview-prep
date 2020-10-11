# Design a Cab Service like Uber

**Functional Requirements**

1. See Cabs
2. ETA and approx price
3. Book a cab
4. Location Tracking

**Non-Functional Requirements**

0. Global
1. Low Latency
2. High Availability
3. Highly Consistent (Certain Components Need to highly consistent, certain others as highly available)
4. Scale

**Design**

Divide the city into no of subareas(rectangle). So have all the coordinates of the subareas boundaries.

MapService - responsible for dividing city into certain subareas
           - driver location, user location
           - calculate eta for user
           
User Service for user Details
    - MySql + Redis
    
Cab Request Service
    - make a websocket connection with the users app
    - places a request to cab finder
    
Driver service
    - MySql + Redis
    
Driver app has a web socket connection with Location service(location is sent every 5 secs)

        
        
                                   

