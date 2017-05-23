import java.util.NoSuchElementException;

public class MazeSolver{

    private Maze board;
    private Frontier method;
    private boolean animate, aStar = false;

    public MazeSolver(String fileName){
	this(fileName, false);
    }

    public MazeSolver(String fileName, boolean animate){
	board = new Maze(fileName);
	this.animate = animate;
    }
    
    public void solve(){
	solve(0);
    }
    
    public void solve(int style){
	switch (style){
	case 0: depthSearch();
	    break;
	case 1: breadthSearch();
	    break;
	case 2: bestFirstSearch();
	    break;
	case 3: aStarSearch();
	    break;
	default: System.out.println("Invalid solve method");
	    break;
	}
    }

    private void depthSearch(){
	method = new FrontierStack();
	aStar = false;
	method.add(board.getStart());
	int row = -1;
	int col = -1;
	while(method.hasNext()){
	    System.out.println(board.toString(100));
	    Location current = method.next();
	    row = current.getRow();
	    col = current.getCol();
	    board.set(row, col, '.');
	    if(row == board.getEnd().getRow() &&
	       col == board.getEnd().getCol()){
		while(current.getPrev() != null){
		    System.out.println(board.toString(100));
		    board.set(current.getRow(), current.getCol(), '@');
		    current = current.getPrev();
		}
		return;
	    }
	    process(current);
	}
    }
    
    private void breadthSearch(){
	method = new FrontierQueue();
	aStar = false;
	method.add(board.getStart());
	int row = -1;
	int col = -1;
	while(method.hasNext()){
	    System.out.println(board.toString(100));
	    Location current = method.next();
	    row = current.getRow();
	    col = current.getCol();
	    board.set(row, col, '.');
	    if(row == board.getEnd().getRow() &&
	       col == board.getEnd().getCol()){
		while(current.getPrev() != null){
		    System.out.println(board.toString(100));
		    board.set(current.getRow(), current.getCol(), '@');
		    current = current.getPrev();
		}
		return;
	    }
	    process(current);
	}
    }

    private void bestFirstSearch(){
	method = new FrontierPriorityQueue();
	aStar = false;
    }

    private void aStarSearch(){
	method = new FrontierPriorityQueue();
	aStar = true;
    }	 

    private void process(Location current){
	int row = current.getRow();
	int col = current.getCol();
	if(isValid(row+1, col)){
	    method.add(new Location(row+1, col, current,
				    calcDistance(row+1, col, board.getStart()),
				    calcDistance(row+1, col, board.getEnd()), aStar));
	}
	if(isValid(row-1, col)){
	    method.add(new Location(row-1, col, current,
				    calcDistance(row-1, col, board.getStart()),
				    calcDistance(row-1, col, board.getEnd()), aStar));
	}
	if(isValid(row, col+1)){
	    method.add(new Location(row, col+1, current,
				    calcDistance(row, col+1, board.getStart()),
				    calcDistance(row, col+1, board.getEnd()), aStar));
	}
	if(isValid(row, col-1)){
	    method.add(new Location(row, col-1, current,
				    calcDistance(row, col-1, board.getStart()),
				    calcDistance(row, col-1, board.getEnd()), aStar));
	}
    }

    private int calcDistance(Location current, Location destination){
	return Math.abs(destination.getRow() - current.getRow()) +
	    Math.abs(destination.getCol() - current.getCol());
    }

    private int calcDistance(int r, int c, Location destination){
	return Math.abs(destination.getRow() - r) +
	    Math.abs(destination.getCol() - c);
    }
    
    private boolean isValid(int r, int c){
	return 0 <= r && r < board.getRowLength() && 0 <= c && c < board.getColLength() && board.get(r, c) == ' ';
    }

    public String toString(){
	return board.toString();
    }
}
