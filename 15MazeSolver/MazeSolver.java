public class MazeSolver{

    private Maze board;
    private Frontier method;
    private boolean animate;

    public MazeSolver(String fileName){
	this(fileName, false);
    }

    public MazeSolver(String fileName, boolean animate){
	board = new Maze(fileName);
	this.animate = animate;
    }
    
    public void solve(){
	solve(1);
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
	method.add(board.getStart());
	
    }

    private void breadthSearch(){

    }

    private void bestFirstSearch(){

    }

    private void aStarSearch(){

    }	 

    private void process(Location current){
	

    }
}
