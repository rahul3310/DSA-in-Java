import java.util.*;

public class CollectionFramework {
    /**
     * The Collection framework represents a unified architecture for storing and manipulating a group of objects. It has:
     * 1.Interfaces and its implementations, i.e., classes
     * 2.Algorithm
     * Array and ArrayList both can store null values.
     * ArrayList is not synchronized. || Vector is synchronized.
     * ArrayList increments 50%  of current array size if the number of elements exceeds from its capacity.
     * Vector increments 100% means doubles the array size if the total number of elements exceeds than its capacity
     * ArrayList is better to access data whereas LinkedList is better to manipulate data.
     **/

    public void printArrayList(){
        ArrayList<String> list=new ArrayList<String>();//Creating arraylist
        list.add("Mango");//Adding object in arraylist
        list.add("Apple");
        list.add("Banana");
        list.add("Grapes");
        //Printing the arraylist object
        System.out.println("ArrayList "+list);
    }

    public void printLinkedList() {
        LinkedList<String> linkedList=new LinkedList<String>();
        linkedList.add("Ravi");
        linkedList.add("Vijay");
        linkedList.add("Ravi");
        linkedList.add("Ajay");
        System.out.println("LinkedList "+linkedList);
    }
    //Sets Interface Java Collections

    /**
     * HashSet stores the elements by using a mechanism called hashing.
     * HashSet contains unique elements only.
     * HashSet allows null value.
     * HashSet class is non synchronized.
     * HashSet doesn't maintain the insertion order. Here, elements are inserted on the basis of their hashcode.
     * A list can contain duplicate elements whereas Set contains unique elements only.
     * The initial default capacity of HashSet is 16, and the load factor is 0.75.
     * The "load factor" in a HashSet refers to the ratio of the number of elements in the set to the number of buckets in the hash table.
     */

    public void printHashSet() {
        HashSet<String> set = new HashSet<>();
        set.add("One");
        set.add("Two");
        // set.add("Two"); by added Same value it does not store it does not print "Two" two times only once.
        set.add("Three");
        set.add("Four");
        set.add("Five");
        set.remove("Five");
        set.add("Six");

        System.out.println("HashSet " + set);
    }

    //LinkedHashSet in java collection->

    /**
     * Java LinkedHashSet class contains unique elements only like HashSet.
     * Java LinkedHashSet class provides all optional set operations and permits null elements.
     * Java LinkedHashSet class is non-synchronized.
     * Java LinkedHashSet class maintains insertion order.
     */

    public void printLinkedHashSet() {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("One");
        linkedHashSet.add("Two");
        linkedHashSet.add("Three");
        linkedHashSet.add("Four");
        linkedHashSet.add("Five");

        System.out.println("LinkedHashSet " + linkedHashSet);

    }

    //TreeSet in java collection->
    /**
     * Java TreeSet class contains unique elements only like HashSet.
     * Java TreeSet class access and retrieval times are quiet fast.
     * Java TreeSet class doesn't allow null element.
     * Java TreeSet class is non synchronized.
     * Java TreeSet class maintains ascending order.
     * */

    public void printTreeSet(){
        TreeSet<String> treeSet=new TreeSet<String>();
        treeSet.add("One");
        treeSet.add("Two");
        treeSet.add("Three");
        treeSet.add("Three");
        treeSet.add("Four");
        treeSet.add("Five");
        treeSet.add("Two");
        System.out.println("TreeSet "+treeSet);
    }

