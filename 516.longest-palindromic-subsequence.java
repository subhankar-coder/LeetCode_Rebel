/*
 * @lc app=leetcode id=516 lang=java
 * @lcpr version=30116
 *
 * [516] Longest Palindromic Subsequence
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int dp [][] = new int[n][n];
        int maxLen=1;
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        for(int i=0;i<n;i++){
            if(i+1<n && s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=2;
                maxLen=2;
            }else if(i+1<n){
                dp[i][i+1]=1;
            }
        }

        for(int k = 2;k<n;k++){
            for(int i=0;i+k<n;i++){
                int max=1;
                for(int j=i;j<i+k;j++){
                    // System.out.println("here "+(i+k)+" "+j);
                    if(s.charAt(i+k)==s.charAt(j)){
                        // System.out.println("i -> "+j+1+" j ->"+(i+k-1)+" val "+dp[j+1][i+k-1]);
                        max=Math.max(max, dp[j+1][i+k-1]+2);
                    }else{
                        max=Math.max(max, dp[i][j]);
                    }
                }
                dp[i][i+k]=max;
                maxLen=Math.max(maxLen, max);
            }
        }
        // for(int [] arr:dp){
        //     System.out.println(Arrays.toString(arr));
        // }
        return maxLen;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "bbbab"\n
// @lcpr case=end

// @lcpr case=start
// "cbbd"\n
// @lcpr case=end

 */

