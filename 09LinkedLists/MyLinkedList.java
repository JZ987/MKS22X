import java.util.*;

public class MyLinkedList implements Iterable<Integer> {

    public LNode start, end, current;
    public int size;

    public MyLinkedList(){
	start = null;
	end = start;
	current = start;
	size = 0;
    }

    public boolean add(int value){
	return add(size, value);
    }

    public boolean add(int index, int value){
	LNode newNode = new LNode(value);
	if(size == 0){
	    start = newNode;
	    end = newNode;
	}else if(size == index){
	    end.next = newNode;
	    newNode.prev = end;
	    end = newNode;
	}else if(index == 0){
	    start.prev = newNode;
	    newNode.next = start;
	    start = newNode;
	}else{
	    addAfter(getNthNode(index - 1), newNode);
	}
	size++;
	return true;
    }

    private void addAfter(LNode location, LNode toBeAdded){
	toBeAdded.next = location.next;
	toBeAdded.prev = location;
	location.next.prev = toBeAdded;
	location.next = toBeAdded;
    }

    public int remove(int index){
	current = getNthNode(index);
	int oldValue = current.value;
	if(size == 1 && index == 0){
	    start = null;
	    end = start;
	}else if(index == 0){
	    start.next.prev = null;
	    start = start.next;
	}else if((index + 1) == size){
	    end.prev.next = null;
	    end = end.prev;
	}else{
	    remove(current);
	}
	size--;
	return oldValue;
    }
    
    private void remove(LNode target){
	target.next.prev = target.prev;
	target.prev.next = target.next;
    }
    
    private LNode getNthNode(int n){
	if(n < 0 || n >= size){
	    throw new IndexOutOfBoundsException();
	}
	current = start;
	while(n != 0){
	    current = current.next;
	    n--;
	}
	return current;
    }

    public int get(int index){
	return getNthNode(index).value;
    }

    public int set(int index, int newValue){
	int oldValue = get(index);
	current.value = newValue;
	return oldValue;
    }

    public int indexOf(int value){
	current = start;
	int counter = 0;
	while(current.value != value){
	    counter++;
	    current = current.next;
	}
	return counter;
    }
    
    public Iterator<Integer> iterator(){
	return new LinkedListIterator(this);
    }
    
    public int size(){
	return size;
    }

    public String enhancedPrint(){
	String temp = "[";
	current = start;
	while(current.next != null){
	    if(current.prev == null){
		temp += "(null)";
	    }else{
		temp += "(" + current.prev.value + ")";
	    }
	    temp += current.value;
	    if(current.next == null){
		temp += "(null)";
	    }else{
		temp += "(" + current.next.value + ")";
	    }
	    temp += ", ";
	    current = current.next;
	}
	temp += "(" + current.prev.value + ")" + current.value + "(null)]";
	return temp;
    }

    public String toString(){
	if(size == 0){
	    return "[]";
	}
	String temp = "[";
	current = start;
	while(current.next != null){
	    temp += current.toString();
	    current = current.next;
	}
	temp += current.value + "]";
	return temp;
    }



    
    
    private class LNode{
	
	int value;
	LNode next, prev;

	public LNode(int value){
	    this.value = value;
	    next = null;
	    prev = null;
	}

	public String toString(){
	    return value + ",";
	}
    }



    

    public class LinkedListIterator implements Iterator<Integer> {

	public MyLinkedList list;
	public LNode location;
	
	public LinkedListIterator(MyLinkedList list){
	    this.list = list;
	    location = list.start;
	}

	public boolean hasNext(){
	    return location != null;
	}
	
	public Integer next(){
	    if (hasNext()){
		int value = location.value;
		location = location.next;
		return value;
	    }else{
		throw new NoSuchElementException();
	    }
	}
        
	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }


    
    public static void main(String[] args){
	MyLinkedList hi = new MyLinkedList();
	Random rand = new Random();

	for(int i = 0; i < 10000000; i++){
	    hi.add(rand.nextInt(500));
	}

	System.out.println("Size: " + hi.size);
    }












    /*public static void main(String[] args){
	//Testing: constructor, toString, size, add, get, remove
	
	MyLinkedList a= new MyLinkedList();
	
	//System.out.println(a.toString() + "\nSize: " + a.size());  //[], size=0

	for(int i = 0; i < 20; i++){
	    a.add(i);
	    if(a.get(a.size()-1)%2==0){
		a.remove(a.size()-1);
	    }
	    //System.out.println(a);//Check if all nums arent odd
	}
	
	System.out.println(a+"\nSize: "+a.size());//odds 0-20 in order, size=10
	System.out.println(a.enhancedPrint());

	//Testing: set, indexOf, add(i,v); reinforce others
	for(int i=0; i<10; i++){
	    a.set(i,i*100);
	}
	
	System.out.println(a+"\nSize: "+a.size());//mulitples of 100, size=10
	for(int i=0; i<10; i++){
	    a.set(i,a.indexOf(i*100));
	}
	
        System.out.println(a+"\nSize: "+a.size());//0-9 in order, size=10
	a.remove(1);
	a.add(1,1);
	for(int i=0; i<10; i++){
	    a.add(0,i*-1-1);
	}
	a.add(a.size(),10);
	
	System.out.println(a+"\nSize: "+a.size());//-10-10 in order, size=21
	
	//Testing: Iterator
	MyLinkedList data = new MyLinkedList();
	int i = 0;
	while(i < 15){
	    data.add(i);
	    i++;
	}

	System.out.println("\nContents: "+data);
	System.out.println("Standard loop:");

	for(int n = 0; n < data.size(); n++){
	    System.out.print(data.get(n)+" ");
	}
	System.out.println();
	System.out.println("for-each loop:");
	for(Integer s : data){
	    System.out.print(s+" ");
	}
	//should be same
	}*/
}
