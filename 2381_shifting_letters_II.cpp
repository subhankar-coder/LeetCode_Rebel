#include<bits/stdc++.h>

using namespace std;



int main(){

    string s = "abc";
    
    vector<vector<int>> shifts =  {{0,1,0},{1,2,1},{0,2,1}};

    int len = s.length();

    vector<int> chArray;

    for(char ch: s){
        chArray.push_back((int)ch-96);
    }

    vector<int> diff(len+1,0);

    diff[0]=chArray[0];
    for(int i=1;i<len;i++){
        diff[i]=chArray[i]-chArray[i-1];
    }

    for(vector<int> inner: shifts){
        
        int l = inner[0];
        int r = inner[1];
        int x = inner[2]==0?-1:1;

        diff[l]= diff[l]+x;
        diff[r+1] = diff[r+1]-x;

    }

    for(int i=0;i<len;i++){
        if(i==0){
            chArray[i]=diff[i];
        }else{
            chArray[i]=chArray[i-1]+diff[i];
        }
    }

    for(int i=0;i<len;i++){
        int reminder = chArray[i]%26;

        reminder = reminder<=0?reminder+26:reminder;

        s[i]=(char)(reminder+96);
    }

    cout<<s<<endl;
    
    return 0;
}