import java.io.*;
import java.util.*;

public class Maze {
    private char[][] board;
    private int maxX;
    private int maxY;

    private char path='#';
    private char wall=' ';
    private char me='z';
    private char exit='$';
    private char visited = '.';
    private boolean solved = false;

    private Frontier f;
    private Node e;
    private Node start;
		
    public void delay(int n){
	try {
	    Thread.sleep(n);
	} catch (Exception e) {}
    }
		
    public Maze(){
	maxX=40;
	maxY=20;
	board = new char[maxX][maxY];
				
	try {					
	    Scanner sc = new Scanner(new File("maze.dat"));
	    int j=0;
	    while (sc.hasNext()){
		String line = sc.nextLine();
		for (int i=0;i<maxX;i++){
		    board[i][j] = line.charAt(i);
		}
		j++;
	    }
	}
	catch (Exception e){}				
    }
		
    public String toString(){
	String s = "[2J\n";
				
	for (int y=0;y<maxY;y++){
	    for (int x=0;x<maxX;x++)
		s = s +board[x][y];
	    s=s+"\n";
	}
	return s;
    }

    /*
      solved - instance variable to indicate we're done
			
    */
    public void solve(int x, int y){
	if (board[x][y]==wall ||
	    board[x][y]==me ||
	    board[x][y]==visited ||
	    solved){
	    return;
	}

	if (board[x][y]==exit){
	    System.out.println(this);
	    solved = true;
	}
	delay(100);
	System.out.println(this);
	board[x][y]=me;
	solve(x+1,y);
	solve(x-1,y);
	solve(x,y+1);
	solve(x,y-1);
	if (!solved){
	    board[x][y]=visited;
	}
    }

    /*
      Only adds if the tx,ty spot is available path or exit
    */
    public void addToFront(int tx,int ty, Node current, char type){
	Node tmp = null;
	if (board[tx][ty]=='#' || board[tx][ty]=='$'){
	    tmp = new Node(tx,ty);

	    if (type == 'b'){
		tmp.setPriority(EuDist(tmp));
		//tmp.setPriority(TaxiDist(tmp));
	    }

	    else if (type == 'a'){
		//~~~ A* ~~~
		tmp.setPriority(TaxiDist(tmp) + current.getSteps()); 
		tmp.setSteps(current.getSteps()+1);
		//~~~~~~~~~~
	    }

	    tmp.setPrev(current);
	    f.add(tmp);
	}						
    }

    public double EuDist(Node c){
	int xDist = Math.abs(c.getX()-e.getX());
	int yDist = Math.abs(c.getY()-e.getY());
	return Math.sqrt(xDist*xDist + yDist*yDist);
    }

    public double TaxiDist(Node c){
	int xDist = Math.abs(c.getX()-e.getX());
	int yDist = Math.abs(c.getY()-e.getY());
	return xDist + yDist;
    }

    public void exitLocation(){
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[i].length; j++){
		if (board[i][j] == exit){
		    e = new Node(i,j);
		}
	    }
	}
    }

    public void search(int x, int y, char type){
	exitLocation();

	f = new Frontier();
	start = new Node(x,y);
	f.add(start);

	Node current = null;
	while (!f.isEmpty()){
	    current = f.remove();
	    int cx = current.getX();
	    int cy = current.getY();

	    if (board[cx][cy]=='$')
		break;
						
	    board[cx][cy]='z';

	    addToFront(cx+1,cy,current,type);
	    addToFront(cx-1,cy,current,type);
	    addToFront(cx,cy+1,current,type);
	    addToFront(cx,cy-1,current,type);

	    delay(50);
	    System.out.println(this);
	}

	// path recovery
	for (Node p = current.getPrev(); p != null ; p = p.getPrev()){
	    board[p.getX()][p.getY()] = 'P';
	    delay(100);
	    System.out.println(this);
	}	    
    }
		
    public static void main(String[] args){
	Maze m = new Maze();
	//best first
	System.out.println(m);
	m.search(1,1,'b');
	System.out.println("~~~~~ Best First Search Result: ~~~~~");
	System.out.println(m);
	m.delay(2000);

	Maze m2 = new Maze();
	//A*
	System.out.println(m2);
	m2.search(1,1,'a');
	System.out.println("~~~~~~ A* Search Result: ~~~~~~~");
	System.out.println(m2);
		
    }
}

