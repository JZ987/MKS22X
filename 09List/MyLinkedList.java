public class MyLinkedList{

    private LNode start, end, current;
    private int size;

    public MyLinkedList(){
	start = null;
	end = null;
	current = start;
	size = 0;
    }

    public boolean add(int value){
	if(size == 0){
	    start = new LNode(value);
	    end = start;
	    current = start;
	    size++;
	    return true;
	}
	current = end;
	current.setNext(value);
	end = current.getNext();
	size++;
	return true;
    }

    public int get(int index){
	current = start;
	while(index != 0){
	    index--;
	    current = current.getNext();
	}
	return current.getValue();
    }

    public int set(int index, int newValue){
	
    }

    public int size(){
	return size;
    }

    public String toString(){
	String temp = "[";
	current = start;
	while(current.getNext() != null){
	    temp += current.getValue() + ", ";
	    current = current.getNext();
	}
	temp += current.getValue() + "]";
	return temp;
    }





    class LNode{
	
	private int value;
	private LNode next, prev;

	public LNode(int value){
	    this.value = value;
	    next = null;
	}

	public LNode getPrev(){
	    return prev;
	}

	public LNode getNext(){
	    return next;
	}

	public void setNext(int value){
	    next = new LNode(value);
	}

	public int getValue(){
	    return value;
	}
    }


    public static void main(String[] args){
	MyLinkedList hello = new MyLinkedList();
	hello.add(7);
	hello.add(3);
	hello.add(5);
	hello.add(6);
	hello.add(13);
	hello.add(-4);
	System.out.println(hello.get(3));
	System.out.println(hello);
    }
}
