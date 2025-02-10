#include<bits/stdc++.h>

using namespace std;


bool isOutBoundary(vector<vector<int>> &heightMap,int r,int c,int R,int C){
  if(r>=R || r<0 || c<0 || c>=C)
    return true;
  return false;
}

bool isOnBoundary(int r,int c,int R,int C){
  
  if(r==R-1 || r==0 || c==C-1 || c==0)
    return true;
  return false;
  
}


struct Compare{

  bool operator()(const tuple<int,int,int,int,int> &t1 , tuple<int,int,int,int,int> &t2){
    return get<0>(t1) < get<0>(t2);
  }
};

int main(){

  vector<vector<int>> heightMap={{12,13,1,12},{13,4,13,12},{13,8,10,12},{12,13,12,12},{13,13,13,13}};
  int R = heightMap.size();
  int C = heightMap[0].size();

  vector<vector<int>> graph(R,vector<int>(C,INT_MAX));
  vector<vector<bool>> vis(R,vector<bool>(C,false));
  tuple<int,int,int,int,int> tpl;
  priority_queue<tuple<int,int,int,int,int>,vector<tuple<int,int,int,int,int>>,Compare> pq;

  pq.push(make_tuple(heightMap[1][1],1,1,-1,-1));

  while(!pq.empty()){
    
    auto current = pq.top();

    pq.pop();
    
    int r = get<1>(current);
    int c = get<2>(current);
    vis[r][c]=true;
    int boundary = INT_MAX;
    

    if(!isOutBoundary(heightMap,r+1,c,R,C)){
      
      if(isOnBoundary(r+1,c,R,C)){
        boundary = min(boundary,heightMap[r+1][c]);
        // cout<<boundary<<endl;
      }else if(graph[r+1][c]!=INT_MAX){
        boundary = min(boundary,graph[r+1][c]);
      }else if(!vis[r+1][c]){
        pq.push(make_tuple(heightMap[r+1][c],r+1,c,r,c));
      }
    }

    if(!isOutBoundary(heightMap,r-1,c,R,C)){
      if(isOnBoundary(r-1,c,R,C)){
        boundary = min(boundary,heightMap[r-1][c]);
      }else if(graph[r-1][c]!=INT_MAX){
        boundary = min(boundary,graph[r-1][c]);
      }else if(!vis[r-1][c]){
        pq.push(make_tuple(heightMap[r-1][c],r-1,c,r,c));
      }
    }
    if(!isOutBoundary(heightMap,r,c+1,R,C)){
      
      if(isOnBoundary(r,c+1,R,C)){
        
        boundary = min(boundary,heightMap[r][c+1]);
      }else if(graph[r][c+1]!=INT_MAX){
        boundary = min(boundary,graph[r][c+1]);
      }else if(!vis[r][c+1]){ 
        pq.push(make_tuple(heightMap[r][c+1],r,c+1,r,c));
      }
    }
    if(!isOutBoundary(heightMap,r,c-1,R,C)){
      if(isOnBoundary(r,c-1,R,C)){
        boundary = min(boundary,heightMap[r][c-1]);
      }else if(graph[r][c-1]!=INT_MAX){
        boundary = min(boundary,graph[r][c-1]);
      }else if(!vis[r][c-1]){
        pq.push(make_tuple(heightMap[r][c-1],r,c-1,r,c));
      }
    }
    cout<<boundary<<" row "<<r<<" col "<<c<<endl;

    graph[r][c]=boundary<=heightMap[r][c]?INT_MAX:boundary;
  }

  int result =0;

  
  for(int i=1;i<R-1;i++){
    for(int j=1;j<C-1;j++){
      if(graph[i][j]!=INT_MAX){
        result+= graph[i][j]-heightMap[i][j]  ;
      }
    }
  }
    cout<<result<<endl;
  
  return 0;
}
