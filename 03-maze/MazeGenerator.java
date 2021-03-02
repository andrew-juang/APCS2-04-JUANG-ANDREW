import java.util.*;
import java.io.*;

public class MazeGenerator {
    public static void generate(char[][]maze,int rows,int cols,int cr,int cc) {
        maze[cr][cc] = 'S';
        generate(maze,cr,cc);
        boolean bool = true;
        for(int i=maze.length-1;i>=0&&bool;i--){
            for(int j=maze[0].length-1;j>=0&&bool;j--){
                if(maze[i][j]==' '){
                    maze[i][j] = 'E';
                    bool = false;
                }
            }
        }
    }

    public static void generate(char[][]maze,int cr,int cc){
        String[] letters = {"N","S","E","W"};
        List<String> dir = Arrays.asList(letters);
        Collections.shuffle(dir);
        if(maze[cr][cc]!='S'){
            maze[cr][cc]=' ';
        }
        for(int i=0;i<4;i++){
            int nr=cr, nc=cc;
            if(dir.get(i)=="N"){
                nr -= 1;
            }
            if(dir.get(i)=="S"){
                nr += 1;
            }
            if(dir.get(i)=="E"){
                nc += 1;
            }
            if(dir.get(i)=="W"){
                nc -= 1;
            }
            if(nr>0&&nr<maze.length-1&&nc>0&&nc<maze[0].length-1&&count_neb(maze,nr,nc)<2){
                generate(maze,nr,nc);
            }
        }
        return;
    }

    private static int count_neb(char[][]maze,int row,int col){
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        int cnt = 0;
        for(int i=0;i<4;i++){
            if(row+dx[i]>0&&row+dx[i]+1<maze.length&&col+dy[i]>0&&col+dy[i]+1<maze[0].length){
                if(maze[row+dx[i]][col+dy[i]]==' '){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
