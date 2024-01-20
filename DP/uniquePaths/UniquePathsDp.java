package DP.uniquePaths;

public class UniquePathsDp {
    public static void main(String[] args) {
        int [][] obstacleGrid={{0,0,0},{0,1,0},{0,0,0}};
        int r=obstacleGrid.length;
        int c=obstacleGrid[0].length;
        int [][] graph = new int [r][c];
        for(int i=0;i<r;i++){
            if(obstacleGrid[i][0]==1)
                break;
            graph[i][0]=1;
        }
        for(int j=0;j<c;j++){
            if(obstacleGrid[0][j]==1)
                break;
            graph[0][j]=1;
        }
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(obstacleGrid[i][j]!=1){
                    int above=0;
                    int left=0;
                    if(i-1 >=0 && graph[i-1][j]!=0){
                        above=graph[i-1][j];
                    }
                    if(j-1>=0 && graph[i][j-1]!=0){
                        left=graph[i][j-1];
                    }
                    
                    graph[i][j]=above+left;
                    
                }
            }
        }
        System.out.println(graph[r-1][c-1]);
    }
    
}
