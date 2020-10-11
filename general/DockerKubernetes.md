# Docker Kubernetes GraphQL

**Docker**

What is containerization?
Usually, in the software development process, code developed on one machine might not work perfectly fine 
on any other machine because of the dependencies. This problem was solved by the containerization concept. 
So basically, an application that is being developed and deployed is bundled and wrapped together 
with all its configuration files and dependencies. This bundle is called a container.

Docker is a containerization platform which packages your application and all its dependencies together 
in the form of containers so as to ensure that your application works seamlessly in any environment, 
be it development, test or production.

Here are the essential features of Docker:

-Easy Modeling
-Version control
-Placement/Affinity
-Application Agility
-Developer Productivity
-Operational Efficiencies

**Kubernetes**

Kubernetes is an open-source container management tool which holds the responsibilities of container deployment,
scaling & descaling of containers & load balancing. Being the Google’s brainchild, 
it offers excellent community and works brilliantly with all the cloud providers. 
So, we can say that Kubernetes is not a containerization platform, but it is a multi-container management solution.

What is Container Orchestration?

Consider a scenario where you have 5-6 microservices for an application. Now, these microservices are put in 
individual containers, but won’t be able to communicate without container orchestration. 
So, as orchestration means the amalgamation of all instruments playing together in harmony in music, 
similarly container orchestration means all the services in individual containers working together 
to fulfill the needs of a single server.

Highly scalable and scales fast, Kubernetes can do auto-scaling.
Manual intervention needed for load balancing traffic between different containers and pods.
Can deploy rolling updates and does automatic rollbacks.
In-built tools for logging and monitoring.

**Helm Charts**

HELM is an open-source package manager for Kubernates, a powerful container orchestration platform for modern applications.

Kubernetes has a lot of components like pods, services, replicasets and deployments each requiring 
their own manifest files. This makes managing the complete lifecycle of an application cumbersome. 
Helm, like any other package manager, eases out management, up-gradation, and dependency resolution of Kubernetes resources.

Helm has a server component – ‘Tiller’, which is deployed in the same Kubernetes cluster as other deployments. 
Tiller essentially listens and acts on the commands administered through the ‘Helm’ CLI tool and convert 
those to Kubernetes manifests.

A typical helm chart consists of templates, values.yaml, and chart.yaml. 
Chart.yaml consists of all the metadata related to the deployment like an owner, email, version, etc. 
Values.yaml have all the default configurations needed for the application to function. 
The fields in values.yaml can be overridden to custom values based on the requirements.

**GraphQL**

GraphQL was initially developed by Facebook as an internal solution for their mobile apps.
It was designed to optimize RESTful API calls and provide a flexible, robust, and efficient alternative to REST.
It is not a replacement for REST. It is an alternative to writing APIs using REST.

GraphQL is a query language for APIs - not databases. In that sense it’s database agnostic 
and can be used with any kind of database or even no database at all.

GraphQL is a query language created by Facebook in 2012 which provides a common interface between the client 
and the server for data fetching and manipulations.

The client asks for various data from the GraphQL server via queries. 
The response format is described in the query and defined by the client instead of the server: 
they are called client‐specified queries.

The structure of the data is not hardcoded as in traditional REST APIs - this makes retrieving data 
from the server more efficient for the client.

GraphQL supports reading, writing (mutating), and subscribing to changes to data 
(realtime updates – most commonly implemented using WebHooks)

The main and most important difference between REST and GraphQL is that GraphQL is not dealing with dedicated resources, 
instead everything is regarded as a graph and therefore is connected and can be queried to app exact needs. 