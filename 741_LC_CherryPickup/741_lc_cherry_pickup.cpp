#include<bits/stdc++.h>

using namespace std;

int N;



int solve(vector<vector<int>> grid ,int r1,int c1,int r2,vector<vector<vector<int>>> dp){

	// cout<<"r1 "<<r1<<" c1 "<<c1<<" r2 "<<r2<<" c2 "<<c2<<" path1 "<<path1<<" path2 "<<path2<<endl;

	int c2 = r1+c1-r2;
	
	if( r1>=N || r2>=N || c1>=N || c2>=N || grid[r1][c1]==-1 || grid[r2][c2] ==-1)
		return INT_MIN;

	if(dp[r1][c1][r2]!=-1)
		return dp[r1][c1][r2];
	
	if(r1 == N-1 && c1==N-1){
		// cout<<"path1 "<<path1<<" path2 "<<path2<<endl;
		return grid[N-1][N-1];
	}

	

	int cherry = (r1==r2 && c1==c2)?grid[r1][c1]:grid[r1][c1]+grid[r2][c2];




	// int rr =solve(grid,r1,c1+1,r2,dp); //right,right
	// int rd =solve(grid,r1,c1+1,r2+1,dp); // right ,down
	// int dr =solve(grid,r1+1,c1,r2,dp); //down , right
	// int dd = solve(grid,r1+1,c1,r2+1,dp); //down,down



	int mx = max({solve(grid,r1,c1+1,r2,dp),solve(grid,r1,c1+1,r2+1,dp),solve(grid,r1+1,c1,r2,dp),solve(grid,r1+1,c1,r2+1,dp)});

	
	
	return dp[r1][c1][r2]=mx+cherry;

}

int main(){
	vector<vector<int>> grid = {{0,1,-1},{1,0,-1},{1,1,1}};
	N = grid.size();

	vector<vector<vector<int>>> dp (N,vector<vector<int>>(N,vector<int>(N,-1)));

	cout<<solve(grid,0,0,0,dp);
}