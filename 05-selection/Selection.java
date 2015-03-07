public class Selection{

    public int select(int[] A, int k, int l, int h){
	int[] D = new int[A.length];
	int j = l+1;
	int high = h;
	int low = l;

	for (int i = 0; i < l; i++){
	    D[i] = A[i];
	}
	for (int i = h+1; i < A.length; i++){
	    D[i] = A[i];
	}

	int pivot = A[l];

	while (l < h){
	    if (A[j] < pivot){
		D[l] = A[j];
		l++;
	    }
	    else{
		D[h] = A[j];
	        h--;
	    }
	    j++;
	}
	
	D[l] = pivot;

	if (k < l){
	    return select(D,k,low,l-1);
	}
	else if (k > l){
	    return select(D,k,l+1,high);
	}

	System.out.println("\nAfter divisions:\n" + toString(D));
	System.out.println("\nk is " + k + "\nThe kth smallest element is: ");
	return pivot;
    }

    public String toString(int[] a){
	String s = "";
	for (int i = 0; i < a.length; i++) {
	    s = s + a[i] + ", ";
	}
	return "[" + s.substring(0,s.length()-2) + "]";
    }

    public static void main(String[] args){
	Selection s = new Selection();
	int[] n = {10,2,5,1,16,44,70};
	System.out.println("\nOriginal: \n" + s.toString(n));
	System.out.println(s.select(n,6,0,6));	
    }

}
