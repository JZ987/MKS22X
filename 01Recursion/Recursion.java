public class Recursion{

    public static String name(){
	return "Zheng,Jack";
    }

    public static double sqrt(double n) throws IllegalArgumentException{
	return helper(n, 1);
    }

    private static double helper(double n, double guess){
	if(Math.abs(guess * guess - n) <= 0.00000000001)
	return guess;
	double better_guess = (n / guess + guess) / 2;
	return helper(n, better_guess);
    }

    public static void main(String[] args){

	System.out.println("Square root of " + 121 + " is: " + sqrt(121));
	System.out.println("Square root of " + 125 + " is: " + sqrt(125));
	System.out.println("Square root of " + 625 + " is: " + sqrt(625));
	System.out.println("Square root of " + 50 + " is: " + sqrt(50));	
    }
}
	    
