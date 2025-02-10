#include<bits/stdc++.h>

using namespace std;

int main(){

	string s= "(()())";
	string locked = "111111";

	int n = s.length();
	// stack<int> st;
	stack<pair<int,int>> st;
	int free_index=0;
	// string str="";

	if(n%2 == 1 || (s[0]==')'&& locked[0]=='1') || (s[n-1]=='(' && locked[n-1]=='1')){
		cout<<"no more room"<<endl;
		return 0;
	}
	for(int i=0;i<n;i++){
		if(locked[i]=='0'){
			free_index++;
			// st.push()
			// str+="*";
		}else{
			if(s[i]=='('){
				st.push(make_pair(i,free_index));
				// str+="("
			}else{
				if(!st.empty()){
					auto last_open = st.top();
					cout<<last_open.first<<" "<<last_open.second<<endl;
					if((free_index-last_open.second)%2 ==0 ){
						st.pop();
						free_index= last_open.second;
					}else if(free_index>0){
						free_index--;
					}
				}else if(free_index!=0){
					free_index --;
				}else{
					cout<<"no more free "<<endl;
					return 0;
				}
			}

			
		}
	}

	cout<<st.size()<<endl;
	while(!st.empty()){
		
		int free_before = st.top().second;
		// cout<<st.top().first<<" "<<free_before<<endl;
		st.pop();
		if((free_index-free_before ==0 )){
			return 0;
		}
		free_index=free_before;
	}
	cout<<"success"<<endl;

	
	return 0;
}
