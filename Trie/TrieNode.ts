class Trie{
    root:TrieNode
    constructor(){
        this.root=new TrieNode()
    }

    insert(key:string) {
        
        var keyLen:number = key.length
        var index:number
        var trieNode:TrieNode = this.root

        for(var level=0;level<keyLen;level++){
            index=key.charCodeAt(level)-97;
            if(trieNode){
                if(trieNode.children[index]==null)
                    trieNode.children[index]=new TrieNode()
                trieNode=trieNode.children[index]
            }
        }
        trieNode.isEndOfWord=true
    }

    search(key:string):boolean{
        var keyLen:number = key.length
        var index:number
        var trieNode:TrieNode = this.root

        for(var level=0;level<keyLen;level++){
            index=key.charCodeAt(level)-97
            if(trieNode){
                if( trieNode.children[index]==null){
                    return false
                }
                trieNode=trieNode.children[index]
            }
        }
        return trieNode.isEndOfWord
    }

    startsWith(key: string): boolean {
        var keyLen:number = key.length
        var index:number
        var trieNode:TrieNode = this.root

        for(var level=0;level<keyLen;level++){
            index = key.charCodeAt(level)-97
            if(trieNode){
                if(trieNode.children[index]==null)
                    return false
                trieNode=trieNode.children[index]
            }
        }
        return true
    }


}
export class TrieNode{

    static ALPHABET_SIZE:number=26
    isEndOfWord:boolean
    children: TrieNode[]=new Array(TrieNode.ALPHABET_SIZE)

    constructor(){
        this.isEndOfWord=false
        for(var i=0;i<TrieNode.ALPHABET_SIZE;i++){
            this.children[i]=null
        }
    }
 }

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */