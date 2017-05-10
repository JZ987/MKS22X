public class RunningMedian{

    private int size;
    private double median;
    private MyHeap leftH, rightH;
    
    public RunningMedian(){
	leftH = new MyHeap();
	rightH = new MyHeap();
	median = 0;
	size = 0;
    }

    public double getMedian(){
	return median;
    }

    public void add(Integer value){
	if(size == 0){
	    leftH.add(value);
	    median = value;
	}else{
	    if(value < median){
		leftH.add(value);
	    }else{
		rightH.add(value);
	    }
	    if(leftH.size() - rightH.size() > 1){
		rightH.add(leftH.remove());
	    }else if(rightH.size() - leftH.size() > 1){
		leftH.add(rightH.remove());
	    }
	    calcMedian();
	}
	size++;
    }

    private void calcMedian(){
	if(leftH.size() == rightH.size()){
	    median = (leftH.peek() + rightH.peek()) / 2;
	}else if(leftH.size() > rightH.size()){
	    median = leftH.peek();
	}else if(rightH.size() > leftH.size()){
	    median = rightH.peek();
	}
    }
    
    public int getSize(){
	return size;
    }

    public static void main(String[] args){
	RunningMedian test = new RunningMedian();

	test.add(132);
	test.add(2);
	test.add(1);
	System.out.println(test.getMedian());
    }
}
