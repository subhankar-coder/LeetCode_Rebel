#include<bits/stdc++.h>

using namespace std;

bool isSafe(vector<vector<int>> &graph,int r,int c,int R,int C){
  if(r>=R || r<0 || c>=C || c<0)
    return false;

  return true;
}


int main(){

  vector<vector<int>> grid = {{1,1,1,1},{2,2,2,2},{1,1,1,1},{2,2,2,2}};
  int m = grid.size();
  int n = grid.size();
  vector<vector<int>> graph(m,vector<int>(n,0));


  for(int i=0;i<m;i++){
    for(int j=0;j<n;j++){
      if(grid[i][j]==1){
        if(isSafe(graph,i+1,j,m,n)){
          graph[i+1][j]=1;
        }
        if(isSafe(graph,i,j-1,m,n)){
          graph[i][j-1]=1;
        }
        if(isSafe(graph,i-1,j,m,n)){
          graph[i-1][j]=1;
        }
      }else if(grid[i][j]==2){
        if(isSafe(graph,i+1,j,m,n)){
          graph[i+1][j]=1;
        }
        if(isSafe(graph,i,j+1,m,n)){
          graph[i][j-1]=1;
        }
        if(isSafe(graph,i-1,j,m,n)){
          graph[i-1][j]=1;
        }
      }else if(grid[i][j]==3){
        if(isSafe(graph,i,j+1,m,n)){
          graph[i+1][j]=1;
        }
        if(isSafe(graph,i,j-1,m,n)){
          graph[i][j-1]=1;
        }
        if(isSafe(graph,i-1,j,m,n)){
          graph[i-1][j]=1;
        }
      }else {
        if(isSafe(graph,i-1,j,m,n)){
          graph[i+1][j]=1;
        }
        if(isSafe(graph,i,j-1,m,n)){
          graph[i][j-1]=1;
        }
        if(isSafe(graph,i-1,j,m,n)){
          graph[i-1][j]=1;
        }
      }
    }
  }

  for(auto inner:graph){
    for(auto val :  inner){
      cout<<val<<" ";
    }
    cout<<endl;
  }

  
  
  return 0;
}
