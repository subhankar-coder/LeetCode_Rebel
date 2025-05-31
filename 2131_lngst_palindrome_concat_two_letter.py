from typing import List


class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        mp = {}
        s = set()
        count = 0
        for word in words:
            if word[0] == word[1]:
                count+=2
            else:
                key = min(word[0],word[1])+max(word[0],word[1])
                s.add(key)
                mp[word] = mp.get(word,0)+1
        for key in list(mp.keys()):
            if key[::-1] in mp:
                count += 4*min(mp[key],mp[key[::-1]])
                mp.pop(key)
                mp.pop(key[::-1])
        return count






if __name__ == "__main__":
    s = Solution()
    words: List[str] = ["cc","ll","xx"]
    print(s.longestPalindrome(words))
