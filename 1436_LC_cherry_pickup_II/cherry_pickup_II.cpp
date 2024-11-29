#include<bits/stdc++.h>

using namespace std;


int pickUpCherry(int row,int col1,int col2,vector<vector<int>> grid,vector<vector<vector<int>>> &   dp,int R,int C){

    if(col1<0 || col1>=C || col2<0 || col2>=C || row>=R){
        return 0;
    }

    if(dp[row][col1][col2]!=-1)
        return dp[row][col1][col2];
    

    int cherry = (col1==col2)?grid[row][col1]:grid[row][col1]+grid[row][col2];
    int max_cherry = INT_MIN;

    for(int i=-1;i<=1;i++){
        for(int j=-1;j<=1;j++){
            max_cherry=max(max_cherry,pickUpCherry(row+1,col1+i,col2+j,grid,dp,R,C));
        }
    }

    return dp[row][col1][col2] = (cherry+max_cherry);
    
}

void cherry_pickup_bottom_up(vector<vector<int>> grid){
    
    int R = grid.size();
    int C = grid[0].size();

    vector<vector<int>> dpCurrent (C,vector<int>(C,-1));
    vector<vector<int>> dpNext (C,vector<int>(C,-1));

    dpCurrent[0][C-1]=grid[0][0]+grid[0][C-1];

    for(int i=1;i<R;i++){
        for(int j1=0;j1<C;j1++){
            for(int j2=0;j2<C;j2++){

                int cherries = grid[i][j1]+(j1!=j2)*(grid[i][j2]);

                for(int prevj1=-1+j1;prevj1<=j1+1;prevj1++){
                    for(int prevj2=-1+j2;prevj2<=j2+1;prevj2++){
                        if(prevj1>=0 && prevj1<C && prevj2>=0 && prevj2<C && dpCurrent[prevj1][prevj2]!=-1){
                            dpNext[j1][j2] = max(dpNext[j1][j2],cherries+dpCurrent[prevj1][prevj2]);
                        }
                    }
                }
            }
        }
       
        swap(dpCurrent,dpNext);
        fill(dpNext.begin(),dpNext.end(),vector<int>(C,-1));
    }

    int max_cherries = 0;

    for(auto v:dpCurrent){
        for(int ele: v){
            max_cherries = max(max_cherries,ele);
        }
    }

    cout<<max_cherries<<endl;    
    
}

int main(){

    vector<vector<int>> grid = {{1,0,0,0,0,0,1},{2,0,0,0,0,3,0},{2,0,9,0,0,0,0},{0,3,0,5,4,0,0},{1,0,2,3,0,0,6}};
    int R = grid.size();
    int C = grid[0].size();
    vector<vector<vector<int>>> dp (R,vector<vector<int>>(C,vector<int>(C,-1)));

    // cout<<pickUpCherry(0,0,C-1,grid,dp,R,C);
    // for(auto r:dp){
    //     for(auto c1 :r){
    //         for(auto c2: c1){
    //             cout<<c2<<" ";
    //         }

    //         cout<<endl;
    //     }
    //     cout<<endl;
    // }
    cherry_pickup_bottom_up(grid);

    return 0;
}