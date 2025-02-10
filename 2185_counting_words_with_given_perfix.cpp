#include<bits/stdc++.h>
using namespace std;

struct TrieNode{
	unordered_map<char,TrieNode*> children;
	int count;

	TrieNode(){
		count =0;
	}
};

class Trie{
	private:
		TrieNode *root;
	public:
		Trie(){
			root = new TrieNode();
		}
		void insert(string str){
			TrieNode *node = root;
			for(char ch: str){
				if(node->children.find(ch)==node->children.end()){
					node->children[ch]=new TrieNode();
				}
				node->children[ch]->count+=1;
				node = node->children[ch];
			}
		}
		
		int search_matching(string pattern){
			TrieNode *node = root;
			int c =0;
			for(char ch: pattern ){
				if(node->children.find(ch)==node->children.end()){
					return 0;
				}
				c = node->children[ch]->count;
				node =node->children[ch];
			}

			return c;
		}
};

int main (){
	vector<string> words = {"pay","attention","practice","attend"};
	string pref = "at";

	Trie trie;
	for(string word : words){
		trie.insert(word);
	}
	cout<<trie.search_matching(pref)<<endl;
	return 0;
}
