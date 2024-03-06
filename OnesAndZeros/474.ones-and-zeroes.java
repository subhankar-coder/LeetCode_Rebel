/*
 * @lc app=leetcode id=474 lang=java
 * @lcpr version=30116
 *
 * [474] Ones and Zeroes
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String,Integer> map ;
    int [] ones;
    int [] zeros;
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        ones=new int[len];
        zeros=new int[len];
        map=new HashMap<>();
        for(int i=0;i<len;i++){
            getZerosAndOnes(strs[i], i);
        }
        int [][] dp = new int[m+1][n+1];
        // return solve(strs,0,m,n,len,0,"");
        return solveDp(dp, m, n, len);
    }
    public int solve(String [] strs,int index,int m ,int n,int N,int sum,String path){
        String key = index+" "+m+" "+n;
        if(index>=N)
        return 0;
        
        if(m==0 && n==0){
            return 0;
        }
        if(map.containsKey(key))
            return map.get(key);
        int max = ones[index]<=n && zeros[index]<=m?1:0;

        for(int i=index;i<N;i++){
            if(m-zeros[i]>=0 && n-ones[i]>=0){
                int res =  ones[i]<=n && zeros[i]<=m?1:0;
                res+=solve(strs, i+1, m-zeros[i], n-ones[i], N, sum+1, path+" -> "+strs[i]);
                max=Math.max(max, res);
            }
        }
        map.put(key, max);
        return max;
    } 
    public int solveDp(int [][] dp ,int m,int n,int len){

        for(int i=0;i<len;i++){
            int one= ones[i];
            int zero = zeros[i];
            for(int j=m;j>=zero;j--){
                for(int k=n;k>=one;k--){
                    if(j-zero>=0 && k-one>=0)
                        dp[j][k]=Math.max(dp[j][k], dp[j-zero][k-one]+1);
                }
            }
        }
        return dp[m][n];
    }
    public void  getZerosAndOnes(String str,int index){
        int i=0;
        int j = str.length()-1;
        int numOnes =0;
        int numZeros=0;
        while (i<=j) {
            int sum = Integer.valueOf(str.substring(i, i+1))+Integer.valueOf(str.substring(j,j+1));
            // System.out.println(str+" "+sum);
            if(i==j){
                if(str.charAt(i)=='1'){
                    numOnes++;
                }
                else{
                    numZeros++;
                }
                break;
            }
            
            if(sum==0){
                numZeros+=2;
            }else if(sum==1){
                numZeros+=1;
                numOnes+=1;
            }else{
                numOnes+=2;
            }
            i++;
            j--;
        }
        ones[index]=numOnes;
        zeros[index]=numZeros;
    }
}
// @lc code=end



/*
// @lcpr case=start
// ["10","0001","111001","1","0"]\n5\n3\n
// @lcpr case=end

// @lcpr case=start
// ["10","0","1"]\n1\n1\n
// @lcpr case=end

 */

