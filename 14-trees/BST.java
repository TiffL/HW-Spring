public class Tree{
    private Node root = null;
    
    public Node search(Node T, Integer i){
	while (T != null){
	    int c = T.getData().compareTo(i);
	    if (c == 0){
		return T;
	    }
	    else if (c > 0){
		T = T.getRight();
	    }
	    else{
		T = T.getLeft();
	    }
	}
	return null;
    }

    public void insert(Node T, Integer i){
	Node n = new Node(i);
	if (T == null){
	    T = n;
	    return;
	}
	Node T2 = null;
	while (T != null){
	    T2 = T;
	    if (i.compareTo(T2.getData())<0){
		T = T2.getLeft();
	    }
	    else{
		T = T2.getRight();
	    }
	}
	if (i.compareTo(T2.getData()) < 0){
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
	Tree t = new Tree();
	Node n = new Node(new Integer(1));
	t.insert(n,1);
	//t.toString(n,'r',0," ");
	t.insert(n,2);
	//t.toString(n,'r',0," ");
	t.insert(n,5);
        t.toString(n,'r',0," ");

    }
}
