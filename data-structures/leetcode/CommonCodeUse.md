#Common Code Use

**To remove all spaces**

String str = "test test1     test2";
str = str.replaceAll("\\s+","");

**Array to ArrayList**

List<Character> list = Arrays.asList('a','e','i','o','u');

**Replace all vowels**

public String removeVowels(String S) {
    return S.replaceAll("[aeiou]", "");
}

**Replace all letters except a-z and A-Z**

String normalizedStr = paragraph.replaceAll("[^a-zA-Z]", " ");

**Understand Prefix Sum**

**String methods**
String s = "TEST";
s = s.toLowerCase(); 

str1.compareTo(str2) - The method returns a negative number 
when the string calling the method lexicographically comes first.

So when you want a lexicographically ordered in priority queue(minHeap).
PriorityQueue<String> minHeap = new PriorityQueue<>((a,b) -> b.compareTo(a));

String reversedWord = new StringBuilder(word).reverse().toString();

**StringBuffer methods**

StringBuffer sb = new StringBuffer("test");
sb.reverse();

sb.insert(0,"A");//insert A at 0th position
sb.append("A")

**Comparators**

Increasing order
Arrays.sort(intervals, (o1, o2) -> o1 - o2);

Decreasing order
Arrays.sort(intervals, (o1, o2) -> o2 - o1);

For Strings:

**Priority Queues**

Max Heap:
PriorityQueue<Integer> pQueue =  new PriorityQueue<Integer>(Collections.reverseOrder());

For int array:
PriorityQueue<int[]> heap = new PriorityQueue<int[]>((o1,o2) -> o1[0] - o2[0]);

Time Complexity of inserting and deleting and element is O(log n)

**Character Methods**

char c = 'a';
Character.isLetterOrDigit(c)

**Return empty int array**

return new int[0];
return new int[0][0];

**Lists**

Collections.reverse(list);

**Array to List**

String a[] = new String[] { "A", "B", "C", "D" }; 
List<String> list = Arrays.asList(a); 
Or List<String> list = Arrays.asList("A","B");

**List to Array**

List<int[]> result = new ArrayList<>();
result.toArray(new int[result.size()][]);

**ASCII codes**

0-9 -> 48-57
A-Z -> 65-90
a-z -> 97-122

**HashMap**

iteration over HashMap keys
for(int i : map.keySet())

iteration over HashMap values
for(int i : map.keySet())
