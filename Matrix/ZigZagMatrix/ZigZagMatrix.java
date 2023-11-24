package Matrix.ZigZagMatrix;
import java.util.*;

public class ZigZagMatrix{
    static int M=3;
    static int N=1;
    public static void main(String[] args) {
        int [][] matrix={{6},{9},{7}};
        List<Integer> res=new ArrayList<>();
        printMatrix(matrix, 0, 0, false,res);
        System.out.println(res);
    }
    public static void printMatrix(int [][] matrix,int row,int col,boolean up,List<Integer> res){

        while(row<=M-1 || col<=N-1){
            if(row==M-1 && col == N-1)
                break;
            if(up){
                if(row==M-1){
                    if(res.contains(matrix[row-1][col+1])){

                        col++;
                        res.add(matrix[row][col]);
                    }
                    if(col==N-1)
                        break;
                }
                if(row-1>=0 && col+1<N){
                row--;
                col++;
                
                res.add(matrix[row][col]);}
                if(col==N-1){
                    row++;
                    res.add(matrix[row][col]);
                    up=!up;
                }
                if(row==0)
                    up=!up;
            }else{
                if(row==0){
                    if(col+1<N){

                        col++;
                        res.add(matrix[row][col]);
                        if(row==M-1 && col==N-1){
                            break;
                        }
                    }
                }
                if(row+1<M && col-1>=0){
                row++;
                col--;
                res.add(matrix[row][col]);}
                if(col==0){
                    
                    if(row+1<M){

                        row++;
                        res.add(matrix[row][col]);
                    }
                    
                    up=!up;
                }else if(row !=0 && row==M-1)
                    up=!up;

            }
        }
    }  

}