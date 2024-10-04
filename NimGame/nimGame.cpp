#include<bits/stdc++.h>

using namespace::std;

unordered_map<string,bool> mp; 

bool nimGameHelper(int n ,bool isSelf){

    string whichone = isSelf?"first":"second";
    string key = to_string(n).append(whichone);
    cout<<"current key "<<key<<endl;
    if(n<=3){
        return isSelf;
    }
    auto it = mp.find(key);
    if(it!=mp.end()){
        cout<<"cache "<<key <<it->second<<endl;
        return it->second;
    }

    bool iswin = true;
    for(int i=1;i<=3;i++){
        if(!isSelf){
            cout<<"second "<<i<<" "<<n<<" "<<endl;;
            iswin = (iswin && nimGameHelper(n-i,!isSelf));
            cout<<"second "<<iswin<<endl;
        }
        else{
            cout<<"first "<<i<<" "<<n<<endl;
            iswin=nimGameHelper(n-i,!isSelf);
            cout<<"first "<<iswin<<endl;
            if(iswin){
                // mp[n]=iswin;
                return iswin;
            }
        }
    }
    // cout<<iswin<<endl;
    mp[key]=iswin;
    return iswin;
}
bool nimGame(int n){
    // return nimGameHelper(n,true);
    return n%4==0?false:true;
}
int main(){
    int n =1348820612;

    
    cout<<nimGame(n)<<endl;

    return 0;
}