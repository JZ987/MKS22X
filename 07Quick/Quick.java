import java.util.Random;

public class Quick{
    private static int answer;
    private static int[] data;

    public Quick(int[] array){
	answer = 0;
	data = array;
    }

    public static int quicksort(int k, int start, int end){
	int index = partition(start, end);
	if(index == k){
	    return answer;
	}
	return quicksort(k, start, end);
    }

    public static int partition(int start, int end){
	int index = new Random().nextInt(data.length);
	int number = data[index];
	int[] temp = new int[data.length];
	for(int i = 0; i < data.length; i++){
	    if(data[i] == number){
		continue;
	    }
	    if(data[i] < number){
		temp[start] = data[i];
		start++;
	    }
	    if(data[i] > number){
		temp[end] = data[i];
		end--;
	    }
	}
	answer = number;
	//temp[start] = number;
	return start;
    }

    public static void main(String[] args){

	int[] array = {2, 10, 15, 23, 0, 5};
	Quick a = new Quick(array);
	
	System.out.println(a.quicksort(0, 0, 5));
	System.out.println(a.quicksort(1, 0, 5));
	System.out.println(a.quicksort(2, 0, 5));
	System.out.println(a.quicksort(3, 0, 5));
	System.out.println(a.quicksort(4, 0, 5));
	System.out.println(a.quicksort(5, 0, 5));
    }


}
