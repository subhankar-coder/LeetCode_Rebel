#include<bits/stdc++.h>

using namespace std;

int main(){

    vector<int> derived = {1,1,0};
    int sum =0;

      for(int ele: derived){
          sum=sum^ele;
      }
      cout<<sum<<endl;
  return 0;
}
