public class myStack<E>{
    private Node<E> p;

    public myStack(){
	p = null;
    }

    public void push(E data){
        // add something to the top
	Node<E> p1 = new Node<E>(data);
	p1.setNext(p);
	p = p1;
    }

    public E pop(){
        // remove and return the top item from the stack
	Node<E> p1 = p;
	p = p.getNext();
	return p1.getData();
    }

    public boolean empty(){
	return p == null;
    }

    public E top() {
        // return the top item from the stack
	return p.getData();
    }

    public String toString(){
	String s = "";
	Node<E> tmp;;
	for (tmp=p ; tmp!=null ; tmp=tmp.getNext()){
	    s = s + tmp + " --> ";
	}
	s = s + "null";
	return s;
    }

    public static void main(String[] args){
	myStack<String> s = new myStack<String>();
	s.push("Hello");
	s.push("Yes");
	s.push("ie");
	System.out.println("Original:\n" + s);
	System.out.println("\nTop: " + s.top());
	System.out.println(s);
	System.out.println("\nPop: " + s.pop());
	System.out.println(s);
    }
}
