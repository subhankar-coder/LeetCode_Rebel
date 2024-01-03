package WordSearchII;

import java.util.*;

public class WordSearchIITrie {

    public static void main(String[] args) {
        char [][] board={{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String [] words={"oath","pea","eat","rain"};
        int rowLen=board.length;
        int colLen=board[0].length;

        Trie trie=new Trie();
        for(String ele:words){
            trie.insert(ele);
        }
        for(int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                trie.search(board, "", i, j, rowLen, colLen, trie.root);
            }
        }
        
    }
    
}
class Node {
    public boolean isEnded;
    public Node [] children=new Node [26];
    public Node(){
        this.isEnded=false;
        for(int i=0;i<children.length;i++){
            children[i]=null;
        }
    }
    
}

class Trie{
    public Node root;
    public List<String> resultList;
    public Trie(){
        this.root=new Node();
        this.resultList=new ArrayList<>();
    }
    public void insert(String key){
        int index;
        Node root=this.root;
        int keyLen=key.length();
        for(int i=0;i<keyLen;i++){
            index=key.charAt(i)-'a';
            if(root.children[index]==null){
                root.children[index]=new Node();
            }
            root=root.children[index];
        }
        root.isEnded=true;
    }
    public void search(char [][]board,String result,int row,int col,int rowLen,int colLen,Node root){
        if(row<0 || row>=rowLen || col<0 || col>=colLen || board[row][col]=='*' || root==null || root.children[board[row][col]-'a']==null )
            return ;
       
        char ele=board[row][col];
        int index=ele-'a';
        root=root.children[index];
        if(root.isEnded){
            resultList.add(result+ele);
            root.isEnded=false;
        }
        board[row][col]='*';
        
        search( board,result+ele, row+1, col, rowLen, colLen, root);
        search( board, result+ele, row-1, col, rowLen, colLen, root);
        search( board,  result+ele, row, col+1, rowLen, colLen, root);
        search( board, result+ele, row, col-1, rowLen, colLen, root);
            
        board[row][col]=ele;
    }
}
