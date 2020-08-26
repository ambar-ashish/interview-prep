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

**StringBuffer methods**

StringBuffer sb = new StringBuffer("test");
sb.reverse();

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


**Character Methods**

char c = 'a';
Character.isLetterOrDigit(c)