#include<bits/stdc++.h>

using namespace std;

set<int> st;

int getUniqueCharOfARange(int start,int end,string s){
    st.clear();

    for(int i=start+1;i<end;i++){
        st.insert(s[i]);
    }

    return st.size();
}
int main(){
    string s = "aabca";

    map<char,pair<int,int>> mp;
    
    for(int i=0;i<s.length();i++){
        if(mp.find(s[i])!=mp.end()){
            mp[s[i]].second = i;
        }else{
            mp[s[i]]=make_pair(i,0);
        }
    }

    int count =0;

    map<char,pair<int,int>> :: iterator it = mp.begin();
    while(it!=mp.end()){
        pair<int,int> p = it->second;
        
        count+= getUniqueCharOfARange(p.first,p.second,s);
        

        ++it;
    }

    cout<<count<<endl;
    return 0;
}