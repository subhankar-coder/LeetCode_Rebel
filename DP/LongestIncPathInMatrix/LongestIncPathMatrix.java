package DP.LongestIncPathInMatrix;

public class LongestIncPathMatrix {

    static int R;
    static int C;
    static int [][] dp;
    public static void main(String[] args) {
        int [][] matrix = {{7,7,5},{2,4,6},{8,2,0}}; 
        R= matrix.length;
        C = matrix[0].length;
        int result =1;

        int [][] visited=new int[R][C];
        dp = new int [R][C];
        
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                result=Math.max(result,solve(matrix, i, j,  visited));
            }
        }

        System.out.println(result);
    }

    public static int solve(int [][] matrix ,int r,int c ,int [][] visited){
        if(r>=R || r<0 || c>=C || c<0 || visited[r][c]==1)
            return 0;

        if(dp[r][c]!=0)
            return dp[r][c];
        visited[r][c]=1;
        int res=1;
        //down direction
        if(isSafe(matrix, r+1, c, visited, matrix[r][c])){
            res=Math.max(res,1+solve(matrix, r+1, c, visited));
            
            //up direction
        }
        if( isSafe(matrix, r-1, c, visited, matrix[r][c])){
            res=Math.max(res,1+solve(matrix, r-1, c, visited));
            
            //right direction
        }
        if (isSafe(matrix, r, c+1, visited, matrix[r][c])){
            res=Math.max(res,1+solve(matrix, r, c+1, visited));
            
            //left direction
        }
        if(isSafe(matrix, r, c-1, visited, matrix[r][c])){
            res=Math.max(res,1+solve(matrix, r, c-1, visited));
        }
         dp[r][c]=res;
        visited[r][c]=0;
        System.out.println("r "+r+" c "+c+" res " + res);
        return res;
    }

    public static boolean isSafe(int [][] matrix ,int r,int c,int[][] visited,int val){
        if(r>=R || r<0 || c>=C || c<0 || visited[r][c]==1)
            return false;
        if(val>=matrix[r][c])
            return false;
        return true;
    }
}   


