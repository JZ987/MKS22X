import java.io.*;
import java.util.*;

public class Maze{
    private char[][] maze;
    private int row = 0;
    private int col = 0;
    private String file;
    
    public Maze(String fileName){
	scanFile(fileName);
	System.out.println(file);
	initializeMaze();
    }

    private void scanFile(String fileName){
	try{
	    Scanner inf = new Scanner(new File(fileName));
	    while(inf.hasNextLine()){
		row++;
		String line = inf.nextLine();
		System.out.println(line);
	    }       
    }

    private void initializeMaze(){
    }

    public static void main(String args[]){
	Maze b = new Maze("data1.dat");
    }
}
