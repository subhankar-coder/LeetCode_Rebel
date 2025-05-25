from typing import List


class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        
        totSum = sum(nums)
        if totSum%2 == 1:
            return False
        target = totSum //2
        # n= len(nums)
        dp = [False]*(target+1)
        dp[0]=True

        for ele in nums:
            # print("ele",ele)
            for i in range(target,ele-1,-1):
                # print("i",i)
                dp[i] = dp[i] or dp[i-ele]
        
        # print(dp)
        return dp[target]









if __name__ == "__main__":
    s = Solution();
    li:List[int] = [1,2,3,5]
    print(s.canPartition(li))
