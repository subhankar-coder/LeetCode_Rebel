#include<bits/stdc++.h>

using namespace::std;


set<vector<int>> twosum(vector<int> arr, int start,int end,int K){
    set<vector<int>> res;
    unordered_map<int,int> map;

    auto it= map.find(arr[start]);
        if(it!=map.end()){
            // cout<<it->first<<endl;  
            res.insert({arr[(*map.find(arr[start])).second],arr[start]});
        }
        else{
            
            map.insert({K-arr[start],start});
        }
        // last_ele=arr[start];
        start++;
    
    // cout<<endl;
    
    return res;
}

vector<vector<int>> findTriplets(vector<int>arr, int n, int K) {
    set<vector<int>> result;
    
    for(int i=0;i<n-1;i++){
        set<vector<int>> res = twosum(arr,i+1,n,K-arr[i]);
        for( auto &row : res){
            const_cast<vector<int>&>(row).insert(row.begin(),arr[i]);
        }
        const_cast<set<vector<int>>&>(result).insert(res.begin(),res.end());
    }

    vector<vector<int>> vc(result.begin(),result.end());
    
    return vc;

}


int main(){
    vector<int> arr = {-1,0,1,2,-1,-4};
    sort(arr.begin(),arr.end());
    int n = 6;
    int K = 0;
    vector<vector<int>> result = findTriplets(arr,n,K);


    for(const auto &row:result){
        for(const auto &col:row ){
            cout<<col<<" ";
        }
        cout<<endl;
    }

}