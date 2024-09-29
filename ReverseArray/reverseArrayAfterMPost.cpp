#include<bits/stdc++.h>

using namespace::std;


void reverseArray(vector<int> &arr , int m) {
    int len = arr.size();
    
    int i = m+1,j=len-1;
    while(i<j){
        int temp = arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
        i++;
        j--;
    }

    for (auto i=arr.begin();i!=arr.end();++i){
        cout<<*i<<endl;
    }       	
}

int main(){
    vector<int> arr = {1, 2, 3, 4, 5, 6};
    int M=3;
    reverseArray(arr,M);
    return 0;
}