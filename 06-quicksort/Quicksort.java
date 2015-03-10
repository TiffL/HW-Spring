import java.util.*;
import java.io.*;
public class Quicksort{
   
    /*
    private int[] a,b;
    Random rnd = new Random();
    public Qselect(){
	this(20);
    }
    public Qselect(int n){
	Random r = new Random();
	a = new int[n];
	for (int i = 0; i < a.length; i++) {
	    a[i] = r.nextInt(100);
	}
    }
    */

    public int partition(int[] a, int l, int r) {
	int tmp;
	int pivotIndex=l;
	int pivot = a[pivotIndex];
	tmp = a[r];
	a[r] = a[pivotIndex];
	a[pivotIndex]=tmp;
	int wall=l;
	int pcount=1;
	for (int i=l;i<r;i++) {
	    if (a[i]<pivot) {
		tmp = a[i];
		a[i]=a[wall];
		a[wall]=tmp;
		wall++;
	    }
	    if (a[i]==pivot)
		pcount++;
	}
	// now copy over all the pivots
	int rwall=wall;
	tmp = a[rwall];
	a[wall]=a[r];
	a[r]=tmp;
	rwall++;
	for (int i=rwall+1;i<=r;i++) {
	    if (a[i]==pivot) {
		tmp = a[rwall];
		a[rwall]=a[i];
		a[i]=tmp;
		rwall++;
	    }
	}
	return (wall+rwall)/2;
    }

    /*
    public int qselect(int[] a, int k, int l, int h){
	int pi,pval;
	pi = partition(a,l,h);
	pval = a[pi];
	if (k==pi)
	    return pval;
	else if (k > pi)
	    return qselect(a,k,pi+1,h);
	else
	    return qselect(a,k,l,pi-1);
    }
    public int select(int k){
	b = Arrays.copyOf(a,a.length);
	return qselect(b,k,0,b.length-1);
    }
    */

    public String qsort(int[] A, int l, int h){
	int pi;
 	if (l < h){
	    pi = partition(A,l,h);
	    qsort(A, l, pi-1);
	    qsort(A, pi+1, h);
	}
	return toString(A);
    }

    public String toString(int[] a){
	return Arrays.toString(a);
    }

    public static void main(String[] args) {
	Quicksort q = new Quicksort();
	int[] c = {14,2,13,1,3,5};
	System.out.println(Arrays.toString(c));
	System.out.println(q.qsort(c,0,5));
    }
}
