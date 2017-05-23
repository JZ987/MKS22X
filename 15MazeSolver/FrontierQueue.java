import java.util.LinkedList;
import java.util.NoSuchElementException;

public class FrontierQueue implements Frontier{

    private LinkedList<Location> locations;

    public FrontierQueue(){
	locations = new LinkedList<Location>();
    }
    
    public void add(Location next){
	locations.add(next);
    }

    public Location next(){
	if(!hasNext()){
	    throw new NoSuchElementException();
	}
	return locations.removeFirst();
    }

    public boolean hasNext(){
	return !locations.isEmpty();
    }

    public int size(){
	return locations.size();
    }
}
