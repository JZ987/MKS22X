public class KnightBoard{
    
    private int[][] board;
    private int row;
    private int col;

    public KnightBoard(int startingRow, int startingCol){
	board = new int[startingRow][startingCol];
	row = startingRow;
	col = startingCol;
    }
    
    public void solve(){
	solveH(0, 0, 1);
    }

    private boolean solveH(int row, int col, int ID){
	//System.out.println(print(board));
	if(ID > this.row * this.col){
	    return true;
	}
	if(row < 0 || col < 0 || row >= this.row || col >= this.col){
	    return false;
	}
	if(board[row][col] == 0){
	    board[row][col] = ID;
	    if(nextMove(row, col, ID + 1)){
		return true;
	    }else{
		board[row][col] = 0;
	    }
	}
	return false;
    }

    private boolean nextMove(int row, int col, int ID){
	return solveH(row-2, col-1, ID) ||
	       solveH(row-2, col+1, ID) ||
	       solveH(row-1, col-2, ID) ||
	       solveH(row+1, col-2, ID) ||
	       solveH(row+2, col-1, ID) ||
	       solveH(row+2, col+1, ID) ||
	       solveH(row+1, col+2, ID) ||
	       solveH(row+1, col-2, ID);
    }

    private String print(int[][] board){
	String temp = "";
	for(int row = 0; row < this.row; row++){
	    for(int col = 0; col < this.col; col++){
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
	
    public String toString(){
	String temp = "";
	for(int row = 0; row < this.row; row++){
	    for(int col = 0; col < this.col; col++){
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
    
    public static void main(String[] args){
	KnightBoard a = new KnightBoard(4, 4);
	a.solve();
	System.out.println(a);
    }
}
