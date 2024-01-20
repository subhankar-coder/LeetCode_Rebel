package BackTracking.RateInTheMaze;

import java.util.Arrays;

public class RateInTheMaze {

    private static final int N=4;
    private static int solution[][];
    private static int row=0;
    private static int col=0;
    public static void main(String[] args) {
        int [][] maze = {{1, 0, 0, 0},
        {1, 1, 0, 1}, 
        {1, 1, 0, 0},
        {0, 1, 1, 1}};
        solution= new int[N][N];
        solution[row][col]=1;
        getPath(maze,row,col,"");
    }
    public static void getPath(int [][] maze,int i,int j,String res){

        if(i>=N || j>=N || i<0 || j<0 || maze[i][j]==0)
            return;
        if(i==N-1 && j==N-1){
            System.out.println(res);
            return;
        }
            

        maze[i][j]=0;
            
        getPath(maze,i-1,j,res+"U");
        
    
        getPath(maze,i,j+1,res+"R");
        
        getPath(maze,i+1,j,res+"D");
        

        getPath(maze,i,j-1,res+"L");
        maze[i][j]=1;
        
        return;
    }

}
