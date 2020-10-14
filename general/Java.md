# Java Interview Questions and Answers

Total 3 classloaders:
1. System Classloader - Loads all classes from CLASSPATH
2. Extension Classloader - Loads all classes from extension directory
3. Bootstrap Classloader - loads all the Java Core files

Wrapper Classes - gives an appearance of objects, these classes have utility methods
Primitive types are not supported by Collections framework.

int x = (int)35.35 //Explicit Casting

**Understand String pool, Heap memory, Buffer vs Builder**

Strings are immutable, value of String object once created can not be modified.
Any modification creates a new object.

-->Approach 1
String str = "test";//String literal
This value is stored in String constant pool which is inside the heap memory.If compiler finds a string literal,
it checks if it exists in the pool, if its exists then it is reused.

-->Approach 2
When new operator is used to create string object, the new object is created on the heap.
There will not be any reuse of values.

String str = new String("test");

"+" used with Strings creates a new object.

Difference between String and StringBuffer:
1. StringBuffer values are immutable.
2. StringBuffer is thread safe.
3. StringBuffer is implemented by using synchronized keyword on all methods.

StringBuilder is not thread-safe. But performance is better than StringBuffer.

**Java Class**

Class is a template and the instance variables are state and methods are behaviors.

**Equals and HashCode**

Equals method is used to compare two objects. Two object references are equal only if there are pointing to the same object.
If we need to compare 2 objects, we need to override equals and hashcode method in the class.

HashCode are used in hashing to decide which group(Collection like HashMap) an object should be placed into.
A group of objects might share the same hashcode.

**Final**

Final class can not be extended from. String class in Java is a Final class.
Final methods can not be overridden.
Final variables once initialized, then the value cant be changed.

**Static**

Static variables and methods are class level variables and methods.
There will be only copy of static variable for the entire class. Each instance will not have a unique copy of static variable.

**Garbage Collection**

Aim of GC is to keep as much as Heap memory free for program as possible.
JVM removes objects on the heap which no longer have references from the heap.

**Collections**

CopyOnWriteArrayList, CopyOnWriteArraySet - Thread safe

**Working of HashMap**

Hashing - transformation of a string of characters to a short fixed length value which can be used for faster indexing
and searches.
HashMap is an array of nodes.
Node<K,V>
- int hash
- k Key
- v value
- Node<K,V> next

Each Node itself is a linkedlist.
HashMap put(){
    hash(k);
    index = hash % (n-1) where n is the size of the hashmap(default size 16)
}

Collision Resolution Techniques:
1. Separate Chaining - When 2 or more records hash to the same location, then records are added into a
   single linked list called a chain.
2. Open Addressing -
    a. Linear probing
    b. Quadratic Probing
    c. Double Hashing   

**Java 8 features**


**Ways of creating Singleton Design pattern class**

// File Name: Singleton.java
public class Singleton {

   private static Singleton singleton = new Singleton( );

   /* A private Constructor prevents any other
    * class from instantiating.
    */
   private Singleton() { }

   /* Static 'instance' method */
   public static Singleton getInstance( ) {
      return singleton;
   }

   /* Other methods protected by singleton-ness */
   protected static void demoMethod( ) {
      System.out.println("demoMethod for singleton");
   }
}

public class ClassicSingleton {

   private static ClassicSingleton instance = null;
   private ClassicSingleton() {
      // Exists only to defeat instantiation.
   }

   public static ClassicSingleton getInstance() {
      if(instance == null) {
         instance = new ClassicSingleton();
      }
      return instance;
   }
}

**ConcurrentHashMap**

ConcurrentHashMap: It allows concurrent access to the map. 
Part of the map called Segment (internal data structure) is only getting locked while adding or updating the map. 
So ConcurrentHashMap allows concurrent threads to read the value without locking at all. 
This data structure was introduced to improve performance.

A ConcurrentHashMap has internal final class called Segment so we can say that 
ConcurrentHashMap is internally divided in segments of size 32, 
so at max 32 threads can work at a time. It means each thread can work on a each segment during high concurrency 
and atmost 32 threads can operate at max which simply maintains 32 locks to guard each bucket of the ConcurrentHashMap.

**Null as Argument**

public class Test {
	public static void main(String[] args) {
		foo(null);
	}
	public static void foo(Object o) {
		System.out.println("Object argument");
	}
	public static void foo(String s) {
		System.out.println("String argument");
	}
}

Explanation of Null Argument Tricky Question

According to Java specs, in case of overloading, the compiler picks the most specific function. 
Obviously String class is more specific than Object class, hence it will print “String argument”.

public static void foo(StringBuffer i){
	System.out.println("StringBuffer impl");
}

In this case, the Java compiler will throw an error as “The method foo(String) is ambiguous for the type Test”.

**Long L**

long longWithL = 1000*60*60*24*365L;
long longWithoutL = 1000*60*60*24*365;
System.out.println(longWithL);
System.out.println(longWithoutL);

the output of the code snippet will be:

31536000000
1471228928
We are explicitly creating the first variable as long by adding an “L” suffix. So the compiler 
will treat it as long and assign it to the first variable.

For the second statement, the compiler will perform the calculation and treat it as a 32-bit integer. 
Since the output is outside the range of integer max value (2147483647), 
the compiler will truncate the most significant bits and then assign it to the variable.

**Can you override a private or static method in Java?**

Another popular Java tricky question, As I said method overriding is a good topic to ask trick questions in Java.
Anyway, you can not override a private or static method in Java.

**No, you can not access a non-static variable from the static context in Java. 
If you try, it will give compile time error.**

**Integer**

public class Demo{ 
    public static void main(String[] arr){ 
        Integer num1 = 100; 
        Integer num2 = 100; 
        Integer num3 = 500; 
        Integer num4 = 500; 
          
        if(num1==num2){ 
            System.out.println("num1 == num2"); 
        } 
        else{ 
            System.out.println("num1 != num2"); 
        } 
        if(num3 == num4){ 
            System.out.println("num3 == num4"); 
        } 
        else{ 
            System.out.println("num3 != num4"); 
        } 
    } 
} 

Answer: b)num1 == num2
                  num3 != num4
Reason: We always thought that whenever two object references are compared using “==”, it always evaluates to “false”.
 But here Integer caching changes the results.Integer class has a caching range of -128 to 127. 
 Whenever a number is between this range and autoboxing is used, it assigns the same reference. 
 That’s why for value 100, both num1 and num2 will have the same reference, 
 but for the value 500 (not in the range of -128 to 127), num3 and num4 will have different reference.






 