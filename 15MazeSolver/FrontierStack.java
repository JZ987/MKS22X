import java.util.Stack;
import java.util.EmptyStackException;

public class FrontierStack implements Frontier{

    private Stack<Location> locations;
    
    public FrontierStack(){
	locations = new Stack<Location>();
    }
        
    public void add(Location next){
	locations.push(next);
    }

    public Location next(){
	if(!hasNext()){
	    throw new EmptyStackException();
	}
	return locations.pop();
    }

    public boolean hasNext(){
	return !locations.empty();
    }

    public int size(){
	return locations.size();
    }
}
