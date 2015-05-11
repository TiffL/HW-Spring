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

    public void insert(int i){
	Node n = new Node(i);
	Node t = r;
	if (r == null){
	    r = n;
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

    public void remove(int i){
	remove(r,i);
    }

    public void remove(Node s, int i){
	Node T = s;
	Node T2 = null;
	while (T.getData() != i){
	    T2 = T;
	    if (T2.getData().compareTo(i) > 0){
		T = T2.getLeft();
	    }
	    else{
		T = T2.getRight();
	    }
	}
	if (T2.getRight() == T){
	    if (T.getRight() == null){
		T2.setRight(T.getLeft());
	    }
	    else{
		T2.setRight(T.getRight());
	    }
	}
	else if (T2.getLeft() == T){
	    if (T.getLeft() == null){
		T2.setLeft(T.getRight());
	    }
	    else{
		T2.setLeft(T.getLeft());
	    }	    
	}
	else{
	    Node L = T.getLeft();
	    while (L.getRight() != null){
		L = L.getRight();
	    }
	    T.setData(L.getData());
	    remove(T.getLeft(),L.getData());
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
	t.insert(20);
	t.insert(10);
	t.insert(40);
	t.insert(7);
	t.insert(13);
	t.insert(17);
	System.out.println(t);
	t.remove(10);
	System.out.println(t);
    }
}
