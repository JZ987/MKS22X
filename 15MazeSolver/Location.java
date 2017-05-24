public class Location implements Comparable<Location>{

    private int row, col, distToStart, distToGoal;
    private Location previous;
    private boolean aStar;

    public Location(int r, int c, Location previous, int distToStart, int distToGoal, boolean aStar){
	row = r;
	col = c;
	this.previous = previous;	
	this.distToStart = distToStart;
	this.distToGoal = distToGoal;
	this.aStar = aStar;
    }

    public int getRow(){
	return row;
    }

    public int getCol(){
	return col;
    }

    public int getDistToStart(){
	return distToStart;
    }

    public int getDistToGoal(){
	return distToGoal;
    }

    public Location getPrev(){
	return previous;
    }

    public int compareTo(Location other){
	if(this.aStar){
	    return (this.distToStart + this.distToGoal) - (other.distToStart + other.distToGoal);
	}else{
	    return this.distToGoal - other.distToGoal;
	}
    }
}
