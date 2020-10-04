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

Equals method is used to compare teo objects. Two object references are equal only if there are pointing to the same object.
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

Hashing - transformation of a string of characters to a short fixed length value which can be used for faster indexing and searches.
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
1. Separate Chaining - When 2 or more records hash to the same location, then records are constituted into a
   single linked list called a chain.
2. Open Addressing -
    a. Linear probing
    b. Quadratic Probing
    c. Double Hashing   

**Java 8 features**


**Ways of creating Singleton Design pattern class**



 