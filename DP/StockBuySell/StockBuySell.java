package DP.StockBuySell;

import java.util.Arrays;

public class StockBuySell {

    public static void main(String[] args) {
        // int prices [] = {1,2,3,4,5};
        int [] prices={3,2,6,5,0,3};
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
        // System.out.println(maxProfit);
        getMaxReturn(prices,n);
    }

    public static void getMaxReturn(int [] prices,int n ){
        int [] dp = new int [n];
        int maxProfit = 0;
        int maxProfitUpto= 0;
        int smallest = 0;
        int smallestDp =0;
        int lastDep=0;
        dp[0]=0;

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                maxProfitUpto= Math.max(maxProfitUpto, dp[j]);
                maxProfitUpto=Math.max(maxProfitUpto, prices[i]-prices[j]);
                maxProfit=Math.max(maxProfit, dp[j]+(prices[i]-prices[j]));
                dp[i]=maxProfitUpto;
            }
        }

        int s1=-prices[0];
        int s2=Integer.MIN_VALUE;
        int s3 = Integer.MIN_VALUE;
        int s4=Integer.MIN_VALUE;

        for(int i=1;i<prices.length;i++){
            s1=Math.max(s1,-prices[i]);
            s2=Math.max(s2,s1+prices[i]);
            s3=Math.max(s3,s2-prices[i]);
            s4=Math.max(s4,s3+prices[i]);
        
            // if(prices[i]-prices[smallestDp] < )
            
        }
        System.out.println(s4);
    }
    
}
