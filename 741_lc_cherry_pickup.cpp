#include<bits/stdc++.h>

using namespace std;

int main(){
	vector<vector<int>> grid;
	string n;
	getline(cin,n);
	cout<<n<<endl;
	for(int i=0;i<=stoi(n);++i){
		vector<int> tmp ;
		string s;
		while(getline(cin,s,' ')){
			
			// tmp.push_back(num);
			cout<<stoi(s)<<" ";
		}
		// grid.push_back(tmp);
		cout<<endl;
		
	}
	
	// for(auto in:grid ){
		// for(auto &it: in){
			// cout<<it<<" ";
		// }
		// cout<<endl;
	// }
	return 0;
}
