import java.io.*;
import java.util.*;
public class LList{

    private Node l = new Node(-1);
    private int len = 0;

    public int size(){
	return len;
    }

    public void add(int s){
	Node tmp = new Node(s);
	tmp.setNext(l.getNext());
	l.setNext(tmp);
	len += 1;
    }

    public String toString(){
	String s = "";
	Node tmp;;
	for (tmp = l; tmp != null; tmp = tmp.getNext()){
	    s = s + tmp + " --> ";
	}
	s = s + "null";
	return s;
    }

    //returns the value of the nth element of the linked list (n starts from 0)
    public int get(int n){
	if (n < -1 || n >= len){
	    throw new NoSuchElementException();
	}
	Node current = l;
	for (int i = -1; i < n; i++){
	    current = current.getNext();
	}
	return current.getData();
    }

    //inserts string s at location n
    public void add(int n, int s){
	if (n < 0 || n > len){
	    throw new NoSuchElementException();
	}
	Node c = l;
	for (int i = 0; i < n; i++){
	    c = c.getNext();
	}
	Node next = c.getNext();
	Node newN = new Node(s);
	c.setNext(newN);
	newN.setNext(next);	
	len += 1;
    }

    /*
    public int remove(int n){
	if (n < 0 || n > len){
	    throw new NoSuchElementException();
	}
	Node c = l;
	for (int i = 0; i < n; i++){
	    c = c.getNext();
	}
	Node next = c.getNext();
	c.setNext(c.getNext().getNext());
	len -= 1;
	return next.getData();
    }
    */

    public boolean remove(int i){
	if (i < 0 || i > len){
	    throw new NoSuchElementException();
	}
	Node c = l;
	c = c.getNext();

	for (int j = 0; j < len; j++){
	    if (c.getNext().getData() == i){
	        c.setNext(c.getNext().getNext());
		len -= 1;
		return true;
	    }
	    c = c.getNext();
	}
	return false;
    }
}

