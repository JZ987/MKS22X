import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;

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
	String removed = heap.get(1);
	heap.set(1, heap.remove(size));
	size--;
	pushDown();
	return removed;
    }

    public String peek(){
	String temp = "[";
	for(String s : heap){
	    temp += s + " ";
	}
	return temp + "]";
    }

    private void pushUp(){
	int n = size;
	System.out.println("Input: " + peek());
	while(n != 1 && Integer.parseInt(heap.get(n)) >= Integer.parseInt(heap.get(n/2))){
	    swap(n, n/2);
	    n /= 2;
	}
	System.out.println("Output: " + peek());
    }

    private void pushDown() throws IndexOutOfBoundsException{
	int n = 1;
	System.out.println("Input: " + peek());
	while(Integer.parseInt(heap.get(n)) < Integer.parseInt(heap.get(n*2)) ||
	      Integer.parseInt(heap.get(n)) < Integer.parseInt(heap.get(n*2+1))){
	    System.out.println("Process: " + peek());
	    if(Integer.parseInt(heap.get(n*2)) > Integer.parseInt(heap.get(n*2+1))){
		swap(n, n*2);
		n *= 2;
	    }else{
		swap(n, n*2+1);
		n *= 2;
		n += 1;
	    }
	}
    }

    private void swap(int first, int second){
	String temp = heap.get(first);
	heap.set(first, heap.get(second));
	heap.set(second, temp);
    }

    public static void main(String[] args){
	MyHeap test = new MyHeap();
	test.add("10");
	test.add("5");
	test.add("8");
	test.add("3");
	test.add("20");
	test.add("15");
	test.add("17");
	test.add("1232");
	test.add("-1");
	test.remove();
	System.out.println(test.peek());
    }
}
