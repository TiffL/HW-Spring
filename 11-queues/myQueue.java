import java.io.*;
import java.util.*;
public class MyQueue<E>{
    Node<E> n,first,last;
    public MyQueue(){
	n = new Node<E>();
	first = n;
    }
    public void enqueue(E data){
	Node<E> tmp= new Node<E>(data);
	n.setNext(tmp);
	last=tmp;
    }
    public void dequeue(E data){
    }
    
    public String toString(){
	String s = "";
	Node<E> tmp;;
	for (tmp=n ; tmp!=null ; tmp=tmp.getNext()){
	    s = s + tmp + " --> ";
	}
	return s;
    }
}
