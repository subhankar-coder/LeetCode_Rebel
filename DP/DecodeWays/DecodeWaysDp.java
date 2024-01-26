package DP.DecodeWays;

import java.util.Arrays;

public class DecodeWaysDp {

    public static void main(String[] args) {
        String s="123123";
        char [] charArray = s.toCharArray();
        int n = s.length();
        int [][] dp = new int [n][n];

        dp[n-1][n-1]= charArray[n-1]=='0'?0:1;

        for(int i=n-2;i>=0;i--){
            for(int j=n-1;j>=i;j--){

                if(i!=j){
                    dp[i][j]=dp[i+1][j];
                }else{
                    
                    if(charArray[i]=='0' && charArray[j]=='0'){
                        dp[i][j]=0;
                    }else if(Integer.parseInt(s.substring(i, i+2))>=10 && Integer.parseInt(s.substring(i, i+2))<=26){
                        if(j+2<n){
                            dp[i][j]=dp[i][j+1]+dp[i][j+2];
                        }else{
                            dp[i][j]=dp[i][j+1]+1;
                        }
                    }else{
                        dp[i][j]=dp[i][j+1];
                    }
                } 
                

            }
        }

        System.out.println(dp[0][0]);
    }
    
}
