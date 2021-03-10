import java.util.*;
import java.io.*;

public class Preliminary {
      public static int partition (int[] data, int start, int end){
          //find random pivot point
          Random rand = new Random();
          int randind = rand.nextInt((end-start)+1)+start;
          int pivot = data[randind];
          System.out.println(pivot);
          //swap pivot to front
          int temp = data[start];
          data[start] = data[randind];
          data[randind] = temp;

          int i = end,j=start+1;
          while(j<=i){
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
          //move pivot back
          temp = data[i];
          data[i] = data[start];
          data[start] = temp;
          //return
          return i;
      }
}
