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

    public String remove() throws NoSuchElementException{
	String removed = heap.get(1);
	heap.set(1, heap.remove(size));
	size--;
	pushDown();
	return removed;
    }

    public String peek() throws NoSuchElementException{
	return heap.get(1);
    }

    private void pushUp(){
	int n = size;
	while(n != 1 && heap.get(n).compareTo(heap.get(n/2)) > 0){
	    swap(n, n/2);
	    n /= 2;
	}
    }

    private void pushDown(int index){
	    
	/*
	while(n*2 <= size || n*2+1 <= size){
	    if(n*2+1 <= size){
		if(heap.get(n).compareTo(heap.get(n*2)) <= 0 && 
		   heap.get(n).compareTo(heap.get(n*2+1)) <= 0){
		    if(heap.get(n*2).compareTo(heap.get(n*2+1)) > 0){
			swap(n, n*2);
			n *= 2;
		    }else{
			swap(n, n*2+1);
			n *= 2;
			n += 1;
		    }
		}
	    }else{
		if(heap.get(n).compareTo(heap.get(n*2)) < 0){
		    swap(n, n*2);
		    n *= 2;
		}
	    }
	    }*/
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
	System.out.println(test);
    }
}
