#include<bits/stdc++.h>

using namespace std;

int main(){

    vector<int> nums = {9,9,9};
    vector<int> fwdSum ;
    vector<int> bkwSum(nums.size());

    int sum =0;
    int bkSum=0;

    int count =0;

    for(int i=0,j=nums.size()-1;i<nums.size() && j>=0;i++,j--){
        sum+=nums[i];
        bkSum+=nums[j];
        fwdSum.push_back(sum);
        bkwSum[j]=bkSum;
    }

    

    for(int i=0;i<nums.size();i++){
        cout<<fwdSum[i]<<" "<<bkwSum[i]<<endl;
        // if(fwdSum[i-1]>=bkwSum[i]){
        //     count++;
        // }
    }

    cout<<count<<endl;
    return 0;
}