package WordLadder;


import java.util.*;

public class WordLadder{

	private static TrieNode root;
	private static Set<String> set;

	public static void main(String[] args) {
		root = new TrieNode();
		set = new HashSet<>();
		List<String > wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
		String beginWord = "hit";
		String endWord = "cog";

		ladderLength(beginWord,endWord,wordList);
	}

	public static int ladderLength(String beginWord,String endWord,List<String> wordList){

		if(wordList.indexOf(endWord)==-1)
			return 0;

		for(String ele:wordList){
			insert(ele);
		}

		Queue<Pair> queue = new LinkedList<>();

		queue.offer(new Pair(beginWord,0));

		while(!queue.isEmpty()){

			Pair currentWord = queue.poll();
			System.out.println(currentWord.word+" "+currentWord.level);
			similarWords(endWord,currentWord,currentWord.word.length(),queue);
		}


		return 0;
	}

	public static void similarWords(String endWord,Pair begin,int n,Queue<Pair> queue){
		
		String beginWord = begin.word;
		int level = begin.level;
		int index = beginWord.charAt(0)-'a';
		TrieNode current=root;
		for(int i=0;i<n;i++){
			int currentIndex = beginWord.charAt(i)-'a';
			for(int j=0;j<26;j++){
				if(current.children[j]!=null){
					String last = i+1<n?beginWord.substring(i+1):"";
					String startWord = i>0?beginWord.substring(0,i):"";
					String str = startWord+Character.toString((char)j+97)+last;
					if(search(str) && !set.contains(str)){
						set.add(str);
						queue.offer(new Pair(str,level+1));
					}
				}
			}

			if(current.children[currentIndex]==null)
				break;

			current=current.children[currentIndex];

		}
	}

	public static void insert(String key){

		TrieNode current = root;
		for(int i=0;i<key.length();i++){
			int index = key.charAt(i)-'a';
			if(current.children[index]==null){
				current.children[index]=new TrieNode();
			}

			current=current.children[index];
		}
		current.endOfWord=true;
	}
	public static boolean search(String key){
		TrieNode current = root;

		for(int i=0;i<key.length();i++){
			int index = key.charAt(i)-'a';
			if(current.children[index]==null)
				return false;

			current=current.children[index];
		}
		return current.endOfWord;
	}
}

class TrieNode{

	private final int ELEMENT_NO=26;
	public TrieNode [] children;
	public boolean endOfWord = false;

	public TrieNode(){
		this.children=new TrieNode[ELEMENT_NO];
	}
}

class Pair{
	String word;
	int level;

	public Pair(String word,int level){
		this.word=word;
		this.level = level;
	}
}