import java.util.NoSuchElementException;

public class FrontierPriorityQueue implements Frontier{

    private PriorityQueue locations;
    
    public FrontierPriorityQueue(){
	locations = new PriorityQueue();
    }
    
    public void add(Location next){
	locations.add(next);
    }

    public Location next(){
	if(!hasNext()){
	    throw new NoSuchElementException();
	}
	return locations.getFirst();
    }

    public boolean hasNext(){
	return !locations.isEmpty();
    }

    public int size(){
	return locations.getSize();
    }
}
