public class QueenBoard {
    private int[][]board;

    private boolean addQueen(int r, int c){
        for(int i=0;i<c;i++){
            if(board[r][i]==-1){
                return false;
            }
        }
        for(int i=r,int j=c;i>=0&&j>=0;i--,j--){
            if(board[i][j]==-1){
                return false;
            }
        }
        for(int i=r,int j=c;j>=0&&i<board.length;i++, j--){
            if(board[i][j]==-1){
                return false;
            }
        }
        return true;
    }

    private void removeQueen(int r, int c){
        board[r][c]=0;
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
                if(board[i][j]!=-1){
                    curr += "_";
                } else {
                    curr += "Q";
                }
            }
            output = output + curr + "\n";
        }
        return output;
    }

    public boolean solve(){
        if()
        return true;
    }

    public int countSolutions(){
        return 0;
    }
}
