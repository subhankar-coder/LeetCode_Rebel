#include<bits/stdc++.h>

using namespace::std;

int MIN=0;
int min_val = INT_MAX;

void allTwoSum(vector<int>& nums,int start,int end,int target){
    int i=start;
    while(start<end){
      int sum = nums[start]+nums[end];

      if(min_val >abs(target-sum)){
        cout<<sum<<" "<<min_val<<" "<<target<<endl;
        min_val=abs(target-sum);
        MIN=sum+nums[i-1];
      }
    //   min_val = min(min_val,abs(target-sum));
      if(sum<target){
        start++;
      }else{
        end--;
      }
    }

    // MIN = min(MIN,min_val);
}
void threeSumClosest(vector<int>& nums, int target) {
    int n = nums.size();
    for(int i=0;i<n;i++){
        allTwoSum(nums,i+1,n-1,target-nums[i]);
    }

    cout<<MIN<<endl;
}
int main(){

    vector<int> nums = {4,0,5,-5,3,3,0,-4,-5};
    int target =-2;
    sort(nums.begin(),nums.end());
    threeSumClosest(nums,target);
    return 0;
}
