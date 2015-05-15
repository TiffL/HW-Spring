import java.util.*;
public class Heap{
    private ArrayList<Integer> h; //minHeap
    private int hSize;

    public Heap(){
	h = new ArrayList<Integer>();
	hSize = 0;
    }

    public Heap(ArrayList<Integer> i){
	h = i;
	hSize = i.size();
    }

    public void insert(int i){
	h.add(i);
	siftUp(i);
    }

    public void siftUp(int i){ // i = element added
	int loc = h.size();
	while (loc > 1 && i < h.get(loc/2 - 1)){
	    //System.out.println(this);
	    h.set(loc-1,h.get(loc/2 - 1));
	    h.set(loc/2-1,i);
	    loc = loc/2;
	}
	hSize = h.size(); //for printing purposes
    }

    public void remove(int loc){
	h.set(loc,h.get(h.size()-1));
	pushDown(loc);
    }

    public void pushDown(int i){ // i = starting index
	int loc = i;
	int current;
	int lchild; // index of left child
	int rchild; // index of right child
	int child; // index of child to be swapped with
	while (loc < h.size()/2){
	    lchild = (loc+1) * 2 - 1;
	    rchild = (loc+1) * 2;
	    if (lchild <= rchild){
		child = lchild;
	    }
	    else{
		child = rchild;
	    }

	    if (h.get(loc) > h.get(child)){
		current = h.get(loc);
		h.set(loc, h.get(child));
		h.set(child, current);
	    }
	    loc = child;
	}
	hSize = h.size()-1; //printing purposes
    }
    
    public String toString(){
	String s = "[";
	for (int i = 0; i < hSize-1; i++){
	    s += h.get(i) + ", ";
	}
	s += h.get(hSize-1) + "]";
	return s;
    }
    
    public static void main(String[] args){
	Heap h = new Heap();
	h.insert(20);
	h.insert(1);
	h.insert(5);
	h.insert(10);
	h.insert(4);
	System.out.println(h);
	h.remove(0);
	//h.remove(2);
	System.out.println(h);
    }
}
