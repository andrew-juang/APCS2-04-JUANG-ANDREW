import java.util.*;
import java.io.*;

public class Driver {
    public static void main (String[]args) {
        try {
            int ans = USACO.bronze("lake1.input");
            System.out.println(ans);
        } catch (FileNotFoundException e){
            System.out.println("File not found.");
        }
    }
}
