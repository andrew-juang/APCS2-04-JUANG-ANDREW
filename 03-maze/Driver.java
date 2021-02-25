import java.util.*;
import java.io.*;

public class Driver{
    public static void main(String[]args){
        try {
            Maze f1,f2,f3;
            f1 = new Maze("data1.dat");
            f2 = new Maze("data2.dat");
            f3 = new Maze("data3.dat");
            System.out.println(f3.toString());
            f1.setAnimate(true);
            f2.setAnimate(true);
            f3.setAnimate(true);
            System.out.println(f1.solve());
            System.out.println(f2.solve());
            System.out.println(f3.solve());
            System.out.println(f3.toString());
        } catch (FileNotFoundException e){
            System.out.println("Invalid filename");
        }
    }
}
