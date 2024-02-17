/*
 * @lc app=leetcode id=518 lang=java
 * @lcpr version=30116
 *
 * [518] Coin Change II
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    int count;
    public int change(int amount, int[] coins) {
        count=0;
        return solveDp(coins,amount,coins.length);
        // solve(amount,coins,coins.length,0);
        // return count;
    }
    public void  solve(int amount ,int [] coins ,int n,int index){
        if(amount<0)
            return ;

        if(amount==0){
            count++;
            return;
        }
        if(index>=n)
            return;
        
        for(int i=index;i<n;i++){
            solve(amount-coins[i],coins,n,i);
        }
    }
    public int solveDp(int [] coins,int amount,int n){
        
        int [][] dp = new int [n+1][amount+1];

        if(amount==0)
            return 1;

        for(int i=1;i<=n;i++){
            if(coins[i-1]<=amount){
                dp[i][coins[i-1]]=1;
            }
            // dp[i][0]=1;
        }
        

        for(int i=1;i<=n;i++){
            int denomination = coins[i-1];
            for(int j=1;j<=amount;j++){
                if(denomination<=j){

                    dp[i][j]+=dp[i][j-denomination]+dp[i-1][j] ;
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
        // for(int [] arr:dp){
        //     System.out.println(Arrays.toString(arr));
        // }
    }
}
// @lc code=end



/*
// @lcpr case=start
// 5\n[1,2,5]\n
// @lcpr case=end

// @lcpr case=start
// 3\n[2]\n
// @lcpr case=end

// @lcpr case=start
// 10\n[10]\n
// @lcpr case=end

 */

