import java.util.*;
import java.io.*;

public class Frontier {
    private LinkedList<int[]> frontier;

    public Frontier(){
        frontier = new LinkedList<int[]>();
    }

    public int size(){
        return frontier.size();
    }

    public void add (int[]location){
        frontier.addFirst(location);
    }

    public int[] remove(){
        return (frontier.removeLast());
    }
}
