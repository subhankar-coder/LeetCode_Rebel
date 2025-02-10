#include<bits/stdc++.h>
using namespace std;

bool detectACyclic(int startNode,vector<int> &visited,vector<int> &recStack,vector<vector<int>> &neighbours){


        visited[startNode]=1;
        recStack[startNode]=1;

        for(int ele: neighbours[startNode]){

            if(visited[ele]!=1 && !detectACyclic(ele,visited,recStack,neighbours)){
                return false;
            }
            else if(recStack[ele]==1)
                return false;
        }
        recStack[startNode]=0;

        return true;

}

bool detectSafeState(int startNode,vector<int> &visited,vector<vector<int>> &neighbours,vector<int> &safe_node){
    if(visited[startNode]==1){
        return safe_node[startNode]==1;
    }
    visited[startNode]=1;
    for(int ele : neighbours[startNode]){
        if(visited[i]!=1 && !detectSafeState(ele,visited,neighbours,safe_node)){
            return false;
        }
    }
    safe_node[startNode]=1;
    return true;
}

int main(){


    vector<vector<int>> graph = {{1,2},{2,3},{5},{0},{5},{},{}};
    int n = graph.size();
    for(int i=0;i<n;i++){
        vector<int> visited(n,0);
        vector<int> recStack(n,0);
        cout<<detectACyclic(i,visited,recStack,graph)<<" ";
    }
    return 0;
}
