package BackTracking.TheKnightProblem;

import java.util.Arrays;

public class TheKnight {

    private final static int N=8;
    private static int count =0;
    private static int limit  = N*N -1;
    public static void main(String[] args) {
        int [][] solution = new int [N][N];
        int i=0;
        int j=0;
        solution[i][j]=-1;
        knightTour(solution,0,0);
        solution[i][j]=0;
        for (int[] ints : solution) {
            System.out.println(Arrays.toString(ints));
        }
        
        
    }
    public static void knightTour(int [][] solution,int i,int j){
        if(count >=limit )
            return;
        if(i>=N || i<0)
            return;
        if(j>=N || j<0)
            return;
        // System.out.println(i+" "+j+" "+count);
        if(i+2 <N && j+1 <N && solution[i+2][j+1]==0){
            solution[i+2][j+1]=++count;
            knightTour(solution,i+2,j+1);
        }
        if(i+2<N && j-1 >=0 && solution[i+2][j-1]==0){
            solution[i+2][j-1]=++count;
            knightTour(solution,i+2,j-1);
        }
        if(i-2 >=0 && j+1 <N && solution[i-2][j+1]==0){
            solution[i-2][j+1]=++count;
            knightTour(solution,i-2,j+1);
        }
        if(i-2>=0 && j-1 >=0 && solution[i-2][j-1]==0){
            solution[i-2][j-1]=++count;
            knightTour(solution,i-2,j-1);
        }
        if( i+1<N && j+2<N && solution[i+1][j+2]==0){
            solution[i+1][j+2]=++count;
            knightTour(solution,i+1,j+2);
        }
        if(i-1>=0 && j+2<N && solution[i-1][j+2]==0){
            solution[i-1][j+2]=++count;
            knightTour(solution,i-1,j+2);
        }

       if( i+1<N && j-2>=0 && solution[i+1][j-2]==0){
            solution[i+1][j-2]=++count;
            knightTour(solution,i+1,j-2);
        }
        if(i-1>=0 && j-2>=0 && solution[i-1][j-2]==0){
            solution[i-1][j-2]=++count;
            knightTour(solution,i-1,j-2);
        }
    }
}
