from typing import List

class Solution:
    def partitionArray(self, nums: List[int], k: int) -> int:
        nums.sort()
        minEle = nums[0]
        res = 0
        for i in range(1,len(nums)):
            if nums[i]-minEle > k:
                res+=1
                minEle = nums[i]

        return res+1