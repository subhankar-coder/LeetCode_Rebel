#include<bits/stdc++.h>

using namespace std;


string getTransformedString(string str, int k){
    
    int len = str.length();
    if(k>=len){
        sort(str.begin(),str.end());
        return str;
    }

    string result = "";

    auto cmp = [](char a,char b){
        return a>b;
    };

    priority_queue<char,vector<char>,decltype(cmp)>pq(cmp);
    
    int i=0;
    
    for(const char ch:str){

        pq.push(ch);
        i++;
        if(i==k){
            char top = pq.top();
            result += top;
            pq.pop();
            i--;
        }
    }
    
    while(!pq.empty()){
        char top = pq.top();
        result += top;
        pq.pop();
    }


    return result;
}
int main(){

    string str = "edcba";
    int k =4;

    cout<<getTransformedString(str,k)<<endl;
}