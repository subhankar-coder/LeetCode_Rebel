from typing import List


class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        mp = {}
        count = 0
        addhoc = 0
        for word in words:
            mp[word] = mp.get(word,0)+1

        print(mp)

        for key in list(mp.keys()):
           print(key,list(mp.keys()))
           if key in mp.keys():
            if key[0] == key[1]:
                count += mp[key]//2
                addhoc = max(addhoc,mp[key]%2)  
                del mp[key]
            else:
                if key[::-1] in mp.keys():
                    count += min(mp[key],mp[key[::-1]])
                    del mp[key[::-1]]
                del mp[key]
                
        return count*4+addhoc*2






if __name__ == "__main__":
    s = Solution()
    words: List[str] = ["cc","ll","xx"]
    print(s.longestPalindrome(words))
