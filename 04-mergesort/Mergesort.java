import java.util.*;
public class Mergesort {

    public ArrayList<Integer> msort(ArrayList<Integer> L){
	ArrayList<Integer> a = new ArrayList<Integer>();
	ArrayList<Integer> b = new ArrayList<Integer>();
	
	if (L.size() == 1){
	    return L;
	}
	else{
	    for (int i = 0; i < L.size() / 2; i++){
		a.add(L.get(i));
	    }
	    for (int i = L.size() / 2; i < L.size(); i++){
		b.add(L.get(i));
	    }
	}
	return merge(msort(a),msort(b));
    }
	    
    public ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){
	ArrayList<Integer> output = new ArrayList<Integer>();
	while (a.size() > 0 && b.size() > 0){
	    if (a.get(0) < b.get(0)){
		output.add(a.remove(0));
	    }
	    else {
		output.add(b.remove(0));
	    }
	}
	while (a.size() > 0){
	    output.add(a.remove(0));
	}
	while (b.size() > 0){
	    output.add(b.remove(0));
	}
	return output;
    }

    public static void main(String args[]) {
	Mergesort m = new Mergesort();
	System.out.println("\n~Merge~");
	ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(1,7,8));
	ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(0,2,3,9));
	System.out.println("a: " + a);
	System.out.println("b: " + b + "\n");
	System.out.println(m.merge(a,b));

	System.out.println("\n~MergeSort~");
	ArrayList<Integer> n = new ArrayList<Integer>(Arrays.asList(4,5,2,1,9,23,21,21));
	System.out.println("Original unsorted: " + n);
	System.out.println("Sorted: " + m.msort(n));
    }
}
