public class KnightsTour{
    private int[][] board;
    private int filled = 1;
    private int size;
    private boolean solved = false;

    public KnightsTour(){
	size = 5;
	board = new int[5][5];
    }

    public KnightsTour(int s){
	size = s;
	board = new int[s][s];
    }

    public void delay(int n){
	try {
	    Thread.sleep(n);
	} catch (Exception e) {}
    }

    public void tour(int x, int y){
	if (solved || x<0 || y<0 || x >= size|| y >= size || board[x][y] != 0){
	    return;
	}
		
	board[x][y] = filled;
	filled += 1;		
		
	if (filled > size*size){
	    solved = true;
	    System.out.println("\n");
	    printBoard();
	    return;
	}
		
	//delay(400);
	//System.out.println("\n");
	//printBoard();			

	tour(x+2,y+1);
	tour(x+2,y-1);
	tour(x-2,y+1);
	tour(x-2,y-1);
	tour(x+1,y+2);
	tour(x+1,y-2);
	tour(x-1,y+2);
	tour(x-1,y-2);
		
	if (!solved){
	    board[x][y] = 0;
	    filled -= 1;
	}
    }

    public void printBoard(){		
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%3d ", board[i][j]);
            }
            System.out.printf("%n");
        }	        
    }

    public static void main(String[] args){
	KnightsTour k = new KnightsTour();
	k.printBoard();
	k.tour(4,2);
    }
}
