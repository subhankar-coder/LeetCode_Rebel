#include<bits/stdc++.h>

using namespace std;

typedef long long ll;

int base =256;
int mod = 1e9+7;
ll calculateBase(int m){
	int basePower = 1;
	for(int i=0;i<m-1;i++){
		basePower = basePower*base%mod;
	}
	return basePower;
}
ll calculateHashValue(string str,int m){

	cout<<" word hash "<<str<<endl;
	ll hashValue =0;
	for(int i=0;i<m;i++){
		hashValue = (hashValue*base+str[i])%mod;
		cout<<"hash "<<hashValue<<" ";
	}
	cout<<endl;
	return hashValue;
}

ll calculateRollingHashValue(ll prevHash,char prevChar,char currChar,int m){
	ll basePower = calculateBase(m);
	prevHash = (prevHash - basePower*prevChar)%mod;
	prevHash = (prevHash*base+currChar)%mod;
	return (mod+prevHash)%mod;
}

bool isSuffix(string word,string pattern,int n ,int m){
	int init_hash_pattern = calculateHashValue(pattern,m);
	string substring = word.substr(0,m);
	cout<<substring<<endl;
	int init_hash_word = calculateHashValue(substring,m);
	cout<<" word "<<word<<" pattern "<<pattern<<endl;
	for(int i=0;i<=n-m;i++){
		if(init_hash_word==init_hash_pattern && i==(n-m)){
			cout<<"init hash "<<init_hash_pattern<<" inti hash word "<<init_hash_word<<endl;
			// cout<<"hash"<<i<<endl;
			return true;
		}

		if(i<n-m){
			init_hash_word = calculateRollingHashValue(init_hash_word,word[i],word[i+m],m);
		}
			
	}
		return false;
}

 
struct TrieNode{
	unordered_map<char,TrieNode*> children;
	vector<int> elements;
	bool endOfWord;

	TrieNode(){
		endOfWord = false;
	}
};
class Trie{
	private:
		TrieNode *root;
	public:
		Trie(){
			root = new TrieNode();
		}
		void insert(string word,int index){
			TrieNode *node = root;
			cout<<word<<endl;
			for(char ch:word){
				
				if(node->children.find(ch)==node->children.end()){
					
					node->children[ch]=new TrieNode();
					
				}
				node->children[ch]->elements.push_back(index);
				node = node->children[ch];
			}
			node->endOfWord = true;
			
		}
		vector<int> search_matching(string word){
			TrieNode *node = root;
			
			vector<int> result;
			for(char ch:word){
				if(node->children.find(ch)==node->children.end()){
					return vector<int>();
				}
				result = node->children[ch]->elements;
				node = node->children[ch];
				
			}
			return result;	
		}

		
};


int main(){
	vector<string> words = {"abab","ab"};
	Trie trie;
	int n = words.size();
	trie.insert(words[n-1],n-1);

	int result =0;
	for(int j=n-2;j>=0;j--){

		vector<int> res=trie.search_matching(words[j]);
		if(!res.empty()){
			
			for(int e : res){
				result += isSuffix(words[e],words[j],words[e].size(),words[j].size());
			}
		}
		// cout<<endl;
		trie.insert(words[j],j);
	}

	cout<<result<<endl;
	
	
	return 0;
}
