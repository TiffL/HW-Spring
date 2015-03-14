public class LList{

    private Node l=null;

    public void add(String s){
	Node tmp = new Node(s);
	tmp.setNext(l);
	l = tmp;
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
    public Node find(int n){
	Node current = l;
	for (int i = 0; i < n; i++){
	    current = current.getNext();
	}
	return current;
    }

    //inserts string s at location n
    public void insert(int n, String s){
	if (n == 0){
	    add(s);
	}
	else{
	    Node current = find(n-1);
	    Node temp = current.getNext();
	    Node ins = new Node(s);
	    current.setNext(ins);
	    ins.setNext(temp);
	}
    }

}
