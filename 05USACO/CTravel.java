public class CTravel{
    private int row, col, time, startingRow, startingCol, endingRow, endingCol;
    private int[][] board, tempBoard;
    
    public CTravel(int row, int col, int time, char[][] charBoard, int[][] coordinate){
	this.row = row;
	this.col = col;
	this.time = time;
	this.board = new int[row][col];
	convertBoard(charBoard);
	startingRow = coordinate[0][0] - 1;
	startingCol = coordinate[0][1] - 1;
	endingRow = coordinate[1][0] - 1;
	endingCol = coordinate[1][1] - 1;
	tempBoard = new int[row][col];
    }

    public int solve(){
	board[startingRow][startingCol] = 1;
	return solveH(0);
    }

    private int solveH(int time){
	if(time == this.time){
	    return this.board[endingRow][endingCol];
	}
	copyBoard(board, tempBoard);
	for(int i = 0; i < this.row; i++){
	    for(int j = 0; j < this.col; j++){
		if(isValid(i, j)){
		    tempBoard[i][j] = sumOfAround(i, j);
		}
	    }
	}
	copyBoard(tempBoard, board);
	return solveH(time + 1);
    }

    private void copyBoard(int[][] firstBoard, int[][] secondBoard){
	for(int i = 0; i < this.row; i++){
	    for(int j = 0; j < this.col; j++){
		secondBoard[i][j] = firstBoard[i][j];
	    }
	}
    }
    
    private boolean isOnBoard(int row, int col){
        return row < this.row && row >= 0 && col < this.col && col >= 0;
    }

    private boolean isValid(int row, int col){
	return isOnBoard(row, col) && board[row][col] != -1;
    }
    
    private int sumOfAround(int row, int col){
	int sum = 0;
	if(isValid(row + 1, col)){
	    sum += this.board[row + 1][col];
	}
	if(isValid(row - 1, col)){
	    sum += this.board[row - 1][col];
	}
	if(isValid(row, col + 1)){
	    sum += this.board[row][col + 1];
	}
	if(isValid(row, col - 1)){
	    sum += this.board[row][col - 1];
	}
	return sum;
    }
    
    private void convertBoard(char[][] charBoard){
	for(int i = 0; i < this.row; i++){
	    for(int j = 0; j < this.col; j++){
		if(charBoard[i][j] == '.'){
		    board[i][j] = 0;
		}else if(charBoard[i][j] == '*'){
		    board[i][j] = -1;
		}
	    }
	}
    }

    
    private String print(int[][] board){
	String temp = "";
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		temp += board[i][j] + " ";
	    }
	    temp += "\n";
	}
	return temp;
    }
}
