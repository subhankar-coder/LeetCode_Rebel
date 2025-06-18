class Solution:
    def maximumDifference(self, nums: List[int]) -> int:
       min_ele = nums[0]
       max_res = -1
       for i in range(1,len(nums)):
            if nums[i] > min_ele:
                print(max_res,nums[i]-min_ele)
                max_res = max(max_res,nums[i]-min_ele)
            else:
                min_ele =nums[i]
       
       return max_res