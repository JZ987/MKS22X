import java.util.Random;

public class Quick{
    private static int answer;
    private static int[] data;

    public Quick(int[] array){
	answer = 0;
	data = array;
    }

    public static int quickselect(int k, int start, int end){
	int index = partition(start, end);
	if(index == k){
	    return answer;
	}
	return quicksort(k, start, end);
    }

    public static int partition(int start, int end){
	int index = new Random().nextInt(end - start) + start;
	int pivot = data[index];
	swap(index, end);
	int count = 0;
	int[] temp = new int[(end + 1) - start];
	for(int i = 0; i < temp.length; i++){
	    temp[i] = data[start + i];
	}
	for(int i = 0; i < temp.length; i++){
	    if(temp[i] == pivot){
		count++;
	    }
	    if(temp[i] < pivot){
		data[start + i] = temp[i];
		start++;
	    }
	    if(temp[i] > pivot){
		//temp[end] = data[i];
		end--;
	    }
	}
	for(int i = start; i < count; i++){
	    start++;
	}
	answer = pivot;
	//temp[start] = number;
	return start;
    }

    private static void swap(int index1, int index2){
	int firstDigit = data[index1];
	int secondDigit = data[index2];
	data[index1] = secondDigit;
	data[index2] = firstDigit;
    }

    public static void main(String[] args){

	int[] array = {2, 10, 15, 23, 0, 5};
	Quick a = new Quick(array);
	
	System.out.println(a.quickselect(0, 0, 5));
	System.out.println(a.quickselect(1, 0, 5));
	System.out.println(a.quickselect(2, 0, 5));
	System.out.println(a.quickselect(3, 0, 5));
	System.out.println(a.quickselect(4, 0, 5));
	System.out.println(a.quickselect(5, 0, 5));
    }


}
