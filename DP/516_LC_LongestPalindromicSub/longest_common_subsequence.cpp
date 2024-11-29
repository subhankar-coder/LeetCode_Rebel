#include<bits/stdc++.h>

using namespace std;

int main(){
    string str = "cbbd";
    int n = str.length();

    int max_len=1;

    int dp [n][n];
    for(int i=0;i<n;i++){
        dp[i][i]=1;
        if(i<n-1){
            if(str[i]==str[i+1]){
                dp[i][i+1]=2;
                max_len=2;
            }
            else{
                dp[i][i+1]=1;
            }            
        }
    }


    for(int i=2;i<n;i++){
        for(int j=0;j+i<n;j++){
            int k = i+j;
            if(str[j]==str[k]){
                dp[j][k] = 2+dp[j+1][k-1];
                max_len = max(max_len,dp[j][k]);
            }else{
                dp[j][k] = max(dp[j][k-1],dp[j+1][k]);
            }
        }
    }

    // for(int i=0;i<n;i++){
    //     for(int j=0;j<n;j++){
    //         cout<<dp[i][j]<<" ";
    //     }
    //     cout<<endl;
    // }

    cout<<max_len;
    return 0;
}