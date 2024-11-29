#include<bits/stdc++.h>
using namespace std;

	vector<string> result;
	struct TrieNode{

		TrieNode *children[26];

		bool wordEnd;

		TrieNode(){
			wordEnd=false;
			for(int i=0;i<26;i++){
				children[i]=NULL;
			}
		}
	};

void insertKey(TrieNode *root,string key){
	TrieNode *curr = root;
	for(char c:key){
		if(curr->children[c-'a'] == nullptr){

			TrieNode *next = new TrieNode();
			curr->children[c-'a']=next;
		}
		curr = curr->children[c-'a'];
	}
	curr->wordEnd=true;
}

bool isSafe(TrieNode *root,vector<vector<char>> board,int row,int col ,int R,int C){
	if(row<0 || row>=R || col<0 || col>=C || board[row][col]=='*' || root->children[board[row][col]-'a']==nullptr){
		return false;
	}
	return true;
}
void searchKey(TrieNode *root,vector<vector<char>> board,int row,int col ,int R,int C,string res){

	TrieNode *curr = root;
	if(curr->wordEnd==true){
		result.push_back(res);
		curr->wordEnd=false;
	}
	if(isSafe(curr,board,row,col,R,C)){
		char c = board[row][col];
		board[row][col]='*';

		searchKey(curr->children[c-'a'],board,row+1,col,R,C,res+c);
		searchKey(curr->children[c-'a'],board,row-1,col,R,C,res+c);
		searchKey(curr->children[c-'a'],board,row,col+1,R,C,res+c);
		searchKey(curr->children[c-'a'],board,row,col-1,R,C,res+c);
		// searchKey(curr->children[c-'a'],board,row+1,col+1,R,C,res+c);
		// searchKey(curr->children[c-'a'],board,row-1,col-1,R,C,res+c);
		// searchKey(curr->children[c-'a'],board,row-1,col+1,R,C,res+c);
		// searchKey(curr->children[c-'a'],board,row+1,col-1,R,C,res+c);

		board[row][col]=c;
	}
	
}


int main(){

	vector<string> words = {"CAT"};
	vector<vector<char>> board = {{'C','A','P'},{'A','N','D'},{'T','I','E'}};
	
	TrieNode *root = new TrieNode();
	for(string str: words){
		
		insertKey(root,str);
	}

	// cout<<searchKey(root,"ear");

	int r = board.size();
	int c = board[0].size();

	for(int i=0;i<r;i++){
		for(int j=0;j<c;j++){
			searchKey(root,board,i,j,r,c,"");
		}
	}

	for(string res : result ){
		cout<<res<<endl;
	}
	return 0;
}