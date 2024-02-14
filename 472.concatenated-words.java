/*
 * @lc app=leetcode id=472 lang=java
 * @lcpr version=30116
 *
 * [472] Concatenated Words
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.*;

class Solution {
    Set<String> dict;
    TrieNode root;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words,new Comparator<String >() {
            @Override
            public int compare(String a,String b){
                return a.length()-b.length();
            }
        });
        root=new TrieNode();
        dict = new HashSet<>();
        int n=words.length;
        List<String> res = new ArrayList<>();
        

        for(int i=0;i<n;i++){
            if(solve(words[i],root,0,words[i].length(),false)){
                res.add(words[i]);
            }
            dict.add(words[i]);
            insert(words[i]);
        }

        return res;
    }
    public boolean solve(String str,TrieNode node,int index,int n,boolean lastEnd){
            if(index>=n )
                return node.endOfWord;
            
            if(node!=null && node.endOfWord && dict.contains(str.substring(index,n)))
                return true;
            if(isPresent(node,(int)str.charAt(index)-97)){
                if(solve(str,node.neighbours[(int)str.charAt(index)-97],index+1,n,node.endOfWord)){
                    // System.out.println(str.substring(0,index+1));
                    if(node!=null && node.endOfWord)
                        dict.add(str.substring(0,index));
                    return true;
                }else if(node.endOfWord&& solve(str,root.neighbours[((int)str.charAt(index)-97)],index+1,n,false)){
                    if(node!=null && node.endOfWord)
                        dict.add(str.substring(0,index));
                    return true;
                }
            }else if(node!=null && node.endOfWord){
               
                if(isPresent(root,(int)str.charAt(index)-97)){
                    if(solve(str,root.neighbours[((int)str.charAt(index)-97)],index+1,n,false)){
                        if(node!=null && node.endOfWord)
                            dict.add(str.substring(0,index));
                        return true;
                    }
                }
            }
           
        return false;
    }
    public void insert(String key){
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
    public boolean isPresent(TrieNode node,int ch){
        
        if(node !=null && node.neighbours[ch]!=null){
            return true;
        }
       
        return false;

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
// @lc code=end



/*
// @lcpr case=start
// ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]\n
// @lcpr case=end

// @lcpr case=start
// ["cat","dog","catdog"]\n
// @lcpr case=end

 */

