
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
