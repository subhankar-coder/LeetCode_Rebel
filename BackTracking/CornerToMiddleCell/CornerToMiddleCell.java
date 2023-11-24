package BackTracking.CornerToMiddleCell;

public class CornerToMiddleCell {
    static int N;
    static int M;
    public static void main(String[] args) {
        int maze [][]={
            { 3, 5, 4, 4, 7, 3, 4, 6, 3 },
            { 6, 7, 5, 6, 6, 2, 6, 6, 2 },
            { 3, 3, 4, 3, 2, 5, 4, 7, 2 },
            { 6, 5, 5, 1, 2, 3, 6, 5, 6 },
            { 3, 3, 4, 3, 0, 1, 4, 3, 4 },
            { 3, 5, 4, 3, 2, 2, 3, 3, 5 },
            { 3, 5, 4, 3, 2, 6, 4, 4, 3 },
            { 3, 5, 1, 3, 7, 5, 3, 6, 4 },
            { 6, 2, 4, 3, 4, 5, 4, 5, 1 }
        };
        N=maze.length;
        M=maze[0].length;
        int midRow=N/2;
        int midCol=M/2;
        solve(maze, midRow, midCol, 0, 0,"");
    }
    public static void solve(int [][] maze,int midRow,int midCol,int sRow,int sCol,String res){
        if(sRow==midRow &&  sCol==midCol){
            System.out.println("mid Reached "+ res);
            return ;
        }
        if(sRow>=N || sRow<0 || sCol>=M || sCol<0 || maze[sRow][sCol]==0){
            return ;
        }
        int val = maze[sRow][sCol];
        maze[sRow][sCol]=0;
        
        //north wise
        solve(maze,midRow,midCol,sRow-val,sCol,res+" "+sRow+" "+sCol+" => ");
        //west wise
        solve(maze,midRow,midCol,sRow,sCol+val,res+" "+sRow+" "+sCol+" => ");
        //southwise
        solve(maze, midRow, midCol, sRow+val, sCol,res+" "+sRow+" "+sCol+" => ");
        //east wise
        solve(maze, midRow, midCol, sRow, sCol-val,res+" "+sRow+" "+sCol+" => ");

        maze[sRow][sCol]=val;
    }
    
}
