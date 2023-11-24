package BackTracking.SudokuSolver;

import java.util.*;
public class SudokuSolver {

    private static final int N = 9;
    public static void main(String[] args) {
        
        int [][] sudoku= { {3, 0, 6, 5, 0, 8, 4, 0, 0},
        {5, 2, 0, 0, 0, 0, 0, 0, 0},
        {0, 8, 7, 0, 0, 0, 0, 3, 1},
        {0, 0, 3, 0, 1, 0, 0, 8, 0},
        {9, 0, 0, 8, 6, 3, 0, 0, 5},
        {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
        {1, 3, 0, 0, 0, 0, 2, 5, 0},
        {0, 0, 0, 0, 0, 0, 0, 7, 4},
        {0, 0, 5, 2, 0, 6, 3, 0, 0} };
        solve(sudoku);
        for(int []arr:sudoku){
            System.out.println(Arrays.toString(arr));
        }
    }
    public static boolean isSafe(int [][] sudoku,int row,int col,int num){
        for(int []arr:sudoku){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();

        if(row>=N || row<0 || col>=N || col<0)
            return false;
        //in a row 
        for(int i=0;i<N;i++){
            if(sudoku[row][i]==num)
                return false;
        }
        //in a col 
        for(int i=0;i<N;i++){
            if(sudoku[i][col]==num)
                return false;
        }
        //in the grid
        int boxStartRow = row-row%3;
        int boxStartCol= col -col%3;
        for(int i=boxStartRow;i<boxStartRow+3;i++){
            for(int j=boxStartCol;j<boxStartCol+3;j++){
                if(sudoku[i][j]==num)
                    return false;
            }
        }

        return true;
    }

    public static boolean solve(int [][] sudoku){
        int row=-1,col=-1;
        boolean isFilled=true;  
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(sudoku[i][j]==0){
                    row=i;
                    col=j;
                    isFilled=false;
                    break;
                }
            }
            if(!isFilled)
                    break;
        }
                if(isFilled){
                    return true;
                }
                
                for(int num=1;num<=N;num++){
                    if(isSafe(sudoku,row,col,num)){
                        sudoku[row][col]=num;
                        if(solve(sudoku)){
                            return true;
                        }else{
                            sudoku[row][col]=0;
                        }
                    }

                }

        return false;
    }

}
