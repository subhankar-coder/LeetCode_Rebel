from collections import defaultdict

class Solution:
    def minimumDeletions(self, word: str, k: int) -> int:
        dct = defaultdict(int)
        for ele in word:
            dct[ele]+=1

        res = float("inf")
        li = list(dct.keys())
        
        for ele in li:
            freq = dct[ele]
            total = 0
            for itr in list(dct.items()):
                if ele != itr[0]:
                    if itr[1] < freq:
                        total+=itr[1]
                    elif itr[1] > freq+k:
                        total += itr[1] - freq-k
            res = min(res,total)

        return res





if __name__ == "__main__":
    word,k = "aabcaba",0
    sol = Solution()
    print(sol.minimumDeletions(word,k))