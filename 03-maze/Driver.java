import java.util.*;
import java.io.*;

public class Driver{
    public static void main(String[]args){
        String filename = "Maze1.txt";
        try {
            Maze f;
            f = new Maze(filename);
            f.setAnimate(true);
            System.out.println(f.toString());
        } catch (FileNotFoundException e){
            System.out.println("Invalid filename: "+filename);
        }
    }
}
