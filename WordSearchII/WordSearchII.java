package WordSearchII;

import java.util.*;


public class WordSearchII {

    static int rowLen;
    static int colLen;
    static Map<Character,List<List<Integer>>> map = new HashMap<>();
    public static void main(String[] args) {
        char [][] board={{'a','b','c'},{'a','e','d'},{'a','f','g'}};
        String [] words={"eaafgdcba","eaabcdgfa"};
        rowLen=board.length;
        colLen = board[0].length;
        for(int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                if(map.containsKey(board[i][j])){
                    List<List<Integer>> list = map.get(board[i][j]);
                    list.add(Arrays.asList(i,j));
                    map.put(board[i][j], list);
                }else{
                    List<List<Integer>> list=new ArrayList<>(Arrays.asList(Arrays.asList(i,j)));
                    map.put(board[i][j], list);
                }
            }
        }
        // System.out.println(map);
        int visited[][];
        for (String  word : words) {
            visited=new int[rowLen][colLen];
            if(isValid(board,word, 0, 0, 0, visited)){
                System.out.println(word);
            }
        }

    }
    public static boolean isValid(char [][]board,String word,int level,int row,int col,int [][] visited){
        if(level>=word.length())
            return true;
        if(row<0 || row>=rowLen || col<0 || col>=colLen)
            return false;
        if(map.containsKey(word.charAt(level))){
            if(level==0){
                List<List<Integer>> list = map.get(word.charAt(level));
                for(int i=0;i<list.size();i++){
                    int r = list.get(i).get(0);
                    int c = list.get(i).get(1);
                    if(visited[r][c]==0){
                        visited[r][c]=1;
                        if(isValid(board,word, level+1, r+1, c, visited) ||  isValid(board,word, level+1, r-1, c, visited) ||
                        isValid(board,word, level+1, r, c+1, visited) || isValid(board,word, level+1, r, c-1, visited)){
                            return true;
                        }
                        visited[r][c]=0;
                    } 
                }
            }else if(visited[row][col]==0 && board[row][col]==word.charAt(level)){
                visited[row][col]=1;
                if(isValid(board,word, level+1, row+1, col, visited) ||  isValid(board,word, level+1, row-1, col, visited) ||
                        isValid(board,word, level+1, row, col+1, visited) || isValid(board,word, level+1, row, col-1, visited)){
                            return true;
                        }
                        visited[row][col]=0;
            }
        }
        return false;
    }
}
