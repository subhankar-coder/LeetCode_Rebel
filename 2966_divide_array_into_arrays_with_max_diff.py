from typing import List

class Solution:
    def divideArray(self, nums: List[int], k: int) -> List[List[int]]:
        nums.sort()
        result:List[List[int]] = []
        n = len(nums)
        

        for i in range(0,n,3):
            if nums[i+3-1] - nums[i] > k:
                return []
            result.append(nums[i:i+3])
        
        return result
        


if __name__ == "__main__":
    sol = Solution()
    print(sol.divideArray([2,4,2,2,5,2], 2))