package BackTracking.NQueen;

import java.util.Arrays;

public class nQueen {

	private static final int N=8;
	public static void main(String[] args) {
		solve();
	}
	public static boolean isSafe(int [][] grid,int row,int col){
	
		if(row>=N || row<0 || col>=N || col<0 || grid[row][col]!=0){
			return false;
		}
		//in the same col
		for(int i=0;i<N;i++){
			if(i!=row && grid[i][col]!=0)
				return false;
		}
		//in the same row
		for(int i=0;i<N;i++){
			if(i!=col && grid[row][i]!=0)
				return false;
		}
		//up left diagonal
		for(int i=row,j=col; i>=0 && j>=0 ;i--,j--){
			if(grid[i][j]!=0)
				return false;
			
		}
		//up right diagonal 
		for(int i=row,j=col; i>=0 && j<N ;i--,j++){
			if(grid[i][j]!=0)
				return false;
		}
		//down left diagonal
		for(int i=row,j=col; i<N && j>=0 ;i++,j--){
			if(grid[i][j]!=0)
				return false;
		}
		//down right diagonal
		for(int i=row,j=col ;i<N &&j<N;i++,j++){
			if(grid[i][j]!=0)
				return false;
		}
		return true;

	}

	public static void solve(){
		int [][] grid= new int[N][N];
		int row=0;
		int col =0;

		solveUtil(grid, row, col);
		for(int [] arr: grid){
			System.out.println(Arrays.toString(arr));
		}


	}
	public static boolean solveUtil(int [][] grid,int row,int col){

		if(row>=N)
				return true;
		if(isSafe(grid, row, col)){
			grid[row][col]=1;
			if(solveUtil(grid, row+1, 0)){
				return true;
			}
	}
	if(row<N && row>=0 && col<N && col>=0){
		grid[row][col]=0;
		if(solveUtil(grid, row, col+1))
			return true;
	}
	return false;

    }
}
