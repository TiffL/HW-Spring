public class Driver{
    public static void main(String[] args) {
	LList l = new LList();
	l.add("hello");
	l.add("world");
	for (int i=0;i<5;i++){
	    l.add(""+i);
	}
	System.out.println(l);
	
	System.out.println("\nFinding 0th item: ");
	System.out.println(l.get(0));

	System.out.println("\nFinding 4th item: ");
	System.out.println(l.get(4));

	System.out.println("\nInserting 'a' at index 0: ");
        l.add(0,"a");
	System.out.println(l);

	System.out.println("\nInserting 'b' at index 1: ");
        l.add(1,"b");
	System.out.println(l);
	
	System.out.println("\nRemoving item at index 2: ");
	l.remove(2);
	System.out.println(l);
    }
}
