package DP.BestTimeToBuyAndSellStockCooldown;

public class BestTimeToBuyAndSellStockCoolDown {
    public static void main(String[] args) {
        int [] prices = {8 ,8 ,1 ,7 ,3 ,3 ,2 ,6 ,8  };
        int n = prices.length;
        int [][] dp = new int [n][n];
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            dp[0][i]=prices[i]-prices[0]>0?prices[i]-prices[0]:0;
        }
        for(int i=1;i<n;i++){
            int max = 0;
            for(int j=0;j<n;j++){
                if(j<=i){
                    if(j<i-1){
                        max=Math.max(max,dp[i-1][j]);
                    }
                    dp[i][j]=dp[i-1][j];
                }else{
                    int res = max;
                    res = res+(prices[j]-prices[i]);
                    dp[i][j]=Math.max(dp[i-1][j],res);
                }
                ans=Math.max(ans, dp[i][j]);
            }
        }
        System.out.println(ans);
    }
    
}
