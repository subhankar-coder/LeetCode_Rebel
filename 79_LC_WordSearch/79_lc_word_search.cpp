#include<bits/stdc++.h>
using namespace std;

int R=0;
int C=0;
bool isSafe(vector<vector<char>> board,int r ,int c,int index,string word){
	if(index>=word.length())
		return true;
	if(r<0 || r>=R || c<0 || c>=C || board[r][c]=='*' || board[r][c]!=word[index]){
		return false;
	}
	return true;
}
bool search(vector<vector<char>> board,int r,int c,int index,string word){
	if(index>=word.length())
		return true;
	bool isComplete=false;
	if(isSafe(board,r,c,index,word)){

		char ele = board[r][c];
		cout<<ele<<endl;
		board[r][c]='*';
		isComplete = search(board,r+1,c,index+1,word) || search(board,r-1,c,index+1,word) || search(board,r,c+1,index+1,word) || search(board,r,c-1,index+1,word);

		board[r][c]=ele;
	}
	return isComplete;
}

int main()
{
	vector<vector<char>> board= {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
	string word = "ABCCED";
	R = board.size();
	C= board[0].size();
	for(int i=0;i<board.size();i++){
		for(int j=0;j<board[i].size();j++){
			if(board[i][j]==word[0] && search(board,i,j,0,word)){
				cout<<"found"<<endl;
			}
		}
	}
	return 0;
}