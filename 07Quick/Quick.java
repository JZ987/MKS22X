import java.util.Random;

public class Quick{

    public static void quicksort(int[] array){
	
    }

    public static int quickselect(int[] array, int k){
	if(quickSelectHelper(array, k, 0, array.length - 1)){
	    return array[k];
	}
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
	return quickSelectHelper(array, k);
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

    public static void main(String[] args){

	int[] array = {2, 10, 15, 23, 0, 5};
	
	System.out.println(a.quickselect(0, 0, 5));
	System.out.println(a.quickselect(1, 0, 5));
	System.out.println(a.quickselect(2, 0, 5));
	System.out.println(a.quickselect(3, 0, 5));
	System.out.println(a.quickselect(4, 0, 5));
	System.out.println(a.quickselect(5, 0, 5));
    }


}
