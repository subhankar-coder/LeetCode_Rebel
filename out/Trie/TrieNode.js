"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.TrieNode = void 0;
class Trie {
    constructor() {
        this.root = new TrieNode();
    }
    insert(key) {
        var keyLen = key.length;
        var index;
        var trieNode = this.root;
        for (var level = 0; level < keyLen; level++) {
            index = key.charCodeAt(level) - 97;
            if (trieNode) {
                if (trieNode.children[index] == null)
                    trieNode.children[index] = new TrieNode();
                trieNode = trieNode.children[index];
            }
        }
        trieNode.isEndOfWord = true;
    }
    search(key) {
        var keyLen = key.length;
        var index;
        var trieNode = this.root;
        for (var level = 0; level < keyLen; level++) {
            index = key.charCodeAt(level) - 97;
            if (trieNode) {
                if (trieNode.children[index] == null) {
                    return false;
                }
                trieNode = trieNode.children[index];
            }
        }
        return trieNode.isEndOfWord;
    }
    startsWith(key) {
        var keyLen = key.length;
        var index;
        var trieNode = this.root;
        for (var level = 0; level < keyLen; level++) {
            index = key.charCodeAt(level) - 97;
            if (trieNode) {
                if (trieNode.children[index] == null)
                    return false;
                trieNode = trieNode.children[index];
            }
        }
        return true;
    }
}
class TrieNode {
    constructor() {
        this.children = new Array(TrieNode.ALPHABET_SIZE);
        this.isEndOfWord = false;
        for (var i = 0; i < TrieNode.ALPHABET_SIZE; i++) {
            this.children[i] = null;
        }
    }
}
exports.TrieNode = TrieNode;
TrieNode.ALPHABET_SIZE = 26;
/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */ 
//# sourceMappingURL=TrieNode.js.map