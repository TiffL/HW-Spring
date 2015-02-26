import java.util.*;

public class Mergesort {

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
	if (a.size() != 0){
	    for (int i = 0; i < a.size(); i++){
		output.add(a.remove(0));
	    }
	}
	else if (b.size() != 0){
	    for (int i = 0; i < b.size(); i++){
		output.add(b.remove(0));
	    }
	}
	return output;
    }

    public static void main(String args[]) {
	Mergesort m = new Mergesort();
	ArrayList<Integer> a = new ArrayList<Integer>();
	ArrayList<Integer> b = new ArrayList<Integer>();
	a.add(1);
	a.add(7);
	a.add(8);
	b.add(0);
	b.add(2);
	b.add(3);
	b.add(9);
	System.out.println("a: " + a);
	System.out.println("b: " + b + "\n");
	System.out.println(m.merge(a,b));
    }
}
