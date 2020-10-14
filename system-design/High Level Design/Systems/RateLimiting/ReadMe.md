# Rate Limiting

**First Solution**

Each server can have queue and the servers will take requests from queues.
If the requests coming to these queues reach the limit of queue size the start ignoring the requests.
In this way, the specific server will not be overloaded but bad user experience is still there.
So, may be give error response as try again after some time.

**When the sudden spike comes up, example Black Friday**

1. Scale Before-Hand (Pre-scale)
2. Auto-scaling

**How to handle Job Scheduling spike?**

1. Example sending email on new year notification on 1st Jan
2. Do a batch processing

**When a post becomes popular**

1. Batch processing again
2. Adding jitter(done by Youtube) - No of views and likes are Approximated by Youtube
   - hence saving alot of queries for getting metadata of a post
   
**Cache the precomputed same request, hence improving the performance**

**Gradual Deployments to understand the performance in some cases only**


   
   
    