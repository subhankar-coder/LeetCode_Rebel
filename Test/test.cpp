#include<bits/stdc++.h>
using namespace::std;


int sum (int a ,int b){
    return (a+b);
}

vector<pair<int,int>> twoSum(vector<int>& arr, int target, int n)
{
	// vector<int> arr = {1 ,-1, -1 ,2 ,2};
    vector<pair<int,int>> result;
    sort(arr.begin(),arr.end());
    
    int i =0;
    int j = n-1;

    while(i<j){
        int sum = arr[i]+arr[j];

        // cout<<sum<<endl;
        if(sum==target){
			
            result.push_back(make_pair(arr[i],arr[j]));
			i++;
			j--;
        }
        else if(sum < target){
            i++;
        }else{
            
            j--;
        }
    }

	if(result.size()==0){
		result.push_back(make_pair(-1,-1));
	}

	return result;

}

int main(){

    vector<int> arr = {1 ,0 ,0 ,1 ,1};
    
    int target = 2;
    int n = 5;

    vector<pair<int,int>> res = twoSum(arr,target,n);

    for (auto i= res.begin();i!=res.end();++i){
        cout<<(*i).first<< " "<<(*i).second <<" "<<endl;
    }

    return 0;
}
