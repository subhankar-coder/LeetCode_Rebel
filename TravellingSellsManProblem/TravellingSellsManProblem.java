package TravellingSellsManProblem;

import java.util.*;

public class TravellingSellsManProblem{
	static int [][] dp;
	public static void main(String[] args) {
		int [][] distance = {{0, 20, 42 ,25},{20, 0 ,30 ,34},{42, 30, 0 ,10},{25 ,34 ,10 ,0}};

		int n = distance.length;
		int mask = (1<<n);
		System.out.println(mask);
		dp=new int [mask][n];

		for(int [] arr:dp)
				Arrays.fill(arr,-1);

		System.out.println(solve(distance,n,1,0,n-1));
	}
	public static int solve(int [][] distance,int n,int mask,int cityIndex,int visited){

		if(cityIndex>=n)
				return 0;

		if(dp[mask][cityIndex]!=-1)
				return dp[mask][cityIndex];
		int min = Integer.MAX_VALUE;

		for(int i=0;i<n;i++){
			int res =0;
			if( i!=cityIndex && ((mask>>i)&1) ==0){
				
				System.out.println(" i "+i+" cityIndex "+cityIndex+" mask "+Integer.toBinaryString(mask)+" val "+distance[i][cityIndex]+" visited "+visited);
				int m = visited==1?(mask|(1<<i))-1 : mask|(1<<i);
				res+=(distance[i][cityIndex]+solve(distance,n,m, i,visited-1));

				min = Math.min(min,res);

				System.out.println(" min "+min + " res "+res);
			}
		}
		min = min==Integer.MAX_VALUE?0:min;
		return dp[mask][cityIndex]=min;
	}
}