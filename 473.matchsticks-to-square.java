/*
 * @lc app=leetcode id=473 lang=java
 * @lcpr version=30116
 *
 * [473] Matchsticks to Square
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
   int [] visited;
   int k; 
   int t;
    public boolean makesquare(int[] matchsticks) {

        int sum = Arrays.stream(matchsticks).boxed().mapToInt(i->i).sum();
        int n = matchsticks.length;
        k = 4;
        int target = sum/k;
        if(sum%k!=0)
            return false;
        t=target;
        if(target==0)
            return false;
        visited=new int[n];
        // visited[0]=1;
        Arrays.sort(matchsticks);
        return canDivide(matchsticks, n, 0,target,true,"",k ,false);
    }
    public boolean canDivide(int [] matchsticks,int n,int index,int target,boolean isStarting,String path,int k,boolean flag){
       
        //    System.out.println(path+"  trgt "+target+"  "+k);
           if(k==0)
                return true;
            if(index>=n){
                return false;
            }
            for(int i=index;i<n;i++){
                if(visited[i]!=1){
                    visited[i]=1;
                    if(target-matchsticks[i]==0){
                        int tgt=t;
                        
                            // System.out.println(path+" -> "+matchsticks[i]);
                            // System.out.println(Arrays.toString(visited));
                        
                        if(canDivide(matchsticks,n,0,tgt,true,"",k-1,flag)){
                            // System.out.println("In return ");
                            return true;
                        }
                    }else if(target-matchsticks[i]>0){
                        if(canDivide(matchsticks,n,i,target-matchsticks[i],false,path+" -> "+matchsticks[i],k,flag)){
                            return true;
                        }
                    }
                    visited[i]=0;
                }
            }
            return false;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,1,2,2,2]\n
// @lcpr case=end

// @lcpr case=start
// [3,3,3,3,4]\n
// @lcpr case=end

 */

