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
	swap(array, start, pivot);
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
	swap(array, start, lt);
	quickSortHelper(array, start, lt);
	quickSortHelper(array, gt, end);
    }


    public static int quickselect(int[] array, int k){
	if(quickSelectHelper(array, k, 0, array.length - 1)){
	    return array[k];
	}

	return 0;
    }

    private static boolean quickSelectHelper(int[] array, int k, int start, int end){
	int index = new Random().nextInt(end - start) + start;
	int pivot = array[index];
	swap(array, start, pivot);
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
	swap(array, start, lt);
	if(lt <= k && k >= gt){
	    return true;
	}
	return quickSelectHelper(array, k, start, end);
    }

    public static int partition(int[] array, int start, int end){
	int index = new Random().nextInt(end - start) + start;
	int pivot = array[index];
	swap(array, start, pivot);
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
	swap(array, start, lt);
	return lt;
    }

    private static void swap(int[] array, int index1, int index2){
	int firstDigit = array[index1];
	int secondDigit = array[index2];
	array[index1] = secondDigit;
	array[index2] = firstDigit;
    }

    private static String print(int[] ary){
	String tmp = "";
	for(int i = 0; i < ary.length; i++){
	    tmp += ary[i] + ", ";
	}
	return tmp;
    }

    public static void main(String[] args){

	int[] array = {2, 10, 15, 23, 0, 5};
	
	System.out.println(print(array));
	quicksort(array);
	System.out.println(print(array));
    }
}
