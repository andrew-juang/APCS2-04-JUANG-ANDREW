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

    public int solve(){
        if(animate){
            clearTerminal();
        }
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                if(maze[i][j]=='S'){
                    maze[i][j]='@';
                    return solve(i,j,0);
                }
            }
        }
        return 0;
    }

    private int solve(int row, int col, int cnt){
        if(animate){
            gotoTop();
            System.out.println(this);
            wait(50);
        }
        if(maze[row-1][col]=='E'||maze[row+1][col]=='E'||maze[row][col+1]=='E'||maze[row][col-1]=='E'){
            return cnt+1;
        } else {
            if(maze[row-1][col]==' '){
                maze[row-1][col]='@';
                return solve(row-1,col,cnt+1);
            } else if(maze[row+1][col]==' '){
                maze[row+1][col]='@';
                return solve(row+1,col,cnt+1);
            } else if(maze[row][col+1]==' '){
                maze[row][col+1]='@';
                return solve(row,col+1,cnt+1);
            } else if(maze[row][col-1]==' '){
                maze[row][col-1]='@';
                return solve(row,col-1,cnt+1);
            } else {
                maze[row][col]='.';
                if(maze[row-1][col]=='@'){
                    return solve(row-1,col,cnt-1);
                } else if(maze[row+1][col]=='@'){
                    return solve(row+1,col,cnt-1);
                } else if(maze[row][col+1]=='@'){
                    return solve(row,col+1,cnt-1);
                } else if(maze[row][col-1]=='@'){
                    return solve(row,col-1,cnt-1);
                }
            }
        }
        return -1;
    }
}
