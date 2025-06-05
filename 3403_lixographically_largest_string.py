class Solution:
    def answerString(self, word: str, numFriends: int) -> str:
        n = len(word)
        if n == numFriends:
            return max(word)
        lixi_string_size = n-numFriends+1
        if lixi_string_size == n:
            return word
        largestChar = max(word)
        res=""
        for i in range(n):
            if word[i]==largestChar:
                res = max(res,word[i:min(i+lixi_string_size,n)])
        
        return res
        





if __name__ == "__main__":
    word = "aann"
    numFriends = 2

    s = Solution()
    print(s.answerString(word,numFriends))  