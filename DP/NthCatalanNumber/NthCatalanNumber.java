package DP.NthCatalanNumber;

public class NthCatalanNumber{
	public static void main(String[] args) {
			
			int n =175;
			long [] dp = new long [n+1];
			dp[0]=1;
			dp[1]=1;
			getNthCatalanNumber(dp,n);
			System.out.println(dp[n]);
	}

	public static long getNthCatalanNumber(long [] dp,int n){
		for(int i=2;i<=n;i++){
			for(int j=0;j<i;j++){
				dp[i]+=(dp[j]*dp[i-j-1]);
			}
		}
		return dp[n];
	}
}