# Design Pattern Interview Questions

**Strategy Pattern - Behavioral**

In computer programming, the strategy pattern is a behavioral software design pattern that enables 
selecting an algorithm at runtime. Instead of implementing a single algorithm directly, 
code receives run-time instructions as to which in a family of algorithms to use.

public interface Strategy {
   public int doOperation(int num1, int num2);
}

**Chain of Responsibility Pattern - Behavioral**

In object-oriented design, the chain-of-responsibility pattern is a design pattern consisting 
of a source of command objects and a series of processing objects.

Chain of Responsibility is a behavioral design pattern that lets you pass requests along a chain of handlers. 
Upon receiving a request, each handler decides either to process the request or to pass it to the next handler 
in the chain.

Request -> Request validation -> Authentication -> Authorization -> Final Processing

**Observer Pattern - Behavioral**

Observer is a behavioral design pattern that lets you define a subscription mechanism 
to notify multiple objects about any events that happen to the object they’re observing.

The object that has some interesting state is often called subject, but since it’s also going 
to notify other objects about the changes to its state, we’ll call it publisher. 
All other objects that want to track changes to the publisher’s state are called subscribers.

**Factory Pattern - Creational**

In class-based programming, the factory method pattern is a creational pattern that uses factory methods 
to deal with the problem of creating objects without having to specify the exact class of the object that will be created.

Factory Method is a creational design pattern that provides an interface for creating objects in a superclass,
but allows subclasses to alter the type of objects that will be created.

**Singleton Pattern - Creational**

It restricts the instantiation of a class to one "single" instance. 
This is useful when exactly one object is needed to coordinate actions across the system. 

Singleton is a creational design pattern that lets you ensure that a class has only one instance, 
while providing a global access point to this instance.

Example 1 : 
public class EagerInitializedSingleton {
    
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
    
    //private constructor to avoid client applications to use constructor
    private EagerInitializedSingleton(){}

    public static EagerInitializedSingleton getInstance(){
        return instance;
    }
}

Example 2 : 

public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;
    
    private StaticBlockSingleton(){}
    
    //static block initialization for exception handling
    static{
        try{
            instance = new StaticBlockSingleton();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
    
    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}

Example 3 :

public class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;
    
    private LazyInitializedSingleton(){}
    
    public static LazyInitializedSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}

Example 4 : 

public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;
    
    private ThreadSafeSingleton(){}
    
    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
    
} 

**Facade Pattern - Structural**

Facade is a structural design pattern that provides a simplified interface to a library,
a framework, or any other complex set of classes.

A facade is a class that provides a simple interface to a complex subsystem which contains lots of moving parts. 
A facade might provide limited functionality in comparison to working with the subsystem directly. 
However, it includes only those features that clients really care about.

Example : Using any SDK in our language