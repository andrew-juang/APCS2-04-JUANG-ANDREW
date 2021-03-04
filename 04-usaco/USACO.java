import java.util.*;
import java.io.*;

public class USACO {
    public static int bronze (String filename) throws FileNotFoundException {
        //read in input
        File f = new File(filename);
        Scanner s = new Scanner(f);
        int R=s.nextInt(),C=s.nextInt(),E=s.nextInt(),N=s.nextInt();
        int[][]lake = new int[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                lake[i][j]=s.nextInt();
            }
        }
        //process N instructions
        for(int I=0;I<N;I++){
            int R_s=s.nextInt(),C_s=s.nextInt(),D_s=s.nextInt(),mx=0;
            for(int i=R_s-1;i<R_s+2;i++){
                for(int j=C_s-1;j<C_s+2;j++){
                    mx = Math.max(mx,lake[i][j]);
                }
            }
            for(int i=R_s-1;i<R_s+2;i++){
                for(int j=C_s-1;j<C_s+2;j++){
                    lake[i][j] -= Math.max(0,D_s-(mx-lake[i][j]));
                }
            }
        }
        //find agg_depth and volume
        int agg_depth = 0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                agg_depth += Math.max(0,E-lake[i][j]);
            }
        }
        //return answer
        return agg_depth * 72 * 72;
    }

    /*public static int silver (String filename) {

    }*/
}
