package BackTracking.WordSearch;

import java.util.*;

public class WordSearch {
    static Map<Character,List<int[]>>map=new HashMap<>();
    static int R;
    static int C;
    public static void main(String[] args) {
        char [][]  board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        R=board.length;
        C=board[0].length;
        String word="ABCCED";

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
               if(board[i][j]==word.charAt(0)){
                System.out.println(searchWord(board, word, 0,i,j));
               }
            }
        }
    }
    public static boolean searchWord(char [][] board,String word,int level,int row,int col){
        if(level>=word.length())
            return true;
        if(row<0 || row>=R || col<0 || col>=C || board[row][col]!=word.charAt(level) || board[row][col]=='*'){
            return false;
        }
        char ele=board[row][col];
        board[row][col]='*';
        if(searchWord(board, word, level+1, row+1, col) ||
         searchWord(board, word, level+1, row, col+1) || 
         searchWord(board, word, level+1, row-1, col) || 
         searchWord(board, word, level+1, row, col-1)){
            return true;
        }
        board[row][col]=ele;
        return false;
        
    }
    
}
