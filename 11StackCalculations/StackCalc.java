import java.util.Stack;

public class StackCalc{

    public static double eval(String equation){
	String[] tokens = equation.split(" ");
	Stack<Double> values = new Stack<Double>();
	for(String token : tokens){
	    if(isOp(token)){
		values.push(perform(token, values.pop(), values.pop()));
	    }else{
		values.push(Double.parseDouble(token));
	    }
	}
	return values.pop();
    }

    private static boolean isOp(String token){
	return token.equals("+") ||
   	       token.equals("-") ||
	       token.equals("*") ||
	       token.equals("/") ||
	       token.equals("%");
    }

    private static double perform(String token, double digit_1, double digit_2){
	if(token.equals("+")){
	    return digit_2 + digit_1;
	}else if(token.equals("-")){
	    return digit_2 - digit_1;
	}else if(token.equals("*")){
	    return digit_2 * digit_1;
	}else if(token.equals("/")){
	    return digit_2 / digit_1;
	}else if(token.equals("%")){
	    return digit_2 % digit_1;
	}
	return 0;
    }

    public static void main(String[] args){
	System.out.println(StackCalc.eval("10 2 +"));//12.0
	System.out.println(StackCalc.eval("10 2 -"));//8.0
	System.out.println(StackCalc.eval("10 2.0 +"));//12.0
	System.out.println(StackCalc.eval("11 3 - 4 + 2.5 *"));//30.0
	System.out.println(StackCalc.eval("8 2 + 99 9 - * 2 + 9 -"));//839.0
	System.out.println(StackCalc.eval("10 2 + 10 * 1 + 1 1 1 + + + 10 10 + -"));//104.0
    }
}
