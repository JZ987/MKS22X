import java.util.LinkedList;
import java.util.NoSuchElementException;

public class FrontierQueue implements Frontier{

    private LinkedList<Location> locations = new LinkedList<Location>();
    
    public void add(Location next){
	locations.add(next);
    }

    public Location next(){
	return locations.remove(0);
    }

    public boolean hasNext(){
	try{
	    locations.getFirst();
	}catch(NoSuchElementException e){
	    return false;
	}
	return true;
    }

    public int size(){
	return locations.size();
    }
}
