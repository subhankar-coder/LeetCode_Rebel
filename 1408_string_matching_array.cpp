#include<bits/stdc++.h>

using namespace std;


vector<int> constructLPSArray(string pattern){

    int m = pattern.length();
    vector<int> lsp(m,0);
    int i=1,j=0;

    while(i<m){
        if(pattern[i]==pattern[j]){
            j++;
            lsp[i]=j;
            i++;
        }else{
            if(j==0){
                lsp[i]=j;
                i++;
            }else{
                j=lsp[j-1];
            }
        }
    }
    return lsp;
}

bool kmpAlgoSearch(string concatenatedWord,string pattern){

    int n = concatenatedWord.length();
    int m = pattern.length();

    vector<int> lpsArray = constructLPSArray(pattern);

    int i=0,j=0;
    while(i<n){
        if(pattern[j]==concatenatedWord[i]){
            i++;
            j++;
            if(j==m){
                return true;
            }
        }else{
            if(j==0){
                i++;
            }else{
                j=lpsArray[j-1];
            }
        }
    }
    return false;
}

int main(){

    vector<string> words = {"mass","as","hero","superhero"};
    sort(words.begin(),words.end(),[](string a,string b){
        return a.length()>b.length();
    });
    string str=words[0];
    
    for(int i=1;i<words.size();i++){
        if(kmpAlgoSearch(str,words[i])){
            cout<<words[i]<<endl;
        }
        str+="$"+words[i];
    }

    return 0;
}
