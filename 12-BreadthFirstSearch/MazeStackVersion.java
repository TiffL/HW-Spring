public class MazeStackVersion extends Maze{
    private myStack frontier = new myStack();
    private char[][] board;
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

    public MazeStackVersion(){
	super();
	board = super.getBoard();
	maxX = super.getMaxX();
	maxY = super.getMaxY();
    }

    public String toString(){
	return super.toString();
    }

    public void solve(int i, int j){
	frontier.push(i,j,null);
	System.out.println(frontier);
	while (!frontier.empty() && solved == false){
	    current = frontier.pop();
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
	    frontier.push(x,y,previous);
	}
    }

    public static void main(String[] args){
	MazeStackVersion s = new MazeStackVersion();
	//System.out.println(s);
	s.solve(1,1);
	System.out.println(s);
    }
}
