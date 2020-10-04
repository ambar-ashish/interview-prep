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

It autoconfigures DispatcherServlet, Datasource, EntityManagerfactory or Transation Manager.
Looks at the framework/dependency in classpath and autoconfigures them.(ex: hibernate)

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








