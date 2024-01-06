package DP.MinSumPath;

import java.util.Arrays;

public class MinPathSumDP {

    static int R;
    static int C;
    public static void main(String[] args) {
        int [][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        R=grid.length;
        C=grid[0].length;
        int [][] board=new int[R][C];
        for(int arr[]: board){
            Arrays.fill(arr, -1);
        }
        int seed=0;
        for(int i=0;i<C;i++){
            seed+=grid[0][i];
            board[0][i]=seed;
        }
        seed=0;
        for(int i=0;i<R;i++){
            seed+=grid[i][0];
            board[i][0]=seed;
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(board[i][j]==-1){
                    board[i][j]=Math.min(board[i-1][j],board[i][j-1])+grid[i][j];
                }
            }
        }
        System.out.println(board[R-1][C-1]);
    }
    
}
