/*
 * @lc app=leetcode id=494 lang=java
 * @lcpr version=30116
 *
 * [494] Target Sum
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.*;
class Solution {
    int count;
    public int findTargetSumWays(int[] nums, int target) {
        return solveDp(nums,target,nums.length);
    }
    public int solveDp(int [] nums,int target,int n){

        if(n==1){
            if(target==nums[0] && target==-nums[0])
                return 2;
            else if(target == nums[0] || target==-nums[0])
                return 1;
            else 
                return 0;
        }
        // int count= 0;
        Map<Integer,Integer>[] dp = new HashMap[n];

        dp[0]=new HashMap<>();
        dp[0].put(nums[0],1);
        if(dp[0].containsKey(-nums[0])){
            dp[0].put(nums[0], dp[0].get(nums[0])+1);
        }else
            dp[0].put(-nums[0],1);

        for(int i=1;i<n;i++){
            Map<Integer,Integer> cache = new HashMap<>();
            int [] set = new int []{nums[i],-nums[i]};
            for(int ele1:set){
                 for(int ele2:dp[i-1].keySet()){
                    
                    int ele = ele1+ele2;
                    if(!cache.containsKey(ele))
                        cache.put(ele, dp[i-1].get(ele2));
                    else
                        cache.put(ele,dp[i-1].get(ele2)+cache.get(ele));
                 }   
            }
            // System.out.println(cache);
            dp[i]=cache;
        }
        return dp[n-1].containsKey(target)?dp[n-1].get(target):0;
        // System.out.println(dp[n-1].stream().filter(i->i==target).count());
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,1,1,1,1]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1]\n1\n
// @lcpr case=end

 */

