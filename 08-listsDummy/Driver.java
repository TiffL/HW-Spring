import java.util.*;
import java.io.*;
public class Driver{
    public static void main(String[] args) {
	LList l = new LList();

	for (int i=0;i<5;i++){
	    l.add(i);
	}
	System.out.println(l);

	System.out.println("\nDummy Node is the first -1");
	
	System.out.println("\nFinding 0th item: ");
	System.out.println(l.get(0));

	System.out.println("\nFinding 4th item: ");
	System.out.println(l.get(4));

	System.out.println("\nInserting 1 at index 0: ");
        l.add(0,1);
	System.out.println(l);

	System.out.println("\nInserting 2 at index 1: ");
        l.add(1,2);
	System.out.println(l);
	
	System.out.println("\nRemoving first appearance of 2: ");
	System.out.println(l.remove(2));
	System.out.println(l);

	System.out.println("\nRemoving first appearance of 0: ");
	System.out.println(l.remove(0));
	System.out.println(l);

	//~~~~~~~~~~~~~~~~~~~~~~~ARRAYLIST~~~~~~~~~~~~~~~~~~~~~~~~

	System.out.println("\nArrayList:");

	ArrayList<Integer> s = new ArrayList<Integer>();
	Random rd = new Random();
	
	for (int i = 0; i < 5000000; i++){
	    s.add(rd.nextInt());
	}
        
	long start = System.currentTimeMillis();

	int sum = 0;
	for (int i=0;i<s.size(); i++){
	    sum = sum + s.get(i);
	}

	long elapsed = System.currentTimeMillis() - start;
	System.out.println(elapsed);

	//~~~~~~~~~~~~~~~~~~~~~~~LLIST~~~~~~~~~~~~~~~~~~~~~~~~

	System.out.println("\nLList:");

        LList x = new LList();
	
	for (int i = 0; i < 5000000; i++){
	    s.add(rd.nextInt());
	}
        
	start = System.currentTimeMillis();

	sum = 0;
	for (int i=0;i<s.size(); i++){
	    sum = sum + s.get(i);
	}

	elapsed = System.currentTimeMillis() - start;
	System.out.println(elapsed);

	//~~~~~~~~~~~~~~~~~~~~~~~LINKEDLIST~~~~~~~~~~~~~~~~~~~~~~~~

	System.out.println("\nLinkedList:");

        LinkedList y = new LinkedList();
	
	for (int i = 0; i < 5000000; i++){
	    s.add(rd.nextInt());
	}
        
	start = System.currentTimeMillis();

	sum = 0;
	for (int i=0;i<s.size(); i++){
	    sum = sum + s.get(i);
	}

	elapsed = System.currentTimeMillis() - start;
	System.out.println(elapsed);
	
    }
}
