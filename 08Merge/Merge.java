public class Merge{
    
    public static void mergesort(int[] ary){
	if(ary.length <= 1){
	    return;
	}
	int[] left = separate(ary, 0, (int)ary.length/2);
	int[] right = separate(ary, (int)ary.length/2, ary.length);
	mergesort(left);
	mergesort(right);
	merge(left, right, ary);
    }

    public static int[] separate(int[] array, int begin, int end){
	int[] temp = new int[end - begin];
	int index = 0;
	for(int i = begin; i < end; i++){
	    temp[index] = array[i];
	    index++;
	}
	return temp;
    }

    public static void merge(int[] a, int[] b, int[] result){
	int i = 0;
	int j = 0;
	for(int n = 0; n < result.length; n++){
	    if (i >= b.length) {
                result[n] = a[j];
                j++;
            }else if (j >= a.length) {
                result[n] = b[i];
                i++;
            }else if (b[i] < a[j]) {
                result[n] = b[i];
                i++;
            }else {
                result[n] = a[j];
                j++;
	    }
	}
    }

    public static String print(int[] ary){
	String tmp = "";
	for(int i = 0; i < ary.length; i++){
	    tmp += ary[i] + " ";
	}
	return tmp;
    }

    public static void main(String[] args){
	int[] array = {11, 23, 54, 0, 34, 23};
	System.out.println(print(array));
	mergesort(array);
	System.out.println(print(array));
    }
}
