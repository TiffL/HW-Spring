import java.io.*;
import java.util.*;
public class myQueue{
    Node first,last;
    
    public myQueue(){
	first = new Node(-1,-1); //dummy node
	last = first;
    }

    public void enqueue(int x, int y, Node previous){
	Node tmp = new Node(x,y);
	tmp.setPrevious(previous);
        last.setNext(tmp);
	last = tmp;
    }
    
    public Node dequeue(){
        Node tmp = first.getNext();
        first.setNext(first.getNext().getNext());
	if (empty()){
	    last = first;
	}
	return tmp;
    }

    public boolean empty(){
	return first.getNext()==null;
    }

    public String toString(){
	String s = "";
	Node tmp;
	for (tmp=first ; tmp!=null ; tmp=tmp.getNext()){
	    s = s + tmp + " --> ";
	}
	return s + "null";
    }
}
