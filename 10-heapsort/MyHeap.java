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

    public static void remove(int[]data,int size){
        if(size>0){
            int swap = data[0];
            data[0] = data[size-1];
            data[size-1] = swap;
        }
        pushDown(data,size-1,0);
    }

    public static void heapsort(int[]data){
        buildHeap(data);
        for(int i=data.length;i>=0;i--){
            remove(data,i);
        }
    }
}
