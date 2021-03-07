import java.util.*;
import java.io.*;

public class Driver {
    public static void main (String[]args) {
        try {
            int ans = USACO.bronze("lake1.input");
            int ans2 = USACO.bronze("lake2.input");
            int ans3 = USACO.bronze("lake3.input");
            System.out.println(ans);
            System.out.println(ans2);
            System.out.println(ans3);

            long ans4 = USACO.silver("cowPath1.input");
            long ans5 = USACO.silver("cowPath2.input");
            long ans6 = USACO.silver("cowPath3.input");
            System.out.println(ans4);
            System.out.println(ans5);
            System.out.println(ans6);
        } catch (FileNotFoundException e){
            System.out.println("File not found.");
        }
    }
}
