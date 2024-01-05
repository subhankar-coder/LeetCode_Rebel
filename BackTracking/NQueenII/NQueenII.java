package BackTracking.NQueenII;

public class NQueenII {

    static int N=5;
    public static void main(String[] args) {
        int [][] board=new int[N][N];
       nQueen(board, 0, 0);
       // printBoard(board);

    }
    public static void nQueen(int [][] board,int row,int col){
        if(row==N){
            printBoard(board);
            return ;
        }
        if(isSafe(board, row, col)){
            board[row][col]=1;
            nQueen(board, row+1, 0);
            board[row][col]=0;
        }
        if(row>=0 && row<N && col>=0 && col<N && board[row][col]!=1)
            nQueen(board, row, col+1);
        
        return ;
    }
    public static boolean isSafe(int[][] board,int row,int col){
        if(row<0 || row>=N || col<0 || col>=N)
            return false;

        //colwise
        for(int i=0;i<N;i++){
            if(i!=row && board[i][col]==1)
                return false;
        }

        //row wise

        for(int j=0;j<N;j++){
            if(j!=col && board[row][j]==1)
                return false;
        }

        //left up diagonal
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]==1)
                return false;
        }

        //left down diagonal

        for(int i=row,j=col; i<N && j>=0;i++,j--){
            if(board[i][j]==1)
                return false;
        }

        //right up diagonal
        for(int i=row,j=col ;i>=0 && j<N ;i--,j++){
            if(board[i][j]==1)
                return false;
        }

        //right down diagonal
        for(int i=row,j=col;i<N && j<N ;i++,j++){
            if(board[i][j]==1)
                return false;
        } 
        return true;
    }
    public static void printBoard(int [][] board){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
} 