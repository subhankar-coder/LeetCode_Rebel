#include<bits/stdc++.h>
using namespace std;

int cherryPickUp(vector<vector<int>> grid,int n,vector<vector<vector<int>>> dp){
    
    if(grid[n-1][n-1]==-1){
        return 0; 
    }

    dp[n-1][n-1][n-1] = grid[n-1][n-1];

    for(int i=n-1;i>=0;i--){
        for(int j=n-1;j>=0;j--){
            for(int k=n-1;k>=0;k--){
                int m = i+j-k;
                if(m<0 || m>=n || grid[i][j]==-1 || grid[k][m]==-1){

                    dp[i][j][k]=INT_MIN;
                    continue;
                }

                int cherry = (i==k && j==m)?grid[i][j]:grid[i][j]+grid[k][m];

                int max_cherry = INT_MIN;

                if(i+1 <n && k+1 <n)max_cherry=max(max_cherry,dp[i+1][j][k+1]);
                if(i+1<n)max_cherry = max(max_cherry,dp[i+1][j][k]);
                if(j+1<n && k+1<n)max_cherry = max(max_cherry,dp[i][j+1][k+1]);
                if(j+1<n)max_cherry=max(max_cherry,dp[i][j+1][k]);

                if(max_cherry!=INT_MIN)
                    dp[i][j][k]=cherry+max_cherry;

            }
        }
    }
    return dp[0][0][0]==INT_MIN?0:dp[0][0][0];
}

int main() {
    vector<vector<int>> grid = {{0, 1, -1}, {1, 0, -1}, {1, 1, 1}};
    int n = grid.size();

    vector<vector<vector<int>>> dp (n,vector<vector<int>>(n,vector<int>(n,INT_MIN)));

    cout<<cherryPickUp(grid,n,dp);
    return 0;
}