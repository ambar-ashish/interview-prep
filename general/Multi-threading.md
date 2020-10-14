# Multi-threading

**Program vs Process vs Thread**

A program is a set of instructions and associated data that resides on the disk and is loaded 
by the operating system to perform some task. 

A process is a program in execution. A process is an execution environment that consists of instructions, user-data,
and system-data segments, as well as lots of other resources such as CPU, memory, address-space, disk and 
network I/O acquired at runtime.
 
Thread is the smallest unit of execution in a process.

In preemptive multitasking, the operating system preempts a program to allow another waiting task to run on the CPU.

Java’s most fundamental construct for thread synchronization is the synchronized keyword. 
It can be used to restrict access to critical sections one thread at a time. 

Each object in Java has an entity associated with it called the "monitor lock" or just monitor. 
Think of it as an exclusive lock. Once a thread gets hold of the monitor of an object, 
it has exclusive access to all the methods marked as synchronized.

In the Java language framework, there are multiple ways of setting up threads.

1. Runnable interface
class Demonstration {
     public static void main( String args[] ) {
         
         ExecuteMe executeMe = new ExecuteMe();
         Thread t = new Thread(executeMe);
         t.start();
     }
 }
 
 class ExecuteMe implements Runnable {
  
   public void run() {
     System.out.println("Say Hello");
   }
   
 }
 
2. The second way to set-up threads is to subclass the Thread class itself as shown below.

class Demonstration {
    public static void main( String args[] ) throws Exception {
        ExecuteMe executeMe = new ExecuteMe();
        executeMe.start();
        executeMe.join();
      
    }
}

class ExecuteMe extends Thread {
  
  @Override
  public void run() {
    System.out.println("I ran after extending Thread class");
  }
  
}

The con of the second approach is that one is forced to extend the Thread class which limits code's flexibility. 
Passing in an object of a class implementing the Runnable interface may be a better choice in most cases. 

**Executor Framework**

In Java, the primary abstraction for executing logical tasks units is the Executor framework and not the Thread class. 
The classes in the Executor framework separate out:

1. Task Submission
2. Task Execution

**Thread Pool**

Thread pools in Java are implementations of the Executor interface or any of its sub-interfaces. 
Thread pools allow us to decouple task submission and execution.
 We have the option of exposing an executor's configuration while deploying an application 
 or switching one executor for another seamlessly.
 
A thread pool consists of homogenous worker threads that are assigned to execute tasks.
 Once a worker thread finishes a task, it is returned to the pool. 
 Usually, thread pools are bound to a queue from which tasks are dequeued for execution by worker threads. 
 
**Types of Thread Pools** 

Java has preconfigured thread pool implementations that can be instantiated using the factory methods of the Executors class. 
The important ones are listed below:

newFixedThreadPool: This type of pool has a fixed number of threads and any number of tasks can be submitted for execution. 
Once a thead finishes a task, it can reused to execute another task from the queue.

newSingleThreadExecutor: This executor uses a single worker thread to take tasks off of queue and execute them. 
If the thread dies unexpectedly, then the executor will replace it with a new one.

newCachedThreadPool: This pool will create new threads as required and use older ones when they become available.
However, it'll terminate threads that remain idle for a certain configurable period of time to conserve memory. 
This pool can be a good choice for short-lived asynchronous tasks.

newScheduledThreadPool: This pool can be used to execute tasks periodically or after a delay.