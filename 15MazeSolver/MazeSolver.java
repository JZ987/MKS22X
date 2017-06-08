import java.util.NoSuchElementException;

public class MazeSolver{

    private Maze board;
    private Frontier method;
    private boolean animate, aStar = false;
    private int distToStart;

    public MazeSolver(String fileName){
	this(fileName, false);
    }

    public MazeSolver(String fileName, boolean animate){
	board = new Maze(fileName);
	this.animate = animate;
	distToStart = 0;
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
	    if(animate){
		System.out.println(board.toString(75));
	    }
	    Location current = method.next();
	    row = current.getRow();
	    col = current.getCol();
	    board.set(row, col, '.');
	    if(row == board.getEnd().getRow() &&
	       col == board.getEnd().getCol()){
		while(current.getPrev() != null){
		    if(animate){
			System.out.println(board.toString(50));
		    }
		    board.set(current.getPrev().getRow(), current.getPrev().getCol(), '@');
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
	    if(animate){
		System.out.println(board.toString(75));
	    }
	    Location current = method.next();
	    row = current.getRow();
	    col = current.getCol();
	    board.set(row, col, '.');
	    if(row == board.getEnd().getRow() &&
	       col == board.getEnd().getCol()){
		while(current.getPrev() != null){
		    if(animate){
			System.out.println(board.toString(50));
		    }
		    board.set(current.getPrev().getRow(), current.getPrev().getCol(), '@');
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
	method.add(board.getStart());
	int row = -1;
	int col = -1;
	while(method.hasNext()){
	    if(animate){
		System.out.println(board.toString(50));
	    }
	    Location current = method.next();
	    row = current.getRow();
	    col = current.getCol();
	    board.set(row, col, '.');
	    //System.out.println("Distance to end: " + calcDistance(current, board.getEnd()) + " Distance to start: " + calcDistance(current, board.getStart()));
	    if(row == board.getEnd().getRow() &&
	       col == board.getEnd().getCol()){
		while(current.getPrev() != null){
		    if(animate){
			System.out.println(board.toString(50));
		    }
		    board.set(current.getPrev().getRow(), current.getPrev().getCol(), '@');
		    current = current.getPrev();
		}
		return;
	    }
	    process(current);
	}
	
    }

    private void aStarSearch(){
	method = new FrontierPriorityQueue();
	aStar = true;
	method.add(board.getStart());
	int row = -1;
	int col = -1;
	while(method.hasNext()){
	    if(animate){
		System.out.println(board.toString(50));
	    }
	    Location current = method.next();
	    row = current.getRow();
	    col = current.getCol();
	    board.set(row, col, '.');
	    if(row == board.getEnd().getRow() &&
	       col == board.getEnd().getCol()){
		while(current.getPrev() != null){
		    if(animate){
			System.out.println(board.toString(50));
		    }
		    board.set(current.getPrev().getRow(), current.getPrev().getCol(), '@');
		    current = current.getPrev();
		}
		return;
	    }
	    process(current);
	}
    }	 

    private void process(Location current){
	int row = current.getRow();
	int col = current.getCol();
	distToStart = current.getDistToStart() + 1;
	//System.out.println("Distance from start: " + distToStart);
	if(isValid(row, col+1)){
	    method.add(new Location(row, col+1, current,
				    distToStart,
				    calcDistance(row, col+1, board.getEnd()), aStar));
	    board.set(row, col+1, '?');
	    //System.out.println("right");
	}
	if(isValid(row-1, col)){
	    method.add(new Location(row-1, col, current,
				    distToStart,
				    calcDistance(row-1, col, board.getEnd()), aStar));
	    board.set(row-1, col, '?');
	    //System.out.println("up");
	}
	if(isValid(row+1, col)){
	    method.add(new Location(row+1, col, current,
				    distToStart,
				    calcDistance(row+1, col, board.getEnd()), aStar));
	    board.set(row+1, col, '?');
	    //System.out.println("down");
	}
	if(isValid(row, col-1)){
	    method.add(new Location(row, col-1, current,
				    distToStart,
				    calcDistance(row, col-1, board.getEnd()), aStar));
	    board.set(row, col-1, '?');
	    //System.out.println("left");
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
