package com.collections.sets;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/* A. With Simple String : 
 * Demo for HashSet, LinkedHashSet & TreeSet. All extends Set, so unique elelments only allowed.
 * HashSet elements are      : Unsorted and Order of insertion is not maintained. It uses hashing mechanism.
 * LinkedHashSet elements are: Unsorted, but maintains insertion order.
 * TreeSet                   : Sorted.
 * 
 * B. With a Student class (Check with and without implementing Comparable)
 * HashSet & LinkedHashSet insertion works fine. HashSet without any sorting, and LinkedHashSet maintining the insertion order. 
 * But TreeSet raises error saying class should be Comparable. 2 ways to solve this :
 * i .Make Student as  Comparable - All insertion worked fine and with TreeSet it came Sorted depending on the compareto() implemented. 
 * ii.Make a Comparator class StudentComparator and pass an instance while creating the TreeSet. TreeSet also takes a Comparator in its constructor. - 
 */
class Student { //implements Comparable<Student>{
	String name;
	int rollNo;
	public Student(String name, int no) {
		this.name = name;
		this.rollNo = no;		
	}
	@Override
	public String toString() {
		return "[" + name + ", " + rollNo + "] ";
	}
	
//	@Override
//	public int compareTo(Student o) {
//		return name.compareTo(o.name);
//	}
}

//Comparator class to be used with the constructor of TreeSet
class StudentComparator implements Comparator<Student>{
     @Override
     	public int compare(Student o1, Student o2) {
     		return o1.name.compareTo(o2.name);
     	}	
}

public class SetDemo {
	
	//This will raise Runtime error - StringBuilder cannot be cast to java.lang.Comparable
	public static void  testTreeSet(){
		Set tset = new TreeSet<>();
		tset.add("D");
		tset.add("C");
		tset.add(new StringBuilder("A"));
		tset.add(new StringBuilder("N"));
	}
	
	public static Set<Student> populateObj(Set<Student> set){
		set.add(new Student("cat", 101));
		set.add(new Student("dog", 101));
		set.add(new Student("rat", 101));
		set.add(new Student("dog", 101));
		set.add(new Student("bat", 101));
		
		return set;	
	}
	
    public static Set populate(Set<String> set){
		set.add("cat");
		set.add("dog");
		set.add("rat");
		set.add("dog");   //Note this is duplicate
		set.add("bat");
    	return set;
    }
    
	public static void TestSets(){
		Set<String> hset = populate(new HashSet<String>());		
		System.out.println("HashSet values : " + hset.toString());  //Output : [rat, bat, cat, dog]
	    
		//We cannot find value by index. Have to iterate to get the value.
		Iterator<String> itr = hset.iterator();
		while (itr.hasNext()){			
			System.out.println(itr.next());
		}
		
		Set<String> lhset = populate(new LinkedHashSet<>());
		System.out.println("LinkedHashSet values : " + lhset.toString()); //Output : [cat, dog, rat, bat]
		
		//TreeSet is extedned from SortedSet & NavigableSet.
		Set<String> tset = populate(new TreeSet<>());  //Note, we can also supply a Comparator class
		System.out.println("TreeSet values : " + tset.toString()); //Output : [bat, cat, dog, rat]
		
		String firstStr = ((TreeSet<String>) tset).first();
		String endStr = ((TreeSet<String>) tset).last();
		
		//String s = (String) tset.floor("dog");
		//System.out.println("Floog=r string : " + s);
		
		//testTreeSet();   //To test whether it raises error.		
	}
    public static void TestSetsWithObjects(){
		Set<Student> hset = populateObj(new HashSet<Student>());		
		System.out.println("HashSet values : " + hset.toString());  //Output : [rat, bat, cat, dog]
	    
		//We cannot find value by index. Have to iterate to get the value.
		Iterator<Student> itr = hset.iterator();
		while (itr.hasNext()){			
			System.out.println(itr.next());
		}
		
		Set<Student> lhset = populateObj(new LinkedHashSet<>());
		System.out.println("LinkedHashSet values : " + lhset.toString()); //Output : [cat, dog, rat, bat]
		
		//TreeSet is extedned from SortedSet & NavigableSet. We can also pass a Comparator to TreeSet while creating.
		//Set<Student> tset = populateObj(new TreeSet<>());        //Uncomment this when you uncomment the Comparable part in Studetn.
		Set<Student> tset = populateObj(new TreeSet<>(new StudentComparator()));
		System.out.println("TreeSet values : " + tset.toString()); //Output : [bat, cat, dog, rat]
    }
    
    public static void main(String[] args) {
    	//testTreeSet();
    	//TestSets();
    	TestSetsWithObjects();
	}

}
