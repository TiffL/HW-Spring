import java.io.*;
import java.util.*;
public class Trees{
    Node r;

    public Trees(Node n){
	r = n;
    }

    public void insert(int i){
	Node n = new Node(i);
	Node t2=null;
	Node t = r;
	if (r==null){
	    r=n;
	    return;
	}
								
	while (t!=null){
	    t2 = t;
	    //if (t.getData()==i)
	    //	return;
	    if (t.getData() < i)
		t=t.getRight();
	    else if (t.getData() >= i)
		t=t.getLeft();
	    else
		return;
	}
		
	if (i>t2.getData())
	    t2.setRight(n);
	else
	    t2.setLeft(n);
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

 
    public int maxValue(Node t){
	int maxi=t.getData();

	if (t.getLeft() != null){
	    int m = maxValue(t.getLeft());
	    if (m > maxi){
		maxi = m;
	    }
	}
	if (t.getRight() != null){
	    int n = maxValue(t.getRight());
	    if (n > maxi){
		maxi = n;
	    }
	}
	
	return maxi;
    }
  
    public int height(Node t){
	if (t == null){
	    return 0;
	}
	int longest = 1;
	int l = 0;
	if (t.getRight() != null){
	    l = 1 + height(t.getRight());
	    //System.out.println("RightL: "+l + "    Data: "+t.getRight().getData());
	    if (l > longest){
		longest = l;
	    }
	}
	if (t.getLeft() != null){
	    l = 1 + height(t.getLeft());
	    //System.out.println("LeftL: "+l + "    Data: "+t.getLeft().getData());
	    if (l > longest){
		longest = l;
	    }
	}
	return longest;
    }

    //splitDupes under construction
    public void splitDupes(Node t){
	if (t.getRight() != null){
	    if (t.getRight().getData() == t.getData()){
		Node temp = t.getRight();
		t.setRight(new Node(t.getData()-1));
		t.getRight().setRight(temp);
	    }
	}
	if (t.getLeft() != null){
	    if (t.getLeft().getData() == t.getData()){
		Node temp = t.getLeft();
		t.setLeft(new Node(t.getData()-1));
		t.getLeft().setLeft(temp);
	    }
	}
	if (t.getRight() != null){
	    splitDupes(t.getRight());
	}
	else if (t.getLeft() != null){
	    splitDupes(t.getLeft());
	}
    }

    public int longest(Node t){
	int l = 0;
	if (t.getLeft() != null && t.getRight() != null){
	    int n = height(t.getLeft())+height(t.getRight());
	    if (n > l){
		l = n;
	    }
	}
	return l;
    }

    public static void main(String[] args){
	Node n = new Node(10);
	Trees t = new Trees(n);
	t.insert(20);
	t.insert(40);
	t.insert(5);
	t.insert(5);
	t.insert(6);
	t.insert(6);
	t.insert(12);
	t.insert(50);

	System.out.println(t);
	System.out.println("\nMaxVal: " + t.maxValue(n));
	System.out.println("\nHeight: " + t.height(n));
        t.splitDupes(n);
	//System.out.println(t);
	System.out.println("\nLongest: " + t.longest(n));
    }
}
