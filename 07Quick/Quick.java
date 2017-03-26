import java.util.Random;

public class Quick{

    public static void quicksort(int[] array){
	quickSortHelper(array, 0, array.length - 1);
    }
    
    private static void quickSortHelper(int[] array, int start, int end){
	if(start >= end){
	    return;
	}
	int index = new Random().nextInt(end - start) + start;
	int pivot = array[index];
	swap(array, start, index);
	int lt = start;
	int i = start + 1;
	int gt = end;
	while(i <= gt){
	    if(array[i] == pivot){
		i++;
	    }else if(array[i] < pivot){
		swap(array, lt, i);
		lt++;
		i++;
	    }else if(array[i] > pivot){
		swap(array, i, gt);
		gt--;
	    }
	}
	quickSortHelper(array, start, lt - 1);
	quickSortHelper(array, gt + 1, end);
    }


    public static int quickselect(int[] array, int k){
	return quickSelectHelper(array, k, 0, array.length - 1);
    }

    private static int quickSelectHelper(int[] array, int k, int start, int end){
	int index = new Random().nextInt(end - start) + start;
	int pivot = array[index];
	swap(array, start, index);
	int lt = start;
	int i = start + 1;
	int gt = end;
	while(i <= gt){
	    if(array[i] == pivot){
		i++;
	    }else if(array[i] < pivot){
		swap(array, lt, i);
		lt++;
		i++;
	    }else if(array[i] > pivot){
		swap(array, i, gt);
		gt--;
	    }
	}
	if(k < lt){
	    return quickSelectHelper(array, k, start, lt);
	}else if(k > gt){
	    return quickSelectHelper(array, k, gt, end);
	}
	return pivot;
    }

    private static void swap(int[] array, int index1, int index2){
	int firstDigit = array[index1];
	array[index1] = array[index2];
	array[index2] = firstDigit;
    }

    private static String print(int[] ary){
	String tmp = "";
	for(int i = 0; i < ary.length - 1; i++){
	    tmp += ary[i] + " ";
	}
	return tmp;
    }

    public static void addInteger(int[] array){
	for(int i = 0; i < array.length; i++){
	    int num = new Random().nextInt(array.length);
	    array[i] = num;
	}
    }
    
    public static void main(String[] args){

	//int[] array = {-1, -21, 114, 1234, 14, 0, -231, -34, 3412, -1};
	int[] array = new int[100];
	long startTime = System.currentTimeMillis();
	addInteger(array);
	System.out.println("Unsorted: " + print(array));
	quicksort(array);
	System.out.println("Sorted: " + print(array));
	System.out.println("----------------------------------");
	//System.out.println("Index 0: " + quickselect(array, 0));
	//System.out.println("Index 5: " + quickselect(array, 5));
	//System.out.println("Index 4: " + quickselect(array, 4));
	//System.out.println("Index 8: " + quickselect(array, 8));
	//System.out.println("Index 3: " + quickselect(array, 3));
	System.out.println("Timer: " + (System.currentTimeMillis() - startTime));
    }
}
