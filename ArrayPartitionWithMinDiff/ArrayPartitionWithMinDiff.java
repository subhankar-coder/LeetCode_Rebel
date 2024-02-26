package ArrayPartitionWithMinDiff;

import java.util.*;

public class ArrayPartitionWithMinDiff{
	static int [][] dp;
	static int min =Integer.MAX_VALUE;
	public static void main(String[] args) {
		int [] arr ={3, 1, 5, 2, 8};
		int n = arr.length;
		int sum = Arrays.stream(arr).boxed().mapToInt(i->i).sum();

		dp=new int[n+1][sum+1];
		for(int [] a:dp)
				Arrays.fill(a,-1);

		// solve(arr,n,sum,0,0);
		// System.out.println(min);
			System.out.println(solveMemo(arr,n,0,sum,0));
	}
	public static void solve(int [] arr,int n,int sum,int currSum,int index){

			if(index>=n)
					return;

			int diff = (int) (Math.abs((sum-currSum)-currSum));
			min = Math.min(min,diff);

			for(int i=index;i<n;i++){
				solve(arr,n,sum,currSum+arr[i],i+1);
			}
	}
	public static int  solveMemo(int [] arr,int n ,int currSum,int sum,int index){

		if(dp[index][currSum]!=-1)
				return dp[index][currSum];

		if(index>=n)
				return Math.abs((sum-currSum)-currSum);


		int pick = solveMemo(arr,n,currSum+arr[index],sum,index+1);
		int notPick = solveMemo(arr,n,currSum,sum,index+1);

		return dp[index][currSum]=Math.min(pick,notPick);
	}

}