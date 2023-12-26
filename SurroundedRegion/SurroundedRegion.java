package SurroundedRegion;


/* Floid Fill algo
 Convert the boundary connected ones (by dfs to another notations)
 convert the rest to x */
 
public class SurroundedRegion {

    public static int R;
    public static int C;

    public static int visited[][];

    public static int conv[][];
    public static void main(String[] args) {
        
    //    char [][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
    // char [][] board ={{'O','O','O'},{'O','O','O'},{'O','O','O'}};
    // char [][] board = {{'O','X','O'},{'X','O','X'},{'O','X','O'}};
    // char [][] board = {{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
    // char [][] board={{'X','X','X','X','X'},{'X','O','O','O','X'},{'X','X','O','O','X'},{'X','X','X','O','X'},{'X','O','X','X','X'}};

    char [][] board = {{'O','O','O','O','X','X'},{'O','O','O','O','O','O'},{'O','X','O','X','O','O'},{'O','X','O','O','X','O'},{'O','X','O','X','O','O'},{'O','X','O','O','O','O'}};    
       R = board.length;
       C= board[0].length;
       visited = new int[R][C];

       for(int i=0;i<R;i++){
        for(int j=0;j<C;j++){
            if(board[i][j]=='O')
                board[i][j]='-';
        }
       }

       for(int i=0;i<C;i++){
        if(board[0][i]=='-'){
            convertGrey(board, 0, i, 'O', '-');
        }
       }
       for(int i=0;i<C;i++){
        if(board[R-1][i]=='-'){
            convertGrey(board, R-1, i, 'O', '-');
        }
       }
       for(int i=0;i<R;i++){
        if(board[i][0]=='-'){
            convertGrey(board, i, 0, 'O', '-');
        }
       }
       for(int i=0;i<R;i++){
        if(board[i][C-1]=='-'){
            convertGrey(board, i, C-1, 'O', '-');
        }
       }

       for(int i=0;i<R;i++){
        for(int j=0;j<C;j++){
            if(board[i][j]=='-')
                board[i][j]='X';
        }
       }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        
    }
    public static void convertGrey(char [][] board,int r,int c,char newChar,char prevChar){
        if(r<0 || r>=R || c<0 || c>=C)
                return ;

        if(board[r][c]!=prevChar)
            return;
        
        board[r][c]=newChar;

        convertGrey(board,r+1,c,newChar,prevChar);
        convertGrey(board, r-1, c, newChar, prevChar);
        convertGrey(board, r, c+1, newChar, prevChar);
        convertGrey(board, r, c-1, newChar, prevChar);
        
    }
    
}

