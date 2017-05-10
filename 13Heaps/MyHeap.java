import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyHeap{
    
    private ArrayList<String> heap;
    private int size, constant;

    public MyHeap(){
	heap = new ArrayList<String>();
	heap.add("");
	size = 0;
	constant = 1;
    }

    public MyHeap(boolean x){
	heap = new ArrayList<String>();
	heap.add("");
	size = 0;
	if(x){
	    constant = 1;
	}else{
	    constant = -1;
	}
    }

    public void add(String str){
	heap.add(str);
	size++;
	pushUp();
    }

    public String remove(){
	if(size == 0){
	    throw new NoSuchElementException("\u001B[34mEmpty heap\u001B[0m");
	}
	if(size == 1){
	    size--;
	    return heap.remove(1);
	}
	String removed = heap.get(1);
	heap.set(1, heap.remove(size));
	size--;
	pushDown();
	return removed;
    }

    public String peek(){
	if(size == 0){
	    throw new NoSuchElementException("\u001B[34mEmpty heap\u001B[0m");
	}
	return heap.get(1);
    }

    private void pushUp(){
	int n = size;
	while(n != 1 && heap.get(n).compareTo(heap.get(n/2)) > 0){
	    swap(n, n/2);
	    n /= 2;
	}
    }

    private void pushDown(){
	int n = 1;
	while(size >= n*2){
	    if(size >= n*2+1){
		if(heap.get(n).compareTo(heap.get(n*2)) >= 0 && 
		   heap.get(n).compareTo(heap.get(n*2+1)) >= 0){
		    return;
		}
		if(heap.get(n*2).compareTo(heap.get(n*2+1)) >= 0){
		    swap(n, n*2);
		    n *= 2;
		}else{
		    swap(n, n*2+1);
		    n = n * 2 + 1;
		}
	    }else{
		if(heap.get(n).compareTo(heap.get(n*2)) >= 0){
		    return;
		}else{
		    swap(n, n*2);
		    n *= 2;
		}
	    }
	}
    }

    private void swap(int first, int second){
	String temp = heap.get(first);
	heap.set(first, heap.get(second));
	heap.set(second, temp);
    }

    public String toString(){
	String temp = "[";
	for(String s : heap){
	    temp += s + " ";
	}
	return temp + "]";
    }

    public static void main(String[] args){
	MyHeap test = new MyHeap();
	test.add("a");
	test.add("b");
	test.add("c");
	test.add("d");
	test.add("e");
	test.add("f");
	test.add("g");
	test.add("h");
	test.add("i");
	test.remove();
	test.remove();
	test.remove();
	test.remove();
	test.remove();
	test.remove();
	test.remove();
	test.remove();
	test.remove();
	//test.remove();
	//test.peek();
	System.out.println(test);
    }
}
