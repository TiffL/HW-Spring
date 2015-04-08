import java.io.*;
import java.util.*;
public class Maze{
    private char[][] board;
    private myQueue frontier = new myQueue();
    private Node current;
    private int maxX;
    private int maxY;
    private char processed = 'p';
    private char path='#';
    private char wall=' ';
    private char me='z';
    private char exit='$';
    private char visited = '.';
    private char route = 'X';
    private boolean solved = false;

    public void delay(int n){
	try {
	    Thread.sleep(n);
	} catch (Exception e) {}
    }

    public Maze()
    {
	maxX=40;
	maxY=20;
	board = new char[maxX][maxY];
	try {
	    Scanner sc = new Scanner(new File("maze.dat"));
	    int j=0;
	    while (sc.hasNext()){
		String line = sc.nextLine();
		for (int i=0;i<maxX;i++)
		    {
			board[i][j] = line.charAt(i);
		    }
		j++;
	    }
	}
	catch (Exception e){}
    }
    public String toString()
    {
	String s = "[2J\n";
	for (int y=0;y<maxY;y++){
	    for (int x=0;x<maxX;x++){
		s = s+board[x][y];
	    }
	    s=s+"\n";
	}
	return s;
    }

    public void solve(int i, int j){
	frontier.enqueue(i,j,null);
	System.out.println(frontier);
	while (!frontier.empty() && solved == false){
	    current = frontier.dequeue();
	    int x = current.getX();
	    int y = current.getY();
	    board[x][y] = visited;
	    help(x,y-1,current);
	    help(x,y+1,current);
	    help(x-1,y,current);
	    help(x+1,y,current);
	    delay(20);
	    System.out.println(this);
	}
        if (solved == true){
	    while (current != null){
		board[current.getX()][current.getY()] = route;
		current = current.getPrevious();
		delay(20);
		System.out.println(this);
	    }
	}
    }

    public void help(int x, int y, Node previous){
	if (board[x][y] == exit){
	    solved = true;
	    //System.exit(0);
	}
	if (solved == false && x<maxX-1 && y<maxY-1 && board[x][y] != visited &&
	    board[x][y] != wall && board[x][y] != processed){
	    board[x][y] = processed;
	    frontier.enqueue(x,y,previous);
	}
    }

    public static void main(String[] args){
	Maze m = new Maze();
	//System.out.println(m);
	m.solve(1,1);
	System.out.println(m);
    }
}
