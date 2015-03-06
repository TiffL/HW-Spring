public class Selection{

    public void divide(int[] L, int SI, int EI){
	int[] D = new int[L.length];
	int j = 1;

	for (int i = 0; i < SI; i++){
	    D[i] = L[i];
	}
	for (int i = EI+1; i < L.length; i++){
	    D[i] = L[i];
	}

	int pivot = L[SI];

	while (SI < EI){
	    if (L[j] < pivot){
		D[SI] = L[j];
		SI++;
	    }
	    else{
		D[EI] = L[j];
	        EI--;
	    }
	    j++;
	}
	
	D[SI] = pivot;
       	System.out.println(toString(D));
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
	System.out.println("\nDivided: ");
	s.divide(n,0,6);	
    }

}
