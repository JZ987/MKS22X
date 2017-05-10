import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyHeap{
    
    private ArrayList<Integer> heap;
    private int size, constant;

    public MyHeap(){
	heap = new ArrayList<Integer>();
	heap.add(null);
	size = 0;
	constant = 1;
    }

    public MyHeap(boolean x){
	heap = new ArrayList<Integer>();
	heap.add(null);
	size = 0;
	if(x){
	    constant = 1;
	}else{
	    constant = -1;
	}
    }

    public void add(int value){
	heap.add(value);
	size++;
	pushUp();
    }

    public Integer remove(){
	if(size == 0){
	    throw new NoSuchElementException("\u001B[34mEmpty heap\u001B[0m");
	}
	if(size == 1){
	    size--;
	    return heap.remove(1);
	}
	int removed = heap.get(1);
	heap.set(1, heap.remove(size));
	size--;
	pushDown();
	return removed;
    }

    public Integer peek(){
	if(size == 0){
	    throw new NoSuchElementException("\u001B[34mEmpty heap\u001B[0m");
	}
	return heap.get(1);
    }

    private void pushUp(){
	int n = size;
	while(n != 1 && heap.get(n) > heap.get(n/2)){
	    swap(n, n/2);
	    n /= 2;
	}
    }

    private void pushDown(){
	int n = 1;
	while(size >= n*2){
	    if(size >= n*2+1){
		if(heap.get(n) >= heap.get(n*2) && 
		   heap.get(n) >= heap.get(n*2+1)){
		    return;
		}
		if(heap.get(n*2) >= heap.get(n*2+1)){
		    swap(n, n*2);
		    n *= 2;
		}else{
		    swap(n, n*2+1);
		    n = n * 2 + 1;
		}
	    }else{
		if(heap.get(n) >= heap.get(n*2)){
		    return;
		}else{
		    swap(n, n*2);
		    n *= 2;
		}
	    }
	}
    }

    private void swap(int first, int second){
	int temp = heap.get(first);
	heap.set(first, heap.get(second));
	heap.set(second, temp);
    }

    public int size(){
	return size;
    }
    
    public String toString(){
	String temp = "[";
	for(Integer i : heap){
	    temp += i + " ";
	}
	return temp + "]";
    }
}
