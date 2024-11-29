#include<bits/stdc++.h>
using namespace std;


vector<int> generateLPS(string &str){
    int n = str.length();
    vector<int> lps(n,0);

    int j=0,i=1;

    while(i<n){
        if(str[i]==str[j]){
            j++;
            lps[i]=j;
            i++;
        }else{
            if(j==0){
                lps[i]=0;
                i++;
            }else{
                j= lps[j-1];
            }
        }
    }
    return lps;
}

vector<int> search(string &str,int n,string &pattern,int m){
    
    vector<int> lps = generateLPS(pattern);
    vector<int> res ;

    int i=0,j=0;
    while(i<n){
        if(str[i]==str[j]){
            i++;
            j++;
            if(j==m){
                res.push_back(i-m);
                j=lps[j-1];
            }
        }else{
            if(j!=0){
                j=lps[j-1];
            }else{
                i++;
            }
        }
    }
    return res;

}
int main(){
    
    string str = "aabaacaadaabaaba";
    string pattern = "aaba";

    vector<int> res = search(str,str.length(),pattern,pattern.length());
    for(auto ele: res){
        cout<<ele<<endl;
    }
    
}