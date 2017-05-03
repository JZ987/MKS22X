public class MyHeap{
    
    private ArrayList<String> heap;
    private int size, constant;

    public MyHeap(){
	heap = new ArrayList<String>();
	size = 0;
	constant = 1;
    }

    public MyHeap(boolean x){
	if(x){
	    MyHeap();
	}else{
	    MyHeap();
	    constant = -1;
	}
    }

    public void add(String str){

    }

    public String remove(){
	return heap.remove(1);
    }

    public String peek(){
	return heap;
    }
}
