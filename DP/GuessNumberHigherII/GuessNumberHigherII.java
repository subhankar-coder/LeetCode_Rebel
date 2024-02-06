package DP.GuessNumberHigherII;

public class GuessNumberHigherII {
    static int [][] dp;
    public static void main(String[] args) {
        int n=4;
        dp=new int [n+1][n+1];
        System.out.println(solve(1, n));
    }
    public static int solve(int start,int end){
       
        if(start>=end)
            return 0;
        if(dp[start][end]!=0)
            return dp[start][end];
        int mid = start+(end-start)/2;
        int cost =Integer.MAX_VALUE;
        for(;mid<=end;mid++){
            cost = Math.min(cost,mid+Math.max(solve(start, mid-1), solve(mid+1, end)));
        }
        dp[start][end]=cost;
        return cost;
    }
}
