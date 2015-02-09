public class Recursion{

    public int factorial(int n){
	if (n == 0){
	    return 1;
	}
	else{
	    return n*factorial(n-1);
	}
    }

    public int fib(int n) {
	if (n == 0){
	    return 0;
	}
	else if (n == 1){
	    return 1;
	}
	else{
	    return fib(n-1) + fib(n-2);
	}
    }

    public int len(String s){
	if (s.equals("")){
	    return 0;
	}
	else{
	    return 1 + len(s.substring(1));
	}
    }

    public int count(String s, char c){
	if (s.length() == 0){
	    return 0;
	}
	else if (s.charAt(0) == c){
	    return 1 + count(s.substring(1),c);
	}
	else{
	    return count(s.substring(1),c);
	}
    }

    //~~~~CodingBat~~~~
    public int bunnyEars2(int bunnies) {
	if (bunnies == 0){
	    return 0;
	}
	else if (bunnies % 2 == 0){
	    return 3 + bunnyEars2(bunnies-1);
	}
	else{
	    return 2 + bunnyEars2(bunnies-1);
	}
    }

    public int strCount(String str, String sub) {
	if (str.length() == 0){
	    return 0;
	}
	else if (str.length() < sub.length()){
	    return 0;
	}
	else if ((str.substring(str.length()-sub.length()).equals(sub))){
	    return 1 + strCount(str.substring(0,str.length()-sub.length()),sub);
	}
	else{
	    return strCount(str.substring(0,str.length()-1),sub);
	}
    }

    public int sumDigits(int n) {
	if (n == 0){
	    return 0;
	}
	else{
	    return n%10 + sumDigits(n/10);
	}
    }

    public String allStar(String str) {
	if (str.length() == 0){
	    return "";
	}
	else if (str.length() == 1){
	    return str.substring(0);
	}
	else{
	    return str.substring(0,1) + "*" + allStar(str.substring(1));
	}
    }

    //~~~~Testing~~~~
    public static void main(String[] args){
	Recursion a = new Recursion();
	System.out.println("\nexpecting 6: \n" + a.factorial(3));
	System.out.println("\nexpecting 24: \n" + a.factorial(4));
	System.out.println("\nexpecting 7: \n" + a.len("NewYork"));
	System.out.println("\nexpecting 0: \n" + a.len(""));
	System.out.println("\nexpecting 1: \n" + a.count("City",'i'));
    }
}
