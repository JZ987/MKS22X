import java.util.*;
import java.io.*;
public class USACO{
    private int finalAnswer;
    
    public USACO(){
	System.out.println("Thanks for using USACO!!");
    }

    public int bronze(String fileName){
	try{
	    Scanner in = new Scanner(new File(fileName));
	    int row = Integer.parseInt(in.next());
	    int col = Integer.parseInt(in.next());
	    int elevation = Integer.parseInt(in.next());
	    int steps = Integer.parseInt(in.next());
	    int [][] board = new int[row][col];
	    for(int i = 0; i < row; i++){
		for(int j = 0; j < col; j++){
		    board[i][j] = Integer.parseInt(in.next());
		}
	    }
	    int [][] instruction = new int[steps][3];
	    for(int i = 0; i < steps; i++){
		for(int j = 0; j < 3; j++){
		    instruction[i][j] = Integer.parseInt(in.next());
		}
	    }

	    LakeMakingNoRecursive cow = new LakeMakingNoRecursive(row, col, elevation, steps, board, instruction);
	    //LakeMaking cow = new LakeMaking(row, col, elevation, steps, board, instruction);
	    finalAnswer = cow.solve();
	}catch(FileNotFoundException e){
	    System.out.println("File not found.");
	    System.exit(1);
	}
	return finalAnswer;
    }

    public int silver(String fileName){
	try{
	    Scanner in = new Scanner(new File(fileName));
	    int row = Integer.parseInt(in.next());
	    int col = Integer.parseInt(in.next());
	    int time = Integer.parseInt(in.next());
	    char [][] board = new char[row][col];
	    for(int i = 0; i < row; i++){
		String temp = in.next();
		for(int j = 0; j < col; j++){
		    board[i][j] = temp.charAt(j);
		}
	    }
	    int [][] coordinate = new int[2][2];
	    for(int i = 0; i < 2; i++){
		for(int j = 0; j < 2; j++){
		    coordinate[i][j] = Integer.parseInt(in.next());
		}
	    }
	    
	    CTravel cow = new CTravel(row, col, time, board, coordinate);
	    finalAnswer = cow.solve();
	}catch(FileNotFoundException e){
	    System.out.println("File not found.");
	    System.exit(1);
	}
	return finalAnswer;
    }

    private String print(int[][] board){
	String temp = "";
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		temp += board[i][j] + " ";
	    }
	    temp += "\n";
	}
	return temp;
    }

    private String printChar(char[][] board){
	String temp = "";
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		temp += board[i][j];
	    }
	    temp += "\n";
	}
	return temp;
    }
    
    public static void main(String[] args){
	USACO x = new USACO();
	System.out.println(x.bronze("LakeTesting/LakeTesting10.txt"));
	//System.out.println(x.silver("CowTravel/CTravelTesting10.txt"));
    }
}
