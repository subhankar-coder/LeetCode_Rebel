from typing import List

class Solution:
    def lexicalOrder(self, n: int) -> List[int]:
        res : List[int] = []
        div = n // 10
        mod = n % 10

        def helper(div,mod,word,k):
            print(word)
            start = 1 if word == 0 else 0
            for i in range(start,10,1):
                currWord = word*10+i
                if  currWord//10 <= div : 
                    if currWord % 10 <= mod or currWord//10 < div :
                        res.append(currWord)
                        helper(div,mod,currWord)

        # helper(div,mod,0)
        return res




if __name__ == "__main__":
    n = 13
    s = Solution()
    print(s.lexicalOrder(n))