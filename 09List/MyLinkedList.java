public class MyLinkedList{

    private LNode start, end, current;
    private int size;

    public MyLinkedList{
	start = null;
	end = null;
	current = start;
	size = 0;
    }

    public boolean add(int value){
	if(size == 0){
	    current = new LNode(value);
	    start = current;
	    end = current;
	    return true;
	}

	current.next = new LNode(value);
	end = current.getNext();
	size++;
	return true;
    }

    class LNode{
	
	private int value;
	private LNode next, prev;

	public LNode(int value){
	    this.value = value;
	    next = null;
	}

	public LNode getNext(){
	    return next;
	}
    }
}
