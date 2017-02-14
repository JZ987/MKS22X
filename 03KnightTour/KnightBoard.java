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
	return "";
    }
    
}
