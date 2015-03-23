import java.io.*;
import java.util.*;

public class LLit<E> implements Iterator<E>{
    private Node<E> t;
    private Node<E> complete;

    public LLit(Node<E> n){
	complete = n;
	t=n.getNext();
    }

    public boolean hasNext(){
	return t!=null;
    }

    public E next(){
	E retval = t.getData();
	t=t.getNext();
	return retval;
    }

    public void remove(){
	System.out.println("T: " + t);
	Node<E> c = complete;

	while (c.getNext() != null){
	    if (c.getNext().getNext() == t){
		c.setNext(c.getNext().getNext());
		break;
	    }
	    c = c.getNext();
	}
    }
}

