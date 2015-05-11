public class Trees{

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

     public static void main(String[] args){
	 Trees t = new Trees();
	 Node n = new Node(2);
	 n.setRight(new Node(3));
	 n.setLeft(new Node(5));
	 System.out.println(t.maxValue(n));
     }
}
