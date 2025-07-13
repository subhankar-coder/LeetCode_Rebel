class Solution:
    def candy(self, ratings: List[int]) -> int:
      n = len(ratings)
      result = [1]*n
      for i in range(1,n,1):
        result[i] = result[i-1]+1 if ratings[i-1]<ratings[i] else 1
      for i in range(n-2,-1,-1):
        result[i] = max(result[i],result[i+1]+1 if ratings[i+1]<ratings[i] else 1)

      return sum(result)

if __name__ == "__main__":
  ratings: List = [1,2,87,87,87,2,1]
  s = Solution()
  print(s.candy(ratings))
