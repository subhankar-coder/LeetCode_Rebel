#include<bits/stdc++.h>

using namespace std;

int main(){

  vector<int> nums1={1,2};
  vector<int> nums2 = {3,4};


  int len1 = nums1.size()%2;
  int len2 = nums2.size()%2;

  int result =0;

  if(len2!=0){
    for(int num : nums1){
      result = result^num;
    }
  }

  if(len1!=0){
    for(int num: nums2){
      result = result ^num;
    }
  }


  cout<<result<<endl;
  return 0;
}
