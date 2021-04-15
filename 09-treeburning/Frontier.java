import java.util.*;
import java.io.*;

public class Frontier {
    private static LinkedList<int[]> frontier;

    public Frontier(){
        frontier = new LinkedList<int[]>();
    }

    public static int size(){
        return frontier.size();
    }

    public static void add (int[]location){
        frontier.addFirst(location);
    }

    public static int[] remove(){
        return (frontier.removeLast());
    }
}
