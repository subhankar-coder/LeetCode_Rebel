#include<bits/stdc++.h>

using namespace std;

int main(){

    string s = "1111";
    int n = s.length();
    int zeros [n];
    int ones [n];

    zeros[0]=s[0]=='0'?1:0;
    ones[n-1] = s[n-1]=='1'?1:0;
    for(int i=1,j=n-2;i<n && j>=0;i++,j--){
        zeros[i]=zeros[i-1]+(s[i]=='0'?1:0);
        ones[j]=ones[j+1]+(s[j]=='1'?1:0);
    }



    int max_ele = INT_MIN;
    for(int i=0;i<n-1;i++){
        max_ele = max(max_ele,zeros[i]+ones[i+1]);
    }

    cout<<max_ele<<endl;
    return 0;
}