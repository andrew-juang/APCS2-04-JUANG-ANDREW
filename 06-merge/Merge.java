import java.util.*;
import java.io.*;

public class Merge {

    public static void mergesort (int[]data) {
        int temp[] = new int[data.length];
        for(int i=0;i<data.length;i++){
            temp[i]=data[i];
        }
        mergesort(data,temp,0,data.length-1);
    }

    public static void mergesort (int[]data,int[]temp, int lo, int hi) {
        int mid = lo + (hi-lo)/2;
        if(lo<hi){
            mergesort(temp,data,lo,mid);
            mergesort(temp,data,mid+1,hi);
            merge(data,temp,lo,hi);
        }
    }

    private static void merge(int[]data, int[]temp, int lo, int hi){
        //i,j iterate through the two halves, ind keeps track on index in temp arr
        int mid = lo + (hi-lo)/2,i=lo,j=mid+1,ind=lo;
        while(i<=mid&&j<=hi){
            if(temp[i]<=temp[j]){
                data[ind]=temp[i];
                i++;ind++;
            } else {
                data[ind]=temp[j];
                j++;ind++;
            }
        }
        while(i<=mid){
            data[ind]=temp[i];
            i++;ind++;
        }
        while(j<=hi){
            data[ind]=temp[j];
            j++;ind++;
        }
    }
}
