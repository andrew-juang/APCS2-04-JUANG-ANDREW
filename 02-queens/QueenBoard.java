import java.util.*;
public class QueenBoard {
    private int[][]board;

    private boolean addQueen(int r, int c){
        int i,j;
        boolean output = true;
        if(board[r][c]>0){
            output=false;
        }
        for(i=0;i<c;i++){
            if(board[r][i]==-1){
                output = false;
            }
        }
        for(i=r,j=c;i>=0&&j>=0;i--,j--){
            if(board[i][j]==-1){
                output = false;
            }
        }
        for(i=r,j=c;j>=0&&i<board.length;i++, j--){
            if(board[i][j]==-1){
                output = false;
            }
        }
        if(output){
            board[r][c]=-1;
            for(i=0;i<c;i++){
                board[r][i]++;
            }
            for(i=r-1,j=c-1;i>=0&&j>=0;i--,j--){
                board[i][j]++;
            }
            for(i=r+1,j=c-1;j>=0&&i<board.length;i++, j--){
                board[i][j]++;
            }
            return output;
        }
        return output;
    }

    private void removeQueen(int r, int c){
        int i,j;
        board[r][c]=0;
        for(i=0;i<c;i++){
            board[r][i]--;
        }
        for(i=r-1,j=c-1;i>=0&&j>=0;i--,j--){
            board[i][j]--;
        }
        for(i=r+1,j=c-1;j>=0&&i<board.length;i++, j--){
            board[i][j]--;
        }
    }

    public QueenBoard(int size){
        board = new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                board[i][j]=0;
            }
        }
    }

    public String toString(){
        String output = "";
        for(int i=0;i<board.length;i++){
            String curr = "";
            for(int j=0;j<board.length;j++){
                if(board[i][j]==-1){
                    curr += "Q";
                } else {
                    curr += "_";
                }
                if(j!=board.length-1){
                    curr += " ";
                }
            }
            output += curr + "\n";
        }
        return output;
    }

    public boolean solve(){
        for(int i=0;i<board.length;i++){
            if(board[i][0]!=0){
                throw new IllegalArgumentException();
            }
        }
        return solve(0);
    }

    public boolean solve(int col){
        if(col>=board.length){
            return true;
        } else {
            for(int row=0;row<board.length;row++){
                if(addQueen(row,col)){
                    if(solve(col+1))return true;
                    removeQueen(row,col);
                }
            }
        }
        return false;
    }

    public int countSolutions(){
        for(int i=0;i<board.length;i++){
            if(board[i][0]!=0){
                throw new IllegalArgumentException();
            }
        }
        return countSolutions(0);
    }

    public int countSolutions(int col){
        int ans = 0;
        if(col>=board.length){
            return 1;
        } else {
            for(int row=0;row<board.length;row++){
                if(addQueen(row,col)){
                    ans += countSolutions(col+1);
                    removeQueen(row,col);
                }
            }
        }
        return ans;
    }
}
