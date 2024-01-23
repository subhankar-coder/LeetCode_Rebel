package DP.RegularExpressionMatching;

import java.util.Arrays;

public class RegularExpressionmatching {

    public static void main(String[] args) {

    String s="";
    String p ="";    
    int m = s.length();
      int n = p.length();
      boolean dp [][] = new boolean[m+1][n+1];
        for(boolean[] arr:dp){
            Arrays.fill(arr, false);
        }
        dp[0][0]=true;
        if(m==0 && n==0)
            return;
            
        if(n==0)
            return;

        //first column
        for(int i=1;i<=m;i++){
            dp[i][0]=false;
        }

        //first row 
        for(int i=2;i<=n;i++){
            if(p.charAt(i-1)=='*'){
                dp[0][i]=dp[0][i-2];
            }
        }
        
        for(int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(j>1 && p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-2];
                    if(s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.'){
                        dp[i][j]= dp[i][j] || dp[i-1][j];
                    }
                }
            }
        }
        System.out.println(dp[m][n]);
    }
    
}
