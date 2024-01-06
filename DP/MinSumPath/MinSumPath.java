package DP.MinSumPath;

public class MinSumPath {
    static int min=Integer.MAX_VALUE;
    static int R;
    static int C;
    public static void main(String[] args) {
        int [][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        R=grid.length;
        C=grid[0].length;
        getMinSumPath(grid, 0, 0, 0);
        System.out.println(min);
    }
    public static void getMinSumPath(int [][] grid,int row,int col,int sum){

        if(row>=R || row<0 || col>=C || col<0 || grid[row][col]==-1)
            return ;        
        
        if(row==R-1 && col==C-1){
            min=Math.min(min,sum+grid[row][col]);
            return;
        }
        int ele=grid[row][col];
        
        grid[row][col]=-1;

        getMinSumPath(grid, row+1, col, sum+ele);
        getMinSumPath(grid, row, col+1, sum+ele);
        getMinSumPath(grid, row-1, col, sum+ele);
        getMinSumPath(grid, row, col-1, sum+ele);

        grid[row][col]=ele;

    }
    
}
