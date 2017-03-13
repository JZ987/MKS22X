public class LakeMaking{
    private int row, col, elevation, steps;
    private int[][] board, instruction;
    
    public LakeMaking(int row, int col, int elevation, int steps, int[][] board, int[][] instruction){
	this.row = row;
	this.col = col;
	this.elevation = elevation;
	this.steps = steps;
	this.board = board;
	this.instruction = instruction;
    }

    public int solve(){
	return solveH(0);
    }

    private int solveH(int steps){
	if(steps == this.steps){
	    return calculate();
	}
	int row = instruction[steps][0] - 1;
	int col = instruction[steps][1] - 1;
	int stomp = instruction[steps][2];
	processStomping(row, col, findHighestPoint(row, col) - stomp);
	return solveH(steps + 1);
    }

    private boolean isOnBoard(int row, int col){
	return row < this.row && row >= 0 && col < this.col && col >= 0;
    }

    private int findHighestPoint(int row, int col){
	int highestPoint = 0;
	for(int i = 0; i < 3; i++){
	    for(int j = 0; j < 3; j++){
		if(isOnBoard(row + i, col + j)){
		    if(board[row + i][col + j] > highestPoint){
			highestPoint = board[row + i][col + j];
		    }
		}
	    }
	}
	return highestPoint;
    }

    private void processStomping(int row, int col, int stomp2){
	for(int i = 0; i < 3; i++){
	    for(int j = 0; j < 3; j++){
		if(board[row + i][col + j] > stomp2){
		    board[row + i][col + j] = stomp2;
		}
	    }
	}
    }
		
    private int calculate(){
	int totalDepth = 0;
	for(int i = 0; i < row; i++){
	    for(int j = 0; j < col; j++){
		if(board[i][j] > elevation){
		    board[i][j] = 0;
		}else{
		    board[i][j] = elevation - board[i][j];
		}
		totalDepth += board[i][j];
	    }
	}
	return totalDepth * 72 * 72;
    }
}
