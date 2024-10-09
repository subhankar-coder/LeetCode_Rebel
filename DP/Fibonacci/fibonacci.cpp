#include<bits/stdc++.h>

#define MOD 1000000007

typedef long long int ll;

using namespace::std;

int fibonacci(int n){

    if(n<=1){
        return n;
    }
    
    ll dp [n+1];
    dp[0]=0;
    dp[1]=1;
    

    for (int i=2;i<=n;i++){
        dp[i]=(dp[i-1]+dp[i-2])%MOD ;
    }

    int result = (int)(dp[n]%MOD);

    return result;

}

int main(){

   int n = 5;
   int res = fibonacci(n);

   cout<<res<<endl;
}