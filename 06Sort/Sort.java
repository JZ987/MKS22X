import java.util.Random;

public class Sort{

    public static int partition(int[] data, int start, int end){
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
	//temp[start] = number;
	return start;
    }

    public static String print(int[] array){
	String temp = "";
	for(int i = 0; i < array.length; i++){
	    temp += array[i] + " ";
	}
	return temp;
    }
    
    public static void main(String[] args){
	int[] a = {4, 13, 7, 1, 6, 9};
	int[] b = {1, 2, 3, 4, 5, 6};
	
	System.out.println(partition(b, 0, b.length - 1));
    }
}
