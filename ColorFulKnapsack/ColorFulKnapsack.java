package ColorFulKnapsack;

import java.util.*;

public class ColorFulKnapsack{

	public static void main(String[] args) {
		int m = 3;
		int x = 10;

		int [] w = {3 ,3 ,3};
		int [] c= {1,2,1};

		int n = w.length;
		int [][] array = new int [n+1][2];

		int [] index = new int [m+1];

		for(int i=1;i<=n;i++){
			index[c[i-1]]+=1;
			int [] temp ={c[i-1],w[i-1]}; 
			array[i]=temp;
		}

		for(int i=1;i<=m;i++){
			if(index[i]==0)
				System.out.println(-1);
			index[i]+=index[i-1];
		}

		// System.out.println(Arrays.toString(index));

		Arrays.sort(array,(a,b)->a[0]-b[0]);

		

		int [][] dp = new int [n+1][x+1];

		for(int i=1;i<=n;i++){

			for(int j=1;j<=x;j++){

				if(j<array[i][1]){
					dp[i][j]=dp[i-1][j];
				}else{

					// System.out.println(i+" "+j);

					if(i==1 || (array[i-1][0]!=array[i][0])){
						if(array[i][0]!=1 && dp[i-1][j-array[i][1]]==0){
							dp[i][j]=0;
						}else{

							dp[i][j]= dp[i-1][j-array[i][1]]+array[i][1];
						}
						
					}else{
						if(array[i][0]!=1 && dp[index[array[i][0]-1]][j-array[i][1]]==0){
							dp[i][j]=dp[i-1][j];
						}
						else
							dp[i][j]=Math.max(dp[i-1][j],dp[index[array[i][0]-1]][j-array[i][1]]+array[i][1]);
					}
				}

			}
		}

		for(int [] arr: dp){
			System.out.println(Arrays.toString(arr));
		}


		System.out.println(dp[n][x]);

	}

}