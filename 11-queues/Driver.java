import java.util.*;
import java.io.*;
public class Driver{
    public static void main (String [] args){
	MyQueue<Integer> mq= new MyQueue<Integer>();
	mq.enqueue(1);
	System.out.println(mq);
    }
}
