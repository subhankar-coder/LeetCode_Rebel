import bisect
from collections import Counter
from typing import List
class Solution:
    def minimizeMax(self, nums: List[int], p: int) -> int:
        nums = sorted(nums)
        low,hi = 0,nums[-1]-nums[0]
        def hasPairs(mid):
            count = 0
            i = 1
            while i < len(nums):
                if nums[i] - nums[i-1] <= mid:
                    count+=1
                    i+=2
                else:
                    i+=1
            return count<p

        while low < hi:
            mid = (low+hi)//2
            print(mid,hasPairs(mid))
            if hasPairs(mid):
                low = mid+1
            else:
                hi = mid

        return hi
        


if __name__ == "__main__":
    s = Solution()
    nums : List[int] = [10,1,2,7,1,3]
    p = 2
    print(s.minimizeMax(nums,p))

