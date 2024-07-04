package TilingProblem;

public class TilingProblem {

    public static void main(String[] args) {
        long mod=1000000007;
        int n = 4;
        long [] dp = new long [n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%mod;
        }

        int ans = (int)(dp[n]%mod);

        System.out.println(ans);
    }
}