public class Node{
    private Integer data;
    private Node left, right;
    
    public Node(Integer d){
	data = d;
	left = null;
	right = null;
    }
    
    public void setLeft(Node l){
	left = l;
    }
    public Node getLeft(){
	return left;
    }
    public void setRight(Node r){
	right = r;
    }
    public Node getRight(){
	return right;
    }
    public void setData(Integer d){
	data = d;
    }
    public Integer getData(){
	return data;
    }
}
