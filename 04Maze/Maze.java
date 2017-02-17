import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze{
    private char[][] maze;
    
    public Maze(){

    }


    public static void main(String args[]) throws FileNotFoundException {
        //instead of a try/catch, you can throw the FileNotFoundException.
        File infile = new File("Maze1.txt");// can be a path"/full/path/to/file.txt" 
        Scanner inf = new Scanner(infile);
        int lineNumber = 1;
        while(inf.hasNextLine()){
            String line = inf.nextLine();
            System.out.println(line);
        }       
    }
   
}
