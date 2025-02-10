#include<bits/stdc++.h>

using namespace std;

bool isValidEle(int r,int c,int R,int C,vector<vector<int>> &result){
// cout<<"row "<<r<<" col "<<c<<" matrix "<<result[r][c]<<R<<" "<<C<<endl;
    if(r>=R || r<0 || c>=C || c<0 || result[r][c]!=INT_MAX)
        return false;

    return true;
}

int main(){
	
	vector<vector<int>> isWater = {{0,1},{0,0}};
	
	int m = isWater.size();
	int n = isWater[0].size();
	

    vector<vector<int>> result (m,vector<int>(n,INT_MAX));
    
    queue<tuple<int,int,int>> q;
    
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(isWater[i][j]==1){
                result[i][j]=0;
                q.push(make_tuple(i,j,0));
            }
        }
    }

    // for(auto inner : result ){
    // 		for(int ele : inner){
    // 			cout<<ele<<" ";
    // 		}
    // 		cout<<endl;
    // 	}

    while(!q.empty()){
        auto fnt = q.front();
        q.pop();
        int r = get<0>(fnt);
        int c = get<1>(fnt);
        int h = get<2>(fnt);

        // cout<<"row "<<r<<" col "<<c<<" heigh"endl;
        
        if(isValidEle(r+1,c,m,n,result) ){
            result[r+1][c]=h+1;
            q.push(make_tuple(r+1,c,h+1));
            // cout<<"row "<<r+1<<" col "<<c<<" height "<<h<<endl;
        }
        if(isValidEle(r-1,c,m,n,result) ){
            result[r-1][c]=h+1;
            q.push(make_tuple(r-1,c,h+1));
            // cout<<"row "<<r-1<<" col "<<c<<" height "<<h<<endl;
        }
        if(isValidEle(r,c+1,m,n,result) ){
            result[r][c+1]=h+1;
            q.push(make_tuple(r,c+1,h+1));
            // cout<<"row "<<r<<" col "<<c+1<<" height "<<h<<endl;
        }
        if(isValidEle(r,c-1,m,n,result) ){
            result[r][c-1]=h+1;
            q.push(make_tuple(r,c-1,h+1));
            // cout<<"row "<<r<<" col "<<c-1<<" height "<<h<<endl;
        }
        
    }
	
}