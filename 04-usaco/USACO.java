import java.util.*;
import java.io.*;

public class USACO {

    private static long[][][]pasture = new long[20][150][150];

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

    public static long silver (String filename) throws FileNotFoundException {
        //read in input
        File f = new File(filename);
        Scanner s = new Scanner(f);
        int N=s.nextInt(),M=s.nextInt(),T=s.nextInt();
        for(int i=0;i<N;i++){
            String line = s.next();
            for(int j=0;j<M;j++){
                if(line.charAt(j)=='.')pasture[0][i][j]=0;
                if(line.charAt(j)=='*')pasture[0][i][j]=-1;
            }
        }
        int R1=s.nextInt(),C1=s.nextInt(),R2=s.nextInt(),C2=s.nextInt();
        //set starting location as 1
        pasture[0][R1-1][C1-1] = 1;
        //iterate through number of seconds
        for(int i=1;i<=T;i++){
            nextPasture(i,N,M);
        }
        return pasture[T][R2-1][C2-1];
    }

    private static void nextPasture(int step,int N, int M) {
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(pasture[step-1][i][j]==-1){
                    pasture[step][i][j]=-1;
                    continue;
                }
                if(i>0)pasture[step][i][j]+=Math.max(0,pasture[step-1][i-1][j]);
                if(j>0)pasture[step][i][j]+=Math.max(0,pasture[step-1][i][j-1]);
                pasture[step][i][j]+=Math.max(0,pasture[step-1][i+1][j]);
                pasture[step][i][j]+=Math.max(0,pasture[step-1][i][j+1]);
            }
        }
    }
}
