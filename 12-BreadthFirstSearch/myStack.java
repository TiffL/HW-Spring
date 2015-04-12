public class myStack{
    private Node p;

    public myStack(){
	p = null;
    }

    public void push(int x, int y, Node previous){
        // add something to the top
	Node p1 = new Node(x,y);
	p1.setPrevious(previous);
	p1.setNext(p);
	p = p1;
    }

    public Node pop(){
        // remove and return the top item from the stack
	Node p1 = p;
	p = p.getNext();
	return p1;
    }

    public boolean empty(){
	return p == null;
    }

    public Node top() {
        // return the top item from the stack
	return p;
    }

    public String toString(){
	String s = "";
	Node tmp;
	for (tmp=p ; tmp!=null ; tmp=tmp.getNext()){
	    s = s + tmp + " --> ";
	}
	s = s + "null";
	return s;
    }
}
