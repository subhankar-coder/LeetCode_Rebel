#include<bits/stdc++.h>
using namespace::std;


int sum (int a ,int b){
    return (a+b);
}



int main(){

    int lhs=1;
    int rhs=2;

    auto cmp = [](char left, char right) {
        return left > right;    
    };

    priority_queue<char,vector<char>, decltype(cmp)>pq(cmp);

    pq.push('c');
    pq.push('f');
    pq.push('d');
    pq.push('h');
    pq.push('a');

    while(!pq.empty()){
        cout<<pq.top()<<endl;
        pq.pop();
    }

    
    
    string str;
    vector<int> v;
    while(getline(cin,str,' ')){
    	int ele = stoi(str);
    	v.push_back(ele);
    	
    };
    
    for(auto &i:v){
    	cout<<i<<endl;
    }

    return 0;
}
