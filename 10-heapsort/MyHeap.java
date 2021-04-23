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

    private static void buildHeap(int[]data) {
        for(int i=(data.size/2)-1; i>=0; i--){
            pushDown(data,data.size,i);
        }
    }
}
