import java.util.*;
import java.io.*;

public class Quick {
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

    public static int[] partitionDutch(int[]data,int lo, int hi){
        Random rand = new Random();
        int randind = rand.nextInt((hi-lo)+1)+lo;
        int pivot = data[randind];
        int temp = data[hi];
        data[hi] = data[randind];
        data[randind] = temp;
        int mid = lo;
        int[]indices = new int[2];
        while(mid<=hi){
            if(data[mid]<pivot){
                temp = data[lo];
                data[lo]=data[mid];
                data[mid]=temp;
                lo++; mid++;
            } else if(data[mid]>pivot){
                temp=data[mid];
                data[mid]=data[hi];
                data[hi]=temp;
                hi--;
            } else {
                mid++;
            }
            indices[0]=lo-1; indices[1]=mid;
        }
        return indices;
    }

    public static void quicksort(int[]data){
        quicksort(data,0,data.length-1);
    }

    public static void quicksort(int[]data,int lo, int hi){
        if(hi-lo==1){
            if (data[lo] > data[hi]) {
                int temp=data[lo];
                data[lo]=data[hi];
                data[hi]=temp;
            }
            return;
        }
        if(lo<hi){
            int[]indices = new int[2];
            indices = partitionDutch(data,lo,hi);
            quicksort(data,lo,indices[0]);
            quicksort(data,indices[1],hi);
        }
    }

    public static int partition(int[] data ,int lo, int hi){
        Random rand = new Random();
        int randind = rand.nextInt((hi-lo)+1)+lo;
        int pivot = data[randind];
        int temp = data[lo];
        data[lo] = data[randind];
        data[randind] = temp;
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

    public static void regquicksort(int[]data){
        quicksort(data,0,data.length-1);
    }

    public static void regquicksort(int[]data,int lo, int hi){
        if(lo<hi){
            int partition = partition(data,lo,hi);
            quicksort(data,lo,partition-1);
            quicksort(data,partition+1,hi);
        }
    }

}
