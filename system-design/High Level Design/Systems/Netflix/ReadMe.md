# Video Streaming Service like Netflix

**Functional Requirements**
1. Upload Videos
2. Users Homepage + search
3. Play videos
4. Support all devices

**Non-Functional Requirements**
1. No Buffering -> Low Latency + High Availability
2. Increase Users session time -> Good Recommendation Engine

Actors in the system:
1. Clients - a device, ex - mobile, laptop
2. Users - the user who is viewing the content
3. Production Houses - users who are uploading content

Client will tell which device is on and which formats of content is supported by it.
Example : If the client is streaming video and the future chunk of videos are coming slowly then it should switch
to low quality of video. Figures at run time, the current bandwidth of the network.(Adaptive Bitrate Stream)



