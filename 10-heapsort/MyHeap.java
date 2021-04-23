import java.util.*;
import java.io.*;

public class MyHeap {
    private static void pushDown(int[]data, int size, int index) {
        int l = 2*index+1;
        int r = 2*index+2;
        int big = index;
        if(l<size&&data[l]>data[big]){
            big = l;
        }
        if(r<size&&data[r]>data[big]){
            big = r;
        }
        if(big!=index){
            int swap = data[index];
            data[index] = data[big];
            data[big] = swap;
            pushDown(data,size,big);
        }
    }

    /*Reorder the provided array to be a valid heap.
    *@param data is the array to be modified
    */
    private static void buildHeap(int[]data)//We will discuss this today:
}
