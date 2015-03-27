import java.io.*;
import java.util.*;
public class myQueue<E>{
    Node<E> n,first,last;
    
    public myQueue(){
	n = new Node<E>();
	first = n;
	last = n;
	first.setNext(last);
    }
    
    public void enqueue(E data){
	Node<E> tmp= new Node<E>(data);
        n.setNext(tmp);
	n = n.getNext();
	//System.out.println("Pointer: " + n);
	last = n.getNext();
	//System.out.println("F: " + first);
	//System.out.println("L: " + last);
    }
    
    public E dequeue(){
        E tmp = first.getNext().getData();
        first.setNext(first.getNext().getNext());
	return tmp;
    }

    public boolean empty(){
	return first.getNext()==null;
    }

    public E head(){
    }
    
    public String toString(){
	String s = "";
	Node<E> tmp;
	for (tmp=first ; tmp!=null ; tmp=tmp.getNext()){
	    s = s + tmp + " --> ";
	}
	return s + "null";
    }
}