    //Queues and Priority Queues-->
    /**
     * As discussed earlier, FIFO concept is used for insertion and deletion of elements from a queue.
     * The Java Queue provides support for all the methods of the Collection interface including deletion, insertion, etc.
     * PriorityQueue, ArrayBlockingQueue and LinkedList are the implementations that are used most frequently.
     * The NullPointerException is raised, if any null operation is done on the BlockingQueues.
     * Those Queues that are present in the util package are known as Unbounded Queues.
     * Those Queues that are present in the "util.concurrent" package are known as bounded Queues.
     * All Queues barring the "Deques" facilitates removal and insertion at the head and tail of the queue; respectively.
     * In fact, "deques" support element insertion and removal at both ends.
     * PriorityQueue is also class that is defined in the collection framework that gives us a way for processing the objects on the basis of priority.
     * It is already described that the insertion and deletion of objects follows FIFO pattern in the Java queue.
     * However, sometimes the elements of the queue are needed to be processed according to the priority,
     * that's where a PriorityQueue comes into action.
     */
    public void printPriorityQueue(){
        PriorityQueue<String> queue=new PriorityQueue<String>();
        queue.add("Amit");
        queue.add("Vijay");
        queue.add("Karan");
        queue.add("Jai");
        queue.add("Rahul");
        System.out.println("Priority Queues "+queue);
        System.out.println("Priority Queues head:"+queue.element());
        System.out.println("Priority Queues head:"+queue.peek());
    }

    //Deque & ArrayDeque
    /**
     * The Deque supports the addition as well as the removal of elements from both ends of the data structure.
     * The deque can be used as a stack or a queue. We know that the stack supports the Last In First Out (LIFO) operation,
     * and the operation First In First Out is supported by a queue. As a deque supports both,
     * either of the mentioned operations can be performed on it. Deque is an acronym for "double ended queue".
     * Unlike Queue, we can add or remove elements from both sides.
     * Null elements are not allowed in the ArrayDeque.
     * ArrayDeque is not thread safe, in the absence of external synchronization.
     * ArrayDeque has no capacity restrictions.
     * ArrayDeque is faster than LinkedList and Stack.
      */

    public void printDeque(){
        Deque<String> deque=new ArrayDeque<String>();
        deque.offer("arvind");
        deque.offer("vimal");
        deque.add("mukul");
        deque.offerFirst("jai");
        System.out.println("After offerFirst Traversal... " + deque);
        //deque.poll();
        //deque.pollFirst();//it is same as poll()
        deque.pollLast();
        System.out.println("After pollLast() Traversal. "+deque);
    }

    //Java Map Interface
    /**
     * Map and sortedMap are two interfaces inplemented by Hashmap , linkedHashmap,treemap
     * A Map is useful if you have to search, update or delete elements on the basis of a key.
     * A Map doesn't allow duplicate keys, but you can have duplicate values. HashMap and LinkedHashMap allow null keys and values,
     * but TreeMap doesn't allow any null key or value.
     * "HashMap" is the implementation of Map, but it doesn't maintain any order.
     * "LinkedHashMap" is the implementation of Map. It inherits HashMap class. It maintains insertion order.
     * "TreeMap" is the implementation of Map and SortedMap. It maintains ascending order.
     * Java HashMap contains values based on the key.
     * Java HashMap contains only unique keys.
     * Java HashMap may have "one null key and multiple null values".
     * Java HashMap is non synchronized.
     * Java HashMap maintains no order.
     * The initial default capacity of Java HashMap class is 16 with a load factor of 0.75.
     */

    public void printHashMap(){
        HashMap<Integer,String> map= new HashMap<>();
        //Adding elements to map
        map.put(1,"Amit");
        map.put(5,"Rahul");
        map.put(2,"Jai");
        map.put(6,"Amit");
        System.out.println("HashMap "+map);
    }

    //Vector in Java
    /**
     * Vector is like the dynamic array which can grow or shrink its size.
     * It is recommended to use the Vector class in the thread-safe implementation only.
     * If you don't need to use the thread-safe implementation, you should use the ArrayList, the ArrayList will perform better in such case.
     */

    public void printVector(){
        Vector<String> v = new Vector<>();
        v.add("Rahul");
        v.add("Rohit");
        v.add("Mohit");
        v.add("Ravi");
        v.addElement("Sachin");
        v.addElement("Sahil");

        System.out.println("Vector "+v);
    }

    //Stack in Java
    /**
     * The stack is a linear data structure that is used to store the collection of objects.
     * It is based on Last-In-First-Out (LIFO). Java collection framework provides many interfaces and classes to store the collection of objects.
     * One of them is the Stack class that provides different operations such as push, pop, search, etc.
     */

    public void printStack(){
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println("Stack "+stack);

        stack.pop();
        System.out.println("After pop "+stack);
    }
}
