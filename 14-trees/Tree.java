public class Tree{
    
    public Node search(Node T, integer i){
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

    //Work in progress
    public void insert(Node T){
	Node n = new Node(i);
	if (T == null){
	    T = n;
	    return;
	}
    }
}
