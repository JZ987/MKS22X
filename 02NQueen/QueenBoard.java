public class QueenBoard{

    private int[][] board;
    private int size;
    private int solutionCount = -1;

    // Create a new QueenBoard with input size
    public QueenBoard(int size){
	board = new int[size][size];
	this.size = size;
    }

    // Solve the existing NQueen problem
    public void solve(){
	solveH(0);
    }

    // Helper function for solve method
    private boolean solveH(int col){
	if(col >= size){
	    return true;
	}
	for(int row = 0; row < size; row++){
	    if(isValid(row, col)){
		addQueen(row, col);
		if(solveH(col + 1)){
		    return true;
		}else{
		    removeQueen(row, col);
		}
	    }
	}
	return false;
    }

    // Count the total solutions a QueenBoard have
    public void countSolutions(){
	resetBoard();
	solutionCount = isSolution(board, 0);
    }

    // Helper function to add up all the unique solutions
    private int isSolution(int[][] tempBoard, int col){
	if(col >= size){
	    return 1;
	}
	int count = 0;
	for(int i = 0; i < size; i++){
	    if(isValid(tempBoard, i, col)){
		tempBoard[i][col] = 1;
		count += isSolution(tempBoard, col + 1);
		tempBoard[i][col] = 0;
	    }
	}
	return count;
    }

    // Helper function to check if the Queen is in danger
    private boolean isValid(int[][] tempBoard, int row, int col){
	for(int i = 0; i < col; i++){
	    if(tempBoard[row][i] == 1){
		return false;
	    }
	}
	for(int i = row, j = col; i >= 0 && j >= 0; i--, j--){
	    if(tempBoard[i][j] == 1){
		return false;
	    }
	}
	for(int i = row, j = col; i < size && j >= 0; i++, j--){
	    if(tempBoard[i][j] == 1){
		return false;
	    }
	}
	return true;
    }
	
    // Helper function to check if the indicated location is valid to put down a Queen
    private boolean isValid(int row, int col){
	return board[row][col] == 0;
    }

    // Helper function to add a Queen at the indicated location
    private void addQueen(int row, int col){
	board[row][col] = -1;
	for(int i = row + 1; i < size; i++){
	    board[i][col] = board[i][col] + 1;
	}
	for(int i = row - 1; i >= 0; i--){
	    board[i][col] = board[i][col] + 1;
	}
	for(int i = col + 1; i < size; i++){
	    board[row][i] = board[row][i] + 1;
	}
	for(int i = col - 1; i >= 0; i--){
	    board[row][i] = board[row][i] + 1;
	}
	for(int i = row + 1, j = col + 1; i < size && j < size; i++, j++){
	    board[i][j] = board[i][j] + 1;
	}
	for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
	    board[i][j] = board[i][j] + 1;
	}
	for(int i = row - 1, j = col + 1; i >= 0 && j < size; i--, j++){
	    board[i][j] = board[i][j] + 1;
	}
	for(int i = row + 1, j = col - 1; i < size && j >= 0; i++, j--){
	    board[i][j] = board[i][j] + 1;
	}
    }

    // Helper function to remove a Queen at the indicated location
    private void removeQueen(int row, int col){
	board[row][col] = 0;
	for(int i = row + 1; i < size; i++){
	    board[i][col] = board[i][col] - 1;
	}
	for(int i = row - 1; i >= 0; i--){
	    board[i][col] = board[i][col] - 1;
	}
	for(int i = col + 1; i < size; i++){
	    board[row][i] = board[row][i] - 1;
	}
	for(int i = col - 1; i >= 0; i--){
	    board[row][i] = board[row][i] - 1;
	}
	for(int i = row + 1, j = col + 1; i < size && j < size; i++, j++){
	    board[i][j] = board[i][j] - 1;
	}
	for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
	    board[i][j] = board[i][j] - 1;
	}
	for(int i = row - 1, j = col + 1; i >= 0 && j < size; i--, j++){
	    board[i][j] = board[i][j] - 1;
	}
	for(int i = row + 1, j = col - 1; i < size && j >= 0; i++, j--){
	    board[i][j] = board[i][j] - 1;
	}
    }

    // Accessor method to get the total solutions a QueenBoard have
    public int getCount(){
	return solutionCount;
    }

    // Resets the board to all 0's
    private void resetBoard(){
	for(int i = 0; i < size; i++){
	    for(int j = 0; j < size; j++){
		board[i][j] = 0;
	    }
	}
    }
    
    // Print out the QueenBoard with numerical indicators
    public String toString(){
	String temp = "";
	for(int i = 0; i < size; i++){
	    for(int j = 0; j < size; j++){
		temp += board[i][j] + " ";
	    }
	    temp += "\n";
	}
	return temp;
    }

    // Print out the QueenBoard with 'Q' to indicate the Queen and '.' to indicate empty space
    public String print(){
	String temp = "";
	for(int i = 0; i < size; i++){
	    for(int j = 0; j < size; j++){
		if(board[i][j] == -1){
		    temp += "Q ";
		}else{
		    temp += ". ";
		}
	    }
	    temp += "\n";
	}
	return temp;
    }

    // Print out the input 2D int array
    public String print(int[][] board){
	String temp = "";
	for(int i = 0; i < size; i++){
	    for(int j = 0; j < size; j++){
		temp += board[i][j] + " "; 
	    }
	    temp += "\n";
	}
	return temp;
    }




    
    public static void main(String[] args){
	/*for(int i = 1; i < 16; i++){
	    long startTime = System.currentTimeMillis();
	    QueenBoard a = new QueenBoard(i);
	    a.solve();
	    long endTime = System.currentTimeMillis();
	    System.out.println("Size " + i + ":\n" + a.print() + "Runtime: " + (endTime - startTime));
	    }*/

	QueenBoard a = new QueenBoard(20);
	a.solve();
	System.out.println(a.print());
	
    }
}

					 
		

    
