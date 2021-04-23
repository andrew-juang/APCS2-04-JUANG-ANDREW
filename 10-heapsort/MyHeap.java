import java.util.*;
import java.io.*;

public class MyHeap {
    public static void pushDown(int[]data, int size, int index) {
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

    public static void buildHeap(int[]data) {
        for(int i=(data.length/2)-1; i>=0; i--){
            pushDown(data,data.length,i);
        }
    }

    /*Swap the root node with the element at the provided index.
    *Then push the new root down, but not past the index that it swapped with.
    *@precondition: size is between 0 and data.length inclusive.
    */
    private static void remove(int[]data,int size){
        int swap = data[0];
        data[0] = data[data.length-1];
        data[data.length-1] = swap;
        for(int i=((data.length-1)/2)-1; i>=0; i--){
            pushDown(data,data.length-1,i);
        }
    }

    /*Sort the provided array
    *@param data is the array to be sorted
    */
    public static void heapsort(int[]data)//We will discuss this next time!:
}
