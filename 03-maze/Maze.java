import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate;

    public Maze(String filename) throws FileNotFoundException{
        ArrayList<String> lines = new ArrayList<String>();
        File f = new File(filename);
        Scanner s = new Scanner(f);
        while(s.hasNextLine()){
            String line = s.nextLine();
            lines.add(line);
        }
        maze = new char[lines.size()][lines.get(0).length()];
        for(int i=0;i<lines.size();i++){
            for(int j=0;j<lines.get(0).length();j++){
                maze[i][j]=lines.get(i).charAt(j);
            }
        }
        animate = false;
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

    public static void clearTerminal(){
        //erase terminal
        System.out.println("\033[2J");
    }
    public static void gotoTop(){
        //go to top left of screen
        System.out.println("\033[1;1H");
    }

    /*Return the string that represents the maze.
    It should look like the text file with some characters replaced.
    */
    public String toString(){
        String val = "";
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                val += maze[i][j];
            }
            if(i!=maze.length-1)val += "\n";
        }
        return val;
    }

    /*Wrapper Solve Function returns the helper function
    Note the helper function has the same name, but different parameters.
    Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public int solve(){
        //only clear the terminal if you are running animation
        if(animate){
            clearTerminal();
        }
        //start solving at the location of the s.
        //return solve(???,???);
        return 0;
    }

    /*
    Recursive Solve function:

    A solved maze has a path marked with '@' from S to E.

    Returns the number of @ symbols from S to E when the maze is solved,
    Returns -1 when the maze has no solution.

    Postcondition:
    The S and 'E' remain the same.
    All visited spots that were not part of the solution are changed to '.'
    All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col){ //you can add more parameters since this is private
        //automatic animation! You are welcome.
        if(animate){
            gotoTop();
            System.out.println(this);
            wait(50);
        }

        //COMPLETE SOLVE
        return -1; //so it compiles
    }
}
