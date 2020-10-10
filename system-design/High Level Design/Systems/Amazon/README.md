# Design ECOMMERCE System like Amazon

**Functional Requirements**

1. Search
2. Cart/WishList
3. Checkout
4. View Orders

**Non-Functional Requirements**

1. Low Latency
2. High Availability
3. Highly Consistent

These NFRS are not valid on each service.
Example : Transaction service should be highly consistent and its ok if normal available
        : Search service should be highly available and eventual consistency is ok.
User facing components should be having low latency.

**Designing the components**

User Home Page will have Recommendation service.

Items data can be stored in MongoDB as items have different properties and these details vary and are unstructured.

User Search page will have search service.        