public class Location implements Comparable<Location>{

    private int row, col, distToStart, distToGoal;
    private Location previous;
    private boolean aStar;

    public Location(int r, int c, int distToStart, int distToGoal, Location previous, boolean aStar){
	row = r;
	col = c;
	this.distToStart = distToStart;
	this.distToGoal = distToGoal;
	this.previous = previous;
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
	if(aStar){
	    return (this.distToStart + this.distToGoal) - (other.distToStart + other.distToGoal);
	}else{
	    return this.distToGoal - other.distToGoal;
	}
    }
}
