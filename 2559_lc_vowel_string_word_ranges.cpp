#include<bits/stdc++.h>

using namespace std;

vector<char> vowels = {'a','e','i','o','u'};
bool isVowelString(string str){
    char begin = str[0];
    char end = str[str.length()-1];

    auto it_begin = find(vowels.begin(),vowels.end(),begin);
    auto it_end = find(vowels.begin(),vowels.end(),end);

    return it_begin!=vowels.end() && it_end!=vowels.end();
}
int main(){

    vector<string> words = {"a","e","i"};
    vector<vector<int>> queries = {{0,2},{0,1},{2,2}};
    
    vector<int> sum;
    vector<int> result;

    int i=0;
    for(const string word : words){

        int flag = isVowelString(word)?1:0;
        if(i!=0){
            flag+=sum[i-1];
        }
        
        sum.push_back(flag);
        // cout<<sum[i]<<endl;
        i++;    
    }

    for(vector vec : queries){
        int begin = vec[0];
        int end = vec[1];
        
        if(begin==end){
            result.push_back(begin==0?sum[end]:(sum[end]-sum[begin-1]));
        }else{

            int start =begin==0?0:sum[begin-1]; 
            int finish = sum[end];

            result.push_back(finish-start);

        }
        
    }

    for(const int i : result){
        cout<<i<<endl;
    }
    return 0;
}