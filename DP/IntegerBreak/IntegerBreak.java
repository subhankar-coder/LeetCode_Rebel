package DP.IntegerBreak;

import java.util.Arrays;

public class IntegerBreak {

    static int N;
    static int [] dp;
    public static void main(String[] args) {
        int n =4;
        N=n;
        // max=Integer.MIN_VALUE;
        dp = new int [n+1];
        System.out.println(breakInteger(n));
        System.out.println(Arrays.toString(dp));
    }
    public static int breakInteger(int n ){

        if(n<=1){
            
            return dp[n]= 1;
        }
        if(dp[n]!=0)
            return dp[n];
        int res =1;
        for(int i=N==n?n-1:n;i>=1;i--){
            int val =i;
            val=i*breakInteger(n-i);

            res=Math.max(res, val);
        }
        return dp[n]=res;
    }
    
}
