import java.util.NoSuchElementException;

public class MyDeque{

    private int front, back, size;
    private String[] data;
    
    public MyDeque(){
	data = new String[1];
	front = 0;
	back = 0;
	size = 1;
    }

    public MyDeque(int size){
	data = new String[size];
	front = 0;
	back = 0;
	this.size = size;
    }
    
    public void addFirst(String newString) throws NullPointerException{
	if(size == 1 && data[0] == null){
	    data[0] = newString;
	    return;
	}
	if(back + 1 == front || (front == 0 && back == size - 1)){
	    grow();
	}
	if(front == 0){
	    front = size - 1;
	    data[front] = newString;
	}else{
	    front--;
	    data[front] = newString;
	}
    }

    public void addLast(String newString) throws NullPointerException{
	if(size == 1 && data[0] == null){
	    data[0] = newString;
	    return;
	}
	if(back + 1 == front || (front == 0 && back == size - 1)){
	    grow();
	}
	if(back == size - 1){
	    back = 0;
	    data[back] = newString;
	}else{
	    back++;
	    data[back] = newString;
	}
    }

    public String removeFirst(){
	if(size == 1 && data[0] == null){
	    throw new NoSuchElementException("Empty stack!");
	}
	String temp = data[front];
	if(front == size - 1){
	    data[front] = null;
	    front = 0;
	}else{
	    data[front] = null;
	    front++;
	}
	if(shrinkable()){
	    shrink();
	}
	return temp;
    }

    public String removeLast(){
	if(size == 1 && data[0] == null){
	    throw new NoSuchElementException("Empty stack!");
	}
	String temp = data[back];
	if(back == 0){
	    data[back] = null;
	    back = size - 1;
	}else{
	    data[back] = null;
	    back--;
	}
	if(shrinkable()){
	    shrink();
	}
	return temp;
    }

    public String getFirst(){
	if(size == 1 && data[0] == null){
	    throw new NoSuchElementException("Empty stack!");
	}
	return data[front];
    }

    public String getLast(){
	if(size == 1 && data[0] == null){
	    throw new NoSuchElementException("Empty stack!");
	}
	return data[back];
    }

    private boolean shrinkable(){
	if(size <= 3){
	    for(int i = 0; i < size; i++){
		if(data[i] != null){
		    return false;
		}
	    }
	    size = 1;
	    front = 0;
	    back = 0;
	    return true;
	}
	if(front > back){
	    return (front - back + 1) <= (size/4);
	}else{
	    return (back - front + 1) <= (size/4);
	}
    }

    private void shrink(){
	String[] temp = new String[size / 2];
	int counter = 0;
	if(size == 1 && front == 0 && back == 0){
	    data = new String[1];
	    front = 0;
	    back = 0;
	    size = 1;
	    return;
	}else if(front <= back){
	    for(int i = front; i <= back; i++){
		temp[counter] = data[i];
		counter++;
	    }
	}else{
	    for(int i = front; i < size; i++){
		temp[counter] = data[i];
		counter++;
	    }
	    for(int i = 0; i < front; i++){
		temp[counter] = data[i];
		counter++;
	    }
	}
	data = temp;
	front = 0;
	back = counter - 1;
	size /= 2;
    }
    
    private void grow(){
	String[] temp = new String[size * 2];
	int counter = 0;
	for(int i = front; i < size; i++){
	    temp[counter] = data[i];
	    counter++;
	}
	for(int i = 0; i < front; i++){
	    temp[counter] = data[i];
	    counter++;
	}
	data = temp;
	front = 0;
	back = counter - 1;
	size *= 2;
    }
    
    public String toString(){
	if(size == 1 && data[0] == null){
	    return "[]";
	}
	String temp = "[";
	for(int i = 0; i < size - 1; i++){
	    if(data[i] == null){
		temp += ", ";
	    }else{
		temp += data[i] + ", ";
	    }
	}
	if(data[size - 1] == null){
	    temp += "]";
	}else{
	    temp += data[size - 1] + "]";
	}
	return temp;
    }
    
    public static void main(String[] args){

	MyDeque test = new MyDeque();

	test.addFirst("hi");
	test.addFirst("bye");
	test.addFirst("cat");
	test.addLast("dog");
	test.addLast("egg");
	System.out.println(test);
	test.removeFirst();
	test.removeLast();
	test.removeFirst();
	test.removeLast();
	System.out.println(test);
	test.removeLast();
	System.out.println(test);
    }
}
