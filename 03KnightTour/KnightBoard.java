public class KnightBoard{
    
    private int[][] board;
    private int row;
    private int col;
    private int[] rowMove = {-2, -2, -1, -1, 1, 1, 2, 2};
    private int[] colMove = {1, -1, 2, -2, 2, -2, 1, -1};

    public KnightBoard(int startingRow, int startingCol){
	board = new int[startingRow][startingCol];
	row = startingRow;
	col = startingCol;
    }
    
    public void solve(){
	board[0][0] = 1;
	if(!solveH(0, 0, 2)){
	    System.out.println("There is no solution for this board");
	}
    }

    private boolean solveH(int row, int col, int ID){
	int next_row, next_col;
	if(ID > this.row * this.col){
	    return true;
	}
	for(int i = 0; i < 8; i++){
	    next_row = row + rowMove[i];
	    next_col = col + colMove[i];
	    if(isSafe(next_row, next_col)){
		board[next_row][next_col] = ID;
		if(solveH(next_row, next_col, ID + 1)){
		    return true;
		}else{
		    board[next_row][next_col] = 0;
		}
	    }
	}
	return false;
    }

    private boolean isSafe(int row, int col){
	return (row >= 0 &&
		row < this.row &&
		col >= 0 &&
		col < this.col &&
		board[row][col] == 0);
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
	KnightBoard a = new KnightBoard(8, 8);
	a.solve();
	System.out.println(a);
    }
}
