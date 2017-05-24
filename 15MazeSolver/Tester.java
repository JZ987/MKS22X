public class Tester{

    public static void main(String[] args){
	MazeSolver test = new MazeSolver("Testcases/" + args[0], true);
	test.solve(Integer.parseInt(args[1]));
    }

}
