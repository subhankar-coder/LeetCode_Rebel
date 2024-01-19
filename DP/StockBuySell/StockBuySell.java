package DP.StockBuySell;

import java.util.Arrays;

public class StockBuySell {

    public static void main(String[] args) {
        // int prices [] = {3,3,5,0,0,3,1,4};
        int [] prices={1,2,3,4,5};
        int n = prices.length;

        int [][] dp = new int [n][n];
        dp[0][0]=0;
        int maxProfit = 0;
        int maxProfitUpto= 0;

        for(int i=1;i<n;i++){
            if(prices[i]-prices[0]>maxProfitUpto){
                maxProfitUpto=prices[i]-prices[0];
                maxProfit=maxProfitUpto;

            }
            dp[0][i]=maxProfitUpto;
        }

        for(int i=1;i<n;i++){
            int maxProfitBegin=dp[i-1][i];
            maxProfitUpto=dp[i-1][i];
            for(int j=i+1;j<n;j++){
                maxProfitUpto=Math.max(maxProfitUpto,dp[i-1][j]);
                maxProfitUpto=Math.max(maxProfitUpto, prices[j]-prices[i]);
                
                dp[i][j]=maxProfitUpto;
                maxProfit=Math.max(maxProfit, maxProfitBegin+(prices[j]-prices[i]));
            }
        }
        // for(int [] arr:dp){
        //     System.out.println(Arrays.toString(arr));
        // }
        System.out.println(maxProfit);
    }
    
}
