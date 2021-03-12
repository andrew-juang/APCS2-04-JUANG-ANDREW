import java.util.*;
import java.io.*;

public class Quick {
    public static int partition(int[] data ,int lo, int hi){
        int pivot = findmedian(data[lo],data[hi],data[(lo+hi)/2]),pivotind=0;
        if(data[lo]==pivot)pivotind=lo;
        if(data[hi]==pivot)pivotind=hi;
        if(data[(lo+hi)/2]==pivot)pivotind=(lo+hi)/2;
        int temp = data[lo];
        data[lo] = data[pivotind];
        data[pivotind] = temp;
        int i = hi,j=lo+1,numequal=0;
        while(j<=i){
            if(data[j]==pivot){
                if(numequal%2==0){
                    temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                    i--;
                }
                numequal++;
            }
            if(data[j]>pivot){
                temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                i--;
            }
            if(data[j]<=pivot){
                j++;
            }
        }
        temp = data[i];
        data[i] = data[lo];
        data[lo] = temp;
        return i;
    }

    private static int findmedian(int a,int b, int c){
        if(a>=b&&a<=c||a>=c&&a<=b)return a;
        if(b>=c&&b<=a||b>=a&&b<=c)return b;
        if(c>=a&&c<=b||c>=b&&c<=a)return c;
        return 0;
    }

    /*return the value that is the kth smallest value of the array.
    *@param data must have a length > 0
    *@param k is 0 to data.length-1 inclusive
    *@postcondition The array can be modified. (If we did not want to modify the array, we could make a copy before we start the process)
    */
    public static int quickselect(int[] data, int k){
        return quickselect(data,0,data.length-1,k);
    }

    public static int quickselect(int[]data, int lo, int hi, int k){
        int partition = partition(data,lo,hi);
        if(partition == k){
            return data[partition];
        } else if (partition < k){
            return quickselect(data,partition+1,hi,k);
        } else {
            return quickselect(data,lo,partition-1,k);
        }
    }

    /*
    public static int[] partitionDutch(int[]data,int lo, int hi){
        //THIS IS OPTIONAL METHOD, it will make your quicksort faster.
        //return an int array: {lt,gt}
    }*/

    public static void quicksort(int[]data){
        quicksort(data,0,data.length-1);
    }

    public static void quicksort(int[]data,int lo, int hi){
        if(lo<hi){
            int partition = partition(data,lo,hi);
            quicksort(data,lo,partition-1);
            quicksort(data,partition+1,hi);
        }
    }

}
