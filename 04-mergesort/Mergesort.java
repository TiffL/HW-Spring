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

    public int[] msort2(int[] L){
	if (L.length <= 1){
	    return L;
	}
	else{
	    int[] a = new int[L.length/2];
	    int ai = 0;
	    for (int i = 0; i < L.length / 2; i++){
		a[ai] = L[i];
		ai++;
	    }

	    int[] b = new int[L.length-a.length];
	    int bi = 0;
	    for (int i = L.length / 2; i < L.length; i++){
	        b[bi] = L[i];
		bi++;
	    }

	    return merge2(msort2(a),msort2(b));
	}
    }

    public int[] merge2(int[] a, int[] b){
	int[] output = new int[a.length + b.length];
	int iA = 0;
	int iB = 0;
	int current = 0;
	
	while (iA < a.length && iB < b.length){
	    if (a[iA] < b[iB]){
		output[current] = a[iA];
		iA++;
	    }
	    else{
		output[current] = b[iB];
		iB++;
	    }
	    current++;
	}
	while (iA < a.length){
	    output[current] = a[iA];
	    iA++;
	    current++;
	}
	while (iB < b.length){
	    output[current] = b[iB];
	    iB++;
	    current++;
	}
	return output;
    }

    public String toString(int[] a){
	String s = "";
	for (int i = 0; i < a.length; i++) {
	    s = s + a[i] + ", ";
	}
	return "[" + s.substring(0,s.length()-2) + "]";
    }

    public static void main(String args[]) {
	Mergesort m = new Mergesort();
    
	System.out.println("----ARRAYLISTS----");
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
	
	System.out.println("\n\n----ARRAYS----");
	int[] c = {4,2,1,5};
	int[] d = {8,1,9,1};
	System.out.println("\n" + m.toString(m.merge2(c,d)));

	int[] n2 = {4,12,4,7,2,1,13};
	System.out.println("Original unsorted: " + m.toString(n2));
	System.out.println("Sorted: " + m.toString(m.msort2(n2)));
    }
}
