#SpringBoot Interview Questions

**IOC container**

-Find Beans
-Wire Dependencies
-Manage Lifecycle of the Bean

When IOC container sees @Component, it creates a bean for these classes, it needs to be managed by Spring.

ApplicationContext is an advanced IOC container.(Advanced version of BeanFactory)
Spring recommends ApplicationContext.

ApplicationContext can be created using @Configuration.

@Autowired - Spring should find the matching bean and wire the dependency in.

@Component - generic component.
@Repository - encapsulating storage, retrieval and search behaviour typically from a relational db.
            - Some extra logic is added by Spring. ex: exception handling for repository
@Service - Business Service facade.
@Controller - Controller in MVC pattern, typically used in Web Layer.

**Scope of Bean**

1. Singleton - one instance per Spring Context - default scope in Spring
2. Prototype - new bean whenever requested
3. Request - One bean per Http request - applicable only for web applicationContext
4. Session - One bean per Http session - applicable only for web applicationContext

**Setter and Construction injection**

Use setter for injection or class constructor for dependency injection.

@Autowired
Todoservice service; //Spring uses reflection for injection, this fits into the category of setter injection.

Spring recommends Constructor Injection.

Autowiring
-By Type
-By Name

**@Primary:**

@Component
@Primary
public class BubbleSort implements Sort{}

**@Qualifier:**

@Autowired
@Qualifier("main")
private sort sort;

@Component
@Qualifier("main")
public class BubbleSort implements Sort{}

**Dispatcher Servlet**

Any request which comes to the server, comes to DispatcherServlet first.
then DispatcherServlet looks at the handler mapping and then routes accordinly.

**SpringBoot**

It autoconfigures DispatcherServlet, Datasource, EntityManagerfactory or Transaction Manager.
Looks at the framework/dependency in classpath and autoconfigures them.(ex: hibernate)

Spring Boot auto-configuration automatically configure a Spring application based on the dependencies 
present on the classpath. Spring Boot detects classes in the classpath 
and auto-configuration mechanism will ensure to create and wires necessary beans for us. 
This is one of the most powerful feature of the Spring Boot and most of the work happens silently in the background.

It is very easy to develop Spring Based applications with Java or Groovy.
It reduces lots of development time and increases productivity.
It avoids writing lots of boilerplate Code, Annotations and XML Configuration.
It is very easy to integrate Spring Boot Application with its Spring Ecosystem like Spring JDBC, Spring ORM, Spring Data, Spring Security etc.
It follows “Opinionated Defaults Configuration” Approach to reduce Developer effort
It provides Embedded HTTP servers like Tomcat, Jetty etc. to develop and test our web applications very easily.
It provides CLI (Command Line Interface) tool to develop and test Spring Boot(Java or Groovy) Applications from command prompt very easily and quickly.
It provides lots of plugins to develop and test Spring Boot Applications very easily using Build Tools like Maven and Gradle
It provides lots of plugins to work with embedded and in-memory Databases very easily.

@SpringBootApplication consists of 3 things:
1. @SpringBootConfiguration
2. @EnableConfiguration
3. @ComponentScan

**REST**

It is a style of software architecture for distributed hypermedia systems.
It makes the best of HTTP.
No format for data exchange - JSON is popular.
Transport - only HTTP

Difference between GET, POST and PUT:

GET is used to request data from a specified resource.
POST is used to send data to a server to create/update a resource.
PUT is used to send data to a server to create/update a resource.

The difference between POST and PUT is that PUT requests are idempotent. 
That is, calling the same PUT request multiple times will always produce the same result. 
In contrast, calling a POST request repeatedly have side effects of creating the same resource multiple times.

**How to secure Rest API**

1. Always use HTTPS
2. Never expose information on URLs - Usernames, passwords, session tokens, and API keys should not appear in the URL, 
    as this can be captured in web server logs, which makes them easily exploitable.
3. Basic Auth can be used
4. The OAuth 2.0 authorization framework enables a third-party application to obtain limited access to an HTTP service,
    either on behalf of a resource owner by orchestrating an approval interaction between the resource owner 
    and the HTTP service, or by allowing the third-party application to obtain access on its behalf.
5. JWT authentication
6. Rate Limiting        








