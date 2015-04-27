public class BST{
    private Node r = null;
    
    public Node search(Node t, int i){
	while (t != null){
	    int c = t.getData().compareTo(i);
	    if (c == 0){
		return t;
	    }
	    else if (c > 0){
		t = t.getRight();
	    }
	    else{
		t = t.getLeft();
	    }
	}
	return null;
    }

    public void insert(Node t, int i){
	Node n = new Node(i);
	if (t == null){
	    t = n;
	    return;
	}
	Node T2 = null;
	while (t != null){
	    T2 = t;
	    if (T2.getData().compareTo(i) > 0){
		t = T2.getLeft();
	    }
	    else{
		t = T2.getRight();
	    }
	}
	if (T2.getData().compareTo(i) > 0){
	    T2.setLeft(n);
	}
	else{
	    T2.setRight(n);
	}
    }

    //work in progress
    public String toString(Node n, char d, int level, String sp){
	String spaces = sp;
	if (n == null){
	    return null;
	}
	else if (d == 'l' && n.getLeft() == null){
	    return "" + n.getData();
	}
	else if (d == 'r' && n.getRight() == null){
	    return "" + n.getData();
	}
	else{
	    spaces += spaces;
	    String l,r;

	    l = spaces+" L"+level+": "+toString(n.getLeft(),'l',level+1,spaces);
	    r = "  R"+level+": "+toString(n.getRight(),'r',level+1,spaces)+"\n";
	    System.out.println(l+r);

	    return "" + n.getData();
	}
    }

    public static void main(String[] args){
	BST t = new BST();
	Node n = new Node(new Integer(1));
	t.insert(n,1);
	//t.toString(n,'r',0," ");
	t.insert(n,2);
	//t.toString(n,'r',0," ");
	t.insert(n,5);
        t.toString(n,'r',0," ");

    }
}
