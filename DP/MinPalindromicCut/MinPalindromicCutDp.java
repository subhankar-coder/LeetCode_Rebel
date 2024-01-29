package DP.MinPalindromicCut;

import java.util.Arrays;

public class MinPalindromicCutDp {

    static int [][] dp;
    public static void main(String[] args) {
        String str ="abccbc";
        int n = str.length();
        dp=new int [n][n];
        palindromicSubstring(str, n);
        // System.out.println(getMinCut(str, 0, n-1));
        getMinCutDp(str, n);
       
    }
    public static int getMinCut(String str,int start,int end){
        if(dp[start][end]==1)
            return 0;
        int min=Integer.MAX_VALUE;
        for(int i=start;i<end;i++){
            int k = 1+getMinCut(str, start, i)+getMinCut(str, i+1, end);
            min=Math.min(min, k);
            System.out.println(start+" "+end +" "+min);
        }
        return min;
    }

    public static void getMinCutDp(String str,int n){
        int [] minCut = new int [n];
        Arrays.fill(minCut, Integer.MAX_VALUE);
        minCut[0]=0;
        if(1<n){
            minCut[1]=str.charAt(0)==str.charAt(1)?0:1;
        }
        for(int i=2;i<n;i++){
            for(int j=i;j>=0;j--){
                if(dp[j][i]==1){
                    if(j==0){
                        minCut[i]=0;
                    }else
                        minCut[i]=Math.min(minCut[i], 1+minCut[j-1]);
                }
            }
        }

        System.out.println(minCut[n-1]);
    }
    public static void palindromicSubstring(String str,int n){

        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        for(int i=0;i<n-1;i++){
            if(str.charAt(i)==str.charAt(i+1)){
                dp[i][i+1]=1;
            }
        }
        for(int j=2;j<n;j++){
            for(int i=0;i+j<n;i++){
                if(str.charAt(i)==str.charAt(i+j) && dp[i+1][i+j-1]==1){
                    dp[i][i+j]=1;
                }
            }
        }
    }
    
}
