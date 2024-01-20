package Matrix.SpiralMatrix;

public class SpiralMatrix {

    static int M;
    static int N;
    public static void main(String[] args) {
        int [][] matrix= {{7},{8},{9}};

      M=matrix.length;
      N=matrix[0].length;
      int [][] visited = new int [M][N];
      printSpiralMatrix(matrix,visited);
    }
    public static void printSpiralMatrix(int [][] matrix,int[][] visited){
        int u=0,d=M,l=-1,r=N;
        int row=0,col=0;
        boolean down=true;
        boolean right=true;
    
        while(row<d ||col<r && row >u  || col>l){
            while(col<r-1 ){
                if(visited[row][col]==0){
                    visited[row][col]=1;
                    System.out.println(matrix[row][col]);
                }
                col++;
            }
            
            r=r-1;
            while(row<d-1 ){
                if(visited[row][col]==0){
                    visited[row][col]=1;
                    System.out.println(matrix[row][col]);
                }
                row++;
            }
            d=d-1;
            
            while(col>l+1){
                if(visited[row][col]==0){
                    visited[row][col]=1;
                    System.out.println(matrix[row][col]);
                }
                col--;
            }
            
            l=l+1;
            while(row>u+1){
                if(visited[row][col]==0){
                    visited[row][col]=1;
                    System.out.println(matrix[row][col]);
                }
                row--;
            }
            u=u+1;

        }
        if(visited[row][col]==0){
                    visited[row][col]=1;
                    System.out.println(matrix[row][col]);
                }
    }
}
