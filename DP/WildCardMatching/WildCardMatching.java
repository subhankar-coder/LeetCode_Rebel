package DP.WildCardMatching;

import java.util.Arrays;

public class WildCardMatching {
    public static void main(String[] args) {
        String s= "";
        // String p = "*****ba*****ab";
        String p = "******";
        
        int m = s.length();
        int n = p.length();

        boolean [][] dp = new boolean[m+1][n+1];
        for(boolean [] arr:dp){
            Arrays.fill(arr,false);
        }
        dp[0][0]=true;

        for(int i=1;i<=n;i++){
            if(p.charAt(i-1)=='*'){
                dp[0][i]=dp[0][i-1];
            }
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){

                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j-1] || dp[i][j-1] || dp[i-1][j];
                }
            }
        }

        System.out.println(dp[m][n]);
    }
    
}
