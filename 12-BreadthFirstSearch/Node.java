public class Node{
    private int x, y;
    private Node next, previous;

    public Node(int x, int y){
	this.x = x;
	this.y = y;
	next = null;
	previous = null;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public void setNext(Node n){
	next = n;
    }

    public void setPrevious(Node n){
	previous = n;
    }

    public Node getNext(){
	return next;
    }

    public Node getPrevious(){
	return previous;
    }

    public String toString(){
	return "[" + x + "," + y + "]";
    }
}
