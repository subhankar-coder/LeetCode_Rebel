package MaximumCoins;

import java.util.*;

public class MaximumCoins{

	static int [] directions = {-1,0,1};

	public static void main(String[] args) {
		int [][] mat = {{3, 6 ,8 ,2},{5 ,2 ,4 ,3},{1, 1, 20 ,10},{1, 1 ,20, 10},{1, 1 ,20 ,10 }};
		int n = 5;
		int m = 4;
		int [][][] cache = new int [n][m][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				for(int k=0;k<m;k++){
					cache[i][j][k]=-1;
				}
			}
		}

		System.out.println(solve(mat,n,m,0,0,m-1,cache));
	}

	public static int solve(int [][] mat,int row,int col ,int r,int c1,int c2,int [][][] cache){

		if(r>=row || c1>=col || c2>=col || c1<0 || c2<0){
			return Integer.MIN_VALUE;
		}

		if(cache [r][c1][c2]!=-1)
			return cache [r][c1][c2];

		if(r==row-1){
			if(c1==0 && c2==col-1){

				return c1==c2?mat[r][0]:mat[row-1][0]+mat[row-1][col-1];
			}else{
				return Integer.MIN_VALUE;
			}
		}

		int max = Integer.MIN_VALUE;

		for(int i: directions){
			for(int j: directions){
				max = Math.max(max,c1==c2?mat[r][c1]:mat[r][c1]+mat[r][c2]+solve(mat,row,col,r+1, c1+i,c2+j,cache));
			}
		}

		return (cache[r][c1][c2]=max);
	}
}