public class KnightBoard{
    
    private int[][] board;
    private int row;
    private int col;

    public KnightBoard(int startingRow, int startingCol){
	board = new int[startingRow][startingCol];\
	row = startingRow;
	col = startingCol;
    }
    
    public void solve(){
	solveH(0, 0, 1);
    }

    private boolean solveH(int row, int col, int ID){
	if(ID == row * col){
	    return true;
	}
	
	return false;
    }

    public String toString(){
	String temp = "";
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board[0].length; col++){
		if(board[row][col] < 10){
		    temp += " " + board[row][col] + " ";
		}else{
		    temp += board[row][col] + " ";
		}
	    }
	    temp += "\n";
	}
	return temp;
    }
    
}
