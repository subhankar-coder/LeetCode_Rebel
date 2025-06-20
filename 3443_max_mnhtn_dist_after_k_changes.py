from collections import defaultdict

class Solution:
   def maxDistance(self, s: str, k: int) -> int:
      dct = defaultdict(int)
      res = float("-inf")
      for ele in s:
         dct[ele]+=1
         currMhtn = abs(dct['N']-dct['S'])+abs(dct['E']-dct['W'])
         convPair = min(dct['N'],dct['S'])+ min(dct['E'],dct['W'])
         print(currMhtn,convPair)
         res = max(res,currMhtn+min(convPair,k)*2) 
      
      return res



if __name__ == "__main__":
    s,k = "NWSE",1
    sol = Solution()
    print(sol.maxDistance(s,k))