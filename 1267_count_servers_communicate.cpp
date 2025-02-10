#include<bits/stdc++.h>

using namespace std;

int main(){
	vector<vector<int>> grid = {{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
	int m = grid.size();
	int n = grid[0].size();

	int row [m]={};
	int col [n]={};

	int total_number=0;

	for(int i=0;i<m;i++){
		for(int j=0;j<n;j++){

			if(grid[i][j]==1){
				// total_number++;
				row[i]++;
				col[j]++;
			}
		}
	}

	for(int i=0;i<m;i++){
		for(int j=0;j<n;j++){
			if(grid[i][j]==1){
				int num_comp_row = row[i]-1;
				int num_comp_col = col[j]-1;

				

				if(num_comp_row!=0 || num_comp_col!=0){
					// cout<<i<<" "<<j<<endl;
					total_number++;
				}
			}
		}
	}
	
	cout<<total_number<<endl;
	return 0;
}

