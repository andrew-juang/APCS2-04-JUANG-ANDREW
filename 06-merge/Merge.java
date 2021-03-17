import java.util.*;
import java.io.*;

public class Merge {

    public static void mergesort (int[]data) {
        int temp[] = new int[data.length-1];
        mergesort(data,temp,0,data.length-1);
    }

    public static void mergesort (int[]data,int[]temp, int lo, int hi) {
        int mid = lo + (hi-lo)/2;
        if(lo<hi){
            mergesort(data,temp,lo,mid);
            mergesort(data,temp,mid+1,hi);
            merge(data,lo,hi);
        }
    }

    private static void merge(int[]data, int lo, int hi){
        //i,j iterate through the two halves, ind keeps track on index in temp arr
        int mid = lo + (hi-lo)/2,i=lo,j=mid+1,ind=0;
        int temp[] = new int[hi-lo+1];
        while(i<=mid&&j<=hi){
            if(data[i]<=data[j]){
                temp[ind]=data[i];
                i++;ind++;
            } else {
                temp[ind]=data[j];
                j++;ind++;
            }
        }
        while(i<=mid){
            temp[ind]=data[i];
            i++;ind++;
        }
        while(j<=hi){
            temp[ind]=data[j];
            j++;ind++;
        }
        for(i=0;i<hi-lo+1;i++){
            data[i+lo]=temp[i];
        }
    }
}
