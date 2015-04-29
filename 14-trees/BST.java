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

    public String traverse(Node t){
	if (t == null){
	    return "";
	}
	else{
	    return traverse(t.getLeft())+
		t.getData()+", "+
		traverse(t.getRight());
	}
    }
    
    public String toString(){
	return traverse(r);
    }

    public static void main(String[] args){
	BST t = new BST();
	Node n = new Node(new Integer(1));
	t.insert(n,1);
	t.insert(n,2);
	t.insert(n,5);
	System.out.println(t);
    }
}
