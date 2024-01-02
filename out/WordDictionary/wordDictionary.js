class WordDictionary {
    constructor() {
        this.root = new TrieNode();
    }
    addWord(key) {
        var keyLen = key.length;
        var index;
        var trieNode = this.root;
        for (var level = 0; level < keyLen; level++) {
            index = key.charCodeAt(level) - 97;
            if (trieNode) {
                if (trieNode.children[index] == null)
                    trieNode.children[index] = new TrieNode(index);
                trieNode = trieNode.children[index];
            }
        }
        trieNode.isEndOfWord = true;
    }
    search(key) {
        var keyLen = key.length;
        var index;
        var trieNode = this.root;
        var refNodes = this.root.children;
        var match = false;
        for (var level = 0; level < keyLen; level++) {
            if (refNodes.length <= 0)
                return false;
            if (key.charAt(level) == ".") {
                if (level == keyLen - 1) {
                    refNodes.forEach(value => {
                        if (value && value.isEndOfWord) {
                            match = true;
                            return;
                        }
                    });
                    return match;
                }
                var childNodes = [];
                refNodes.forEach(value => {
                    if (value) {
                        value.children.forEach(node => {
                            if (node) {
                                childNodes.push(node);
                            }
                        });
                    }
                });
                refNodes = childNodes;
            }
            else {
                index = key.charCodeAt(level) - 97;
                if (level == keyLen - 1) {
                    refNodes.forEach(value => {
                        if (value.val == index && value.isEndOfWord) {
                            match = true;
                            return;
                        }
                    });
                    return match;
                }
                var childNodes = [];
                refNodes.forEach(value => {
                    if (value && value.val == index) {
                        value.children.forEach(node => {
                            if (node) {
                                childNodes.push(node);
                            }
                        });
                    }
                });
                refNodes = childNodes;
            }
        }
        return trieNode.isEndOfWord;
    }
}
class TrieNode {
    constructor(val = -1) {
        this.children = new Array(TrieNode.ALPHABET_SIZE);
        this.val = val;
        this.isEndOfWord = false;
        for (var i = 0; i < TrieNode.ALPHABET_SIZE; i++) {
            this.children[i] = null;
        }
    }
}
TrieNode.ALPHABET_SIZE = 26;
var wordDictionary = new WordDictionary();
//  wordDictionary.addWord("bad");
//  wordDictionary.addWord("dad");
//  wordDictionary.addWord("mad");
//  console.log(wordDictionary.search("pad")); // return False
// console.log( wordDictionary.search("bad")); // return True
//  console.log(wordDictionary.search(".ad")); // return True
//  console.log(wordDictionary.search("b.."));
wordDictionary.addWord("a");
wordDictionary.addWord("ab");
wordDictionary.addWord("a");
// wordDictionary.addWord("add")
console.log(wordDictionary.search(".a"));
// console.log(wordDictionary.search(".at"));
// wordDictionary.addWord("bat")
// console.log(wordDictionary.search(".at"));
// console.log(wordDictionary.search("an."))
/**
 * [[],["at"],["and"],["an"],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = new WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */ 
//# sourceMappingURL=wordDictionary.js.map