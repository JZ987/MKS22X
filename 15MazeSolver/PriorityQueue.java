import java.util.ArrayList;
import java.util.NoSuchElementException;

public class PriorityQueue{

    private ArrayList<Location> queue;

    public PriorityQueue(){
	queue = new ArrayList<Location>();
    }

    public void add(Location location){
	if(queue.size() == 0){
	    queue.add(location);
	    return;
	}
	for(int i = 0; i < queue.size(); i++){
	    if(location.compareTo(queue.get(i)) < 0){
		queue.add(i, location);
		return;
	    }
	}
	queue.add(location);
    }

    public Location getFirst(){
	return queue.remove(0);
    }

    public boolean isEmpty(){
	return queue.isEmpty();
    }

    public int getSize(){
	return queue.size();
    }
}
    




	
    /*
    public PriorityQueue(){
	heap = new ArrayList<Location>();
	heap.add(null);
	size = 0;
    }

    public void add(Location location){
	
    }

    public String remove(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	if(size == 1){
	    size--;
	    return heap.remove(1).toString();
	}
	String removed = heap.get(1).toString();
	heap.set(1, heap.remove(size));
	pushDown();
	return removed;
    }

    private void pushUp(){
	int n = size;
	while(n != 1 && heap.get(n).compareTo(heap.get(n/2)) < 0){
	    swap(n, n/2);
	    n /= 2;
	}
    }
    
    private void pushDown(){
	int n = 1;
	while(size >= n*2){
	    if(size >= n*2+1){
		if(heap.get(n).compareTo(heap.get(n*2)) > 0 && 
		   heap.get(n).compareTo(heap.get(n*2+1)) > 0){
		    if(heap.get(n*2).compareTo(heap.get(n*2+1)) < 0){
			swap(n, n*2);
			n *= 2;
		    }else if(heap.get(n*2+1).compareTo(heap.get(n*2)) < 0){
			swap(n, n*2+1);
			n = n * 2 + 1;
		    }
		}
	    }else{
		if(heap.get(n).compareTo(heap.get(n*2)) < 0){
		    return;
		}else{
		    swap(n, n*2+1);
		    n = n * 2 + 1;
		}
	    }
	}
    }

    private void swap(int index_1, int index_2){
	Location temp = heap.get(index_1);
	heap.set(index_1, heap.get(index_2));
	heap.set(index_2, temp);
    }
    
    public boolean isEmpty(){
	return heap.isEmpty();
    }

    public Location getFirst(){
	return heap.remove(0);
    }

    public int getSize(){
	return heap.size();
    }
    }*/

