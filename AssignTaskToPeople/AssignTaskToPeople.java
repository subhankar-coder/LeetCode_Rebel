package AssignTaskToPeople;

import java.util.*;

public class AssignTaskToPeople{
	static int [][] dp;
	public static void main(String[] args) {
		int n = 4;
		int [] [] arr = {{9 ,2 ,7 ,8},{6, 4, 3, 7},{5 ,8 ,1 ,8},{7 ,6 ,9 ,4}};

		int state = (1<<n);

		dp = new int [n][state];

		for(int [] array:dp)
				Arrays.fill(array,-1);

		System.out.println(solve(0,n,arr,0));
	}
	public static int solve(int mask,int n,int [][] arr,int jobIndex){


			if(jobIndex>=n){	
					return 0;
			}

			if(dp[jobIndex][mask]!=-1){
					// System.out.println("here");
					return dp[jobIndex][mask];
			}
			int min = Integer.MAX_VALUE;
			for(int i=0;i<n;i++){
				int temp =0;
				if(((mask>>i) & 1) ==0){
					// System.out.println("i "+i+ " mask " +Integer.toBinaryString(mask)+"  "+arr[i][jobIndex]+" min "+min);
					int s = solve((mask | (1<<i)), n,arr,jobIndex+1);
					int m =(arr[i][jobIndex]+ s);
					temp+=m;
					min=Math.min(min,temp);
					// System.out.println("temp "+temp+" jobIndex "+jobIndex+" curr "+arr[i][jobIndex]+" m "+m+" s "+s+" min "+min);
				}
				// System.out.println("min "+min);
			}
				return dp[jobIndex][mask]= min;
	}
}