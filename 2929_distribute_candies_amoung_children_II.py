import math

class Solution:
    def distributeCandies(self, n: int, m: int) -> int:
      k = 3
      total=0
      for j in range(k+1):
        sign = (-1) ** j
        group_choices = math.comb(k,j)
        remaining = n -j*(m+1)
        if remaining < 0:
          term = 0
        else:
          term = math.comb(remaining+k-1,k-1)
        
        total += sign * group_choices * term
        
      return total
      
      

if __name__ == "__main__":
  s = Solution()
  n,limit = 3,3
  print(s.distributeCandies(n,limit))