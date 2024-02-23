package ConcatenatedWords;

import java.util.*;


public class ConcatenatedWords{
	public  static TrieNode root;

	public static void main(String[] args) {
		
		String [] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
		Arrays.sort(words,(a,b)-> a.length()-b.length());
		root=new TrieNode();
		List<String> res=new ArrayList<>();
		for (String str: words){
			if(solve(str,0,str.length(),root)){
				res.add(str);
			}
			insert(str);
		}

		System.out.println(res);


	}
    public static boolean solve(String s,int index ,int n,TrieNode node){


    	if(index>=n)
    		return node.endOfWord;

    	if(node==null )
    		return false;

    	int ch = s.charAt(index)-'a';

    	if(node!=null && node.neighbours[ch]==null)
    		return false;

    	if(node.neighbours[ch].endOfWord){
    		return solve(s,index+1,n,node.neighbours[ch]) || solve(s,index+1,n,root);
    	}else{
    		return solve(s,index+1,n,node.neighbours[ch]);
    	}


	}
	public static boolean isPresent(TrieNode node,int ch){
        
        if(node !=null && node.neighbours[ch]!=null){
            return true;
        }
       
        return false;

    }
     public static void insert(String key){
        int keyLen = key.length();
        int index;
        TrieNode node=root;

        for(int i=0;i<keyLen;i++){
            int ch = (int)key.charAt(i);
            index=ch-97;
            if(node!=null){
                if(node.neighbours[index]==null){
                    node.neighbours[index]=new TrieNode();

                }
                node=node.neighbours[index];
            }
        }
        node.endOfWord=true;
    }
}


class TrieNode{
    static int ALPHABETS=26;
    public TrieNode[] neighbours=new TrieNode[ALPHABETS];
    public boolean endOfWord;
    public TrieNode(){
        this.endOfWord=false;

        for(int i=0;i<ALPHABETS;i++){
            this.neighbours[i]=null;
        }
    }
}