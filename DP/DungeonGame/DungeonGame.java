/*
 *We need to check the min intial cost we need to reach from  (0,0) to (n-1,n-1) for a 2d matrix, consisting of both +ve and -ve. At any Point if 
 * the cost becomes 0 we can not move further. This is a variation of the minCost problem .
 * 
 * To solve it we need to come form (n-1,n-1) cell to (0,0). 
 *  
 *  we will populate the lastRow and lastCol to start with
 * 
 * for the lastRow and lastCol ---> the element at i would be the min of the sum of the i-1 and i with the current element i
 * if the element is greater than 0 we will put it as 0
 * 
 *  variying the col form i=C-1 to 0
 *  so, dungeon[R][col]=min(0, min(dungeon[R][col],dungeon[R][col]+dungeon[R][col+1])) 
 * 
 *  same logic applies for the the last Row as well
 *  so, for row = R-1 to 0
 *  dungeon[row][C]=min(0,min(dungeon[row][C],dungeon[row][C]+dungeon[row+1][C]))
 * 
 *  the result would be the  -1*(dungeon[0][0]-1) (i.e. we need atleast one more than the min cost req )
 */

public class DungeonGame {
    public static void main(String[] args) {

        int [][] dungeon = {{1},{-2},{1}};
        int R=dungeon.length;
        int C=dungeon[0].length;
        
        //calculate last row

        for(int c= C-2;c>=0;c--){
            if(dungeon[R-1][c]+dungeon[R-1][c+1] < 0){
                dungeon[R-1][c]=Math.min(dungeon[R-1][c], dungeon[R-1][c]+dungeon[R-1][c+1]);
            }else if(dungeon[R-1][c]>0){
                dungeon[R-1][c]=0;
            }
        }

        //calculate last col 

        for(int r=R-2;r>=0 ;r--){
            if(dungeon[r][C-1]+dungeon[r+1][C-1] <0 ){
                dungeon[r][C-1]=Math.min(dungeon[r][C-1],dungeon[r][C-1]+dungeon[r+1][C-1]);
            }else if(dungeon[r][C-1]>0){
                dungeon[r][C-1]=0;
            }
        }

        //calculate the other one

        for(int r=R-2;r>=0;r--){
            for(int c=C-2;c>=0;c--){
                dungeon[r][c]=Math.min(0, dungeon[r][c]+Math.max(dungeon[r+1][c], dungeon[r][c+1]));
            }
        }
       System.out.println(-1*(dungeon[0][0]-1));
    }
}
