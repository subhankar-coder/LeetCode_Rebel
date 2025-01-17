#include<bits/stdc++.h>
using namespace std;

int main(){

  string boxes = "001011";

  vector<int> nums;

  for(char ch: boxes){
    nums.push_back(ch-'0');
  }
  int len = nums.size();

  int right [len];
  int left[len];

  memset(right,0,sizeof(right));
  memset(left,0,sizeof(left));

  int count_fwd =nums[0]==0?0:1;

  for(int i=1;i<len;i++){
    right[i]=right[i-1]+count_fwd;
    // cout<<"count "<<count_fwd<<endl;
    count_fwd += nums[i];
  }

  int count_bwd = nums[len-1]==0?0:1;

  for(int i=len-2;i>=0;i--){
    left[i]=left[i+1]+count_bwd;
    count_bwd+=nums[i];
  }

  vector<int> result(len,0);


  for(int i=0;i<len;i++){
    result[i]=right[i]+left[i];
  }

  for(int val :result){
    cout<<val<<endl;
  }



  return 0;
}
