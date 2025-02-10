#include<bits/stdc++.h>
using namespace std;

typedef long long ll;
int main(){
		vector<vector<int>> grid = {{3,3,21},{18,15,2}};
		int C = grid[0].size();

		ll sum_r1 =0,sum_r2=0;
		ll first_row[C]={};
		ll second_row[C]={};
		for(int i=1,j=C-2;i<C && j>=0;i++,j--){
			sum_r1+=grid[0][i];
			first_row[i]=sum_r1;
			sum_r2+=grid[1][j];
			second_row[j]=sum_r2;
		}
		ll result = INT_MAX;
		for(int i=0;i<C;i++){
			result = min(result,max(sum_r1-first_row[i],sum_r2-second_row[i]));
		}
		cout<<result<<endl;
	
	
	return 0;
}
