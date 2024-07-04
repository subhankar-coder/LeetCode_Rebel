package DP.UniquepathsI;

public class UniquePaths {
    static int R;
    static int C;
    static int count=0;
    public static void main(String[] args) {
        int [][] obstacleGrid={{0,0,0},{0,1,0},{0,0,0}};
        R=obstacleGrid.length;
        C=obstacleGrid[0].length;
        getPaths(obstacleGrid, 0, 0);
        System.out.println(count);

    }
    public static void getPaths(int [][] grid,int row,int col){
        if(row==R-1 && col==C-1){
            count++;
            return;
        }
        if(row<0 || row>=R || col<0 || col>=C || grid[row][col]!=0)
            return;

        grid[row][col]=-1;
        getPaths(grid, row+1, col);
        getPaths(grid, row, col+1);
        grid[row][col]=0;

    }
    
}
