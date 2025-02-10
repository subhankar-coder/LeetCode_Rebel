#include<bits/stdc++.h>
using namespace std;

int main(){
	vector<int> arr= {2,8,7,4,1,3,5,6,9};
	vector<vector<int>> mat = {{3,2,5},{1,4,6},{8,7,9}};

	int R = mat.size();
	int C = mat[0].size();

	int rows[R]={0};
	int cols[C]={0};

	vector<pair<int,int>> v(R*C,make_pair(0,0));
	for(int i=0;i<R;i++){
		for(int j=0;j<C;j++){
			int ele = mat[i][j];
			v[ele-1].first = i;
			v[ele-1].second = j;
		}
	}
	for(int i=0;i<arr.size();i++){
		
		pair<int,int> p = v[arr[i]-1];
		int r=p.first;
		int c = p.second;
		rows[r]++;
		if(rows[r]==C){
			cout<<"rows index "<<i<<endl;
			return i;
		}
		cols[c]++;
		if(cols[c]==R){
			cout<<"cols index "<<i<<endl;
			return i;
		}
	}
	
	return 0;
}
