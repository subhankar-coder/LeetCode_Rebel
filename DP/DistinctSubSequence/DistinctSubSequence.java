package DP.DistinctSubSequence;

public class DistinctSubSequence {
    public static void main(String[] args) {
       
       String s = "abcd", t = "abe";
       int n = s.length();
       int m = t.length();
       
       int dp[][] = new int[m][n];
       dp[m-1][n-1]= s.charAt(n-1)==t.charAt(m-1)?1:0;
       for(int i=n-2;i>=0;i--){
         if(t.charAt(m-1)==s.charAt(i)){
            dp[m-1][i]=dp[m-1][i+1]+1;
         }else{
            dp[m-1][i]=dp[m-1][i+1];
         }
       }

       for(int i=m-2;i>=0;i--){
        for(int j=n-1;j>=0;j--){
            if(j>(n-(m-i+1)+1)){
                dp[i][j]=0;
            }else if(s.charAt(j)==t.charAt(i)){
                if(t.charAt(i)==t.charAt(i+1)){
                    dp[i][j]=dp[i][j+1]+dp[i+1][j+1];
                }else{
                    dp[i][j]=dp[i+1][j]+dp[i][j+1];
                }
            }else{
                dp[i][j]=dp[i][j+1];
            }
        }
       }
       System.out.println(dp[0][0]);
    }
    
}
