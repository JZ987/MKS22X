import java.util.Stack;
import java.util.EmptyStackException;

public class FrontierStack implements Frontier{

    private Stack<Location> locations = new Stack<Location>();
    
    public void add(Location next){
	locations.push(next);
    }

    public Location next(){
	return locations.pop();
    }

    public boolean hasNext(){
	try{
	    locations.peek();
	}catch(EmptyStackException e){
	    return false;
	}
	return true;
    }

    public int size(){
	return locations.size();
    }
}
