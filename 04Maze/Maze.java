import java.io.*;
import java.util.*;

public class Maze{
    private char[][] maze;
    private int row = 0;
    private int col = 0;
    private String file = "";
    
    public Maze(String fileName){
	scanFile(fileName);
	//System.out.println(file);
	//System.out.println(row);
	//System.out.println(col);
	initializeMaze();
    }

    private void scanFile(String fileName){
	try{
	    Scanner inf = new Scanner(new File(fileName));
	    while(inf.hasNextLine()){
		row++;
		file += inf.nextLine() + "\n";
	    }
	    col = file.length() / row - 1;
	}catch(FileNotFoundException e){
	    System.out.println("File is not found.");
	}
    }
    
    private void initializeMaze(){
	int x = 0;
	maze = new char[row][col];
	for(int i = 0; i < row; i++){
	    for(int j = 0; j < col; j++){
		maze[i][j] = file.charAt(x);
		x++;
	    }
	}
    }

    public String toString(){
	String temp = "";
	for(int i = 0; i < row; i++){
	    for(int j = 0; j < col; j++){
		temp += maze[i][j];
	    }
	}
	return temp;
    }

    public static void main(String args[]){
	Maze b = new Maze("data1.dat");
	Maze c = new Maze("data2.dat");
	Maze d = new Maze("data3.dat");
	System.out.println(b);
	System.out.println(c);
	System.out.println(d);
    }
}
