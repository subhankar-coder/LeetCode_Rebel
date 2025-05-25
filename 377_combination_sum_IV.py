from typing import List


class Solution:
    def __init__(self):
        self._cache = {}
    def combinationSum4(self, nums: List[int], target: int) -> int:
        # self._cache={}

        # return self.combSumHelper(nums,target,0)

        n: int = len(nums)
        dp = [0]*(target+1)
        dp[0]=1

        for t in range(1,target+1):
            for num in nums:
                if t-num >=0 :
                    dp[t]+= dp[t-num]


        return dp[target]
        
    def combSumHelper(self, nums:List[int], target:int, sumTillNow:int):

        if sumTillNow in self._cache:
            return self._cache[sumTillNow]
        if target == sumTillNow:
            return 1
        elif target < sumTillNow:
            return 0

        accured = 0

        for ele in nums:
            accured += self.combSumHelper(nums,target,sumTillNow+ele)

        self._cache[sumTillNow]=accured
        return accured
        
        

        




if __name__ == "__main__":
    s = Solution()
    li:List[int] = [1,2,3]
    target:int = 4
    print(s.combinationSum4(li,target))


