public class Recursion{

    public static String name(){
	return "Zheng,Jack";
    }

    public static double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	return helper(n, 1);
    }

    private static double helper(double n, double guess){
	if(n == 0){
	    return 0;
	}else if(Math.abs(guess * guess - n) <= 0.00000001){
	    return guess;
	}
	double better_guess = (n / guess + guess) / 2;
	return helper(n, better_guess);
    }

    public static void main(String[] args){

	System.out.println("Square root of " + 121 + " is: " + sqrt(121.0));
	System.out.println("Square root of " + 125 + " is: " + sqrt(125));
	System.out.println("Square root of " + 625 + " is: " + sqrt(625));
	System.out.println("Square root of " + 50 + " is: " + sqrt(50));
    }
}
	    
