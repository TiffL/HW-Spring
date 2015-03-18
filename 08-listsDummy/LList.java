public class LList{

    private Node l = new Node("Dummy");
    private int len = 0;

    public void add(String s){
	Node tmp = new Node(s);
	tmp.setNext(l.getNext());
	l.setNext(tmp);
	len += 1;
	//System.out.println("len: " + len);
    }

    public String toString(){
	String s = "";
	Node tmp;;
	for (tmp=l ; tmp!=null ; tmp=tmp.getNext()){
	    s = s + tmp + " --> ";
	}
	s = s + "null";
	return s;
    }

    //returns the value of the nth element of the linked list (n starts from 0)
    public Node get(int n){
	if (n >= -1 && n < len){
	    Node current = l;
	    for (int i = -1; i < n; i++){
		current = current.getNext();
	    }
	    return current;
	}
	return null;
    }

    //inserts string s at location n
    public void add(int n, String s){
	if (n >= 0 && n < len){
	    Node current = get(n-1);
	    Node next = current.getNext();
	    Node ins = new Node(s);
	    current.setNext(ins);
	    ins.setNext(next);
	    len += 1;
	    //System.out.println("len: " + len);
	}
    }

    public void remove(int n){
	if (n >= 0 && n < len){
	    Node current = get(n-1);
	    Node next = get(n).getNext();
	    current.setNext(next);
	    len -= 1;
	    //System.out.println("len: " + len);
	}
    }
}

