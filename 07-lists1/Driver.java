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
	System.out.println(l.find(0));

	System.out.println("\nFinding 4th item: ");
	System.out.println(l.find(4));

	System.out.println("\nInserting 'a' at index 0: ");
        l.insert(0,"a");
	System.out.println(l);

	System.out.println("\nInserting 'b' at index 1: ");
        l.insert(1,"b");
	System.out.println(l);
	
    }
}
