package NumberOfIslands;

public class NumberOfIslands {

    public static int R;
    public static int C;

    static int [][] isVisited;
    public static void main(String[] args) {
        // char [][]grid = {
        //         {'1','1','1','1','0'},
        //         {'1','1','0','1','0'},
        //         {'1','1','0','0','0'},
        //         {'0','0','0','0','0'}
        //     };

        char [][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        
        R = grid.length;
        C=grid[0].length;
        isVisited= new int [R][C];

        int count =0;

        for (int i=0;i<R;i++){
            for (int j=0;j<C;j++){
                if(grid[i][j]=='1' && isVisited[i][j]==0){
                    searchIslands(grid, i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static void searchIslands(char [][] graph,int r,int c){
        if(r>=R || r<0 || c>=C || c<0)
            return;

        if(isVisited[r][c]!=1 && isSafe(graph, r, c)){
            isVisited[r][c]=1;
            searchIslands(graph, r, c+1);
            searchIslands(graph, r+1, c);
            searchIslands(graph, r-1, c);
            searchIslands(graph, r, c-1);
        }
        
        
    }
    public static boolean isSafe(char [][] graph,int r,int c){
        if(r>=R || r<0 || c>=C || c<0)
            return false;
        if(graph[r][c]=='0')
            return false;
        return true;

    }
    
}
