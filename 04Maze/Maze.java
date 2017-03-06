import java.io.*;
import java.util.*;

public class Maze{
    private char[][] maze;
    private int row = 0;
    private int col = 0;
    private int startr = -1;
    private int startc = -1;
    private String file = "";
    private boolean animate;
    private boolean valid;
    
    public Maze(String fileName){
	animate = false;
	scanFile(fileName);
	initializeMaze();
    }

    private void scanFile(String fileName){
	try{
	    Scanner inf = new Scanner(new File(fileName));
	    while(inf.hasNextLine()){
		row++;
		file += inf.nextLine();
	    }
	    col = file.length() / row;
	}catch(FileNotFoundException e){
	    System.out.println("File is not found.");
	}
    }
    
    private void initializeMaze(){
	int x = 0;
	int valid = 0;
	maze = new char[row][col];
	for(int i = 0; i < row; i++){
	    for(int j = 0; j < col; j++){
		if(file.charAt(x) == 'S'){
		    startr = i;
		    startc = j;
		    valid++;
		}
		if(file.charAt(x) == 'E'){
		    valid++;
		}
		maze[i][j] = file.charAt(x);
		x++;
	    }
	}
	if(valid == 2){
	    this.valid = true;
	}else{
	    this.valid = false;
	}
    }

    public boolean solve(){
	if(!valid){
	    System.out.println("This maze lack 'S' or 'E'");
	    return false;
	}else{
	    maze[startr][startc] = ' ';
	    return solve(startr, startc);
	}
    }

    private boolean solve(int row, int col){
	if(animate){
	    System.out.println("\033[2J\033[1;1H" + this);
	    wait(30);
	}
	if(maze[row][col] == 'E'){
	    return true;
	}
	if(maze[row][col] != ' '){
	    return false;
	}
	maze[row][col] = '@';
	if(solve(row, col + 1) ||
	   solve(row, col - 1) ||
	   solve(row - 1, col) ||
	   solve(row + 1, col)){
	    return true;
	}
	maze[row][col] = '.';
	return false;
    }
    
    private void wait(int millis){
	try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
    }

    public void setAnimate(boolean b){
	animate = b;
    }

    public void clearTerminal(){
	System.out.println("\033[2J\033[1;1H");
    }
    
    public String toString(){
	String temp = "";
	for(int i = 0; i < row; i++){
	    for(int j = 0; j < col; j++){
		temp += maze[i][j];
	    }
	    temp += "\n";
	}
	return temp;
    }
}
