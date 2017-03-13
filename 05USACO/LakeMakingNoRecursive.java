public class LakeMakingNoRecursive{
    private int row, col, elevation, steps;
    private int[][] board, instruction;

    public LakeMakingNoRecursive(int row, int col, int elevation, int steps, int[][] board, int[][] instruction){
	this.row = row;
	this.col = col;
	this.elevation = elevation;
	this.steps = steps;
	this.board = board;
	this.instruction = instruction;
    }

    public int solve(){
	for(int i = 0; i < steps; i++){
	    int row = instruction[i][0] - 1;
	    int col = instruction[i][1] - 1;
	    int stomp = instruction[i][2];
	    processStomping(row, col, findHighestPoint(row, col) - stomp);
	}
	return calculate();
    }

    private int findHighestPoint(int row, int col){
	int highestPoint = 0;
	for(int i = 0; i < 3; i++){
	    for(int j = 0; j < 3; j++){
		if(board[row + i][col + j] > highestPoint){
		    highestPoint = board[row + i][col + j];
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
