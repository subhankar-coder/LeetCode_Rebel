package ChocolatePickUp;

public class ChocolatePickUp{

	static int R ;
	static int C;
	static int max;
	static int [] dict;
	static int [][][] dp;
	public static void main(String[] args) {
		int [][] grid = {{2, 3, 1, 2}, {3, 4, 2, 2}, {5, 6, 3, 5}};
		R=3;
		C=4;
		max=Integer.MIN_VALUE;
		dict = new int [] {1,-1,0};
		dp=new int [R][C][C];
		// solve(grid,0,0,0,C-1,grid[0][0],grid[0][C-1]);
		System.out.println(solveDp(grid,0,0,C-1));
	}
	public static void solve(int [][] grid,int aliceRow ,int aliceCol,int bobRow,int bobCol,int aliceSum,int bobSum){


			System.out.println(" alice "+aliceRow+"  "+aliceCol+" " +aliceSum);


			if(aliceRow+1<R ){
				int val=0;
				if(aliceCol<C){
					val = grid[aliceRow+1][aliceCol];
					grid[aliceRow+1][aliceCol]=0;
					solve(grid,aliceRow+1,aliceCol,bobRow,bobCol,aliceSum+val,bobSum);
					grid[aliceRow+1][aliceCol]=val;
				}
				if(aliceCol+1<C){
					val = grid[aliceRow+1][aliceCol+1];
					grid[aliceRow+1][aliceCol+1]=0;
					solve(grid,aliceRow+1,aliceCol+1,bobRow,bobCol,aliceSum+val,bobSum);
					grid[aliceRow+1][aliceCol+1]=val;
				}
				if(aliceCol-1>=0){
					val = grid[aliceRow+1][aliceCol-1];
					grid[aliceRow+1][aliceCol-1]=0;
					solve(grid,aliceRow+1,aliceCol-1,bobRow,bobCol,aliceSum+val,bobSum);
					grid[aliceRow+1][aliceCol-1]=val;
				}
			}else if(bobRow+1<R){
					int val =0;
					if(bobCol<C){
						val = grid[bobRow+1][bobCol];
						grid[bobRow+1][bobCol]=0;
						solve(grid,aliceRow,aliceCol,bobRow+1,bobCol,aliceSum,bobSum+val);
						grid[bobRow+1][bobCol]=val;
					}
					if(bobCol+1<C){
						val = grid[bobRow+1][bobCol+1];
						grid[bobRow+1][bobCol+1]=0;
						solve(grid,aliceRow,aliceCol,bobRow+1,bobCol+1,aliceSum,bobSum+val);
						grid[bobRow+1][bobCol+1]=val;
					}
					if(bobCol-1>=0){
						val = grid[bobRow+1][bobCol-1];
						grid[bobRow+1][bobCol-1]=0;
						solve(grid,aliceRow,aliceCol,bobRow+1,bobCol-1,aliceSum,bobSum+val);
						grid[bobRow+1][bobCol-1]=val;
					}
			}

			max=Math.max(max,aliceSum+bobSum);
			System.out.println(" bob "+bobRow+"  "+bobCol+" "+bobSum);
	}
	public  int solveDp(int [][] grid,int chocolateRow,int aliceCol,int bobCol){
			
			if(chocolateRow>=R || aliceCol>=C || bobCol>=C || aliceCol<0 || bobCol<0)
			    return 0;
			    
			if(dp[chocolateRow][aliceCol][bobCol]!=-1)
			    return dp[chocolateRow][aliceCol][bobCol];
			
			int res =getChocolate(grid,chocolateRow,aliceCol,bobCol);
			

			int ans =Integer.MIN_VALUE;
			// int max = Integer.MIN_VALUE;
			for(int i : dict){
				for(int j:dict){
					ans = Math.max(ans,solveDp(grid,chocolateRow+1,aliceCol+i,bobCol+j));

				}
			}
			return dp[chocolateRow][aliceCol][bobCol]=(ans +res);
	}
	public  int getChocolate(int grid [][] ,int chocolateRow,int aliceCol,int bobCol ){

		if(aliceCol==bobCol )
		    return grid[chocolateRow][aliceCol];
		    
		return grid[chocolateRow][aliceCol]+grid[chocolateRow][bobCol];
	}
}