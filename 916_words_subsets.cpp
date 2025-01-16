#include<bits/stdc++.h>

using namespace std;

int main(){
    vector<string> words1 ={"amazon","apple","facebook","google","leetcode"};
    vector<string> words2 = {"lo","eo"};

    map<char,int> wordsmap;
    map<char,int> universalMap;

    vector<string> result;

    for(string word: words2){
      map<char,int> temp;
      for(char ch : word){

        if(temp.find(ch)!=temp.end()){
          temp[ch]=temp[ch]+1;
        }else{
          temp.insert({ch,1});
        }
      }

      for(auto it = temp.begin();it!=temp.end();++it){
        if(wordsmap.find(it->first)!=wordsmap.end()){
          wordsmap[it->first]=max(wordsmap[it->first],it->second);
        }else{
          wordsmap.insert({it->first,it->second});
        }
      }
    }

    for(string word: words1){
      bool flag =true;
      universalMap.clear();
      for(char ch: word){
        if(universalMap.find(ch)!=universalMap.end()){
          universalMap[ch]=universalMap[ch]+1;
        }else{
          universalMap.insert({ch,1});
        }
      }
      for(auto itr=wordsmap.begin();itr!=wordsmap.end();++itr){
        char key = itr->first;
        int val = itr->second;

        if(universalMap.find(key)==universalMap.end()){
          // cout<<word;
          flag=false;
          break;
        }

        if(universalMap[key]<val){

          // cout<<word;
          flag =false;
          break;
        }

      }
      if(flag){
        result.push_back(word);
      }
    }

    for(auto word: result){
      cout<<word<<endl;

    }

    return 0;
}
