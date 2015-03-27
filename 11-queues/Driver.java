import java.util.*;
import java.io.*;
public class Driver{
    public static void main (String [] args){
	myQueue<Integer> mq= new myQueue<Integer>();

	System.out.println("\nEnqueue:");
	mq.enqueue(1);
	mq.enqueue(2);
	mq.enqueue(3);
	System.out.println(mq);

	System.out.println("\nDequeue:");
	mq.dequeue();
	System.out.println(mq);
	mq.dequeue();
	System.out.println(mq);

	System.out.println("\nEmpty? " + mq.empty());
	
	mq.dequeue();
	System.out.println("\n" + mq);
	
	System.out.println("\nEmpty? " + mq.empty());

    }
}
