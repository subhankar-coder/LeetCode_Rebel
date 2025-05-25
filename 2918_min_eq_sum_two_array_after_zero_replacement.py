from typing import List
from functools import reduce


class Solution:
    def minSum(self, nums1: List[int], nums2: List[int]) -> int:
        
        sum1,numCount1 = reduce(lambda acc,x: (acc[0]+x, acc[1]+(x==0)), nums1, (0,0))
        sum2,numCount2 = reduce(lambda acc,x: (acc[0]+x, acc[1]+(x==0)), nums2, (0,0))
        # if sum1 < sum2 && numCount1 == 0:
        #     return -1
        # elif sum1 > sum2 && numCount2 == 0:
        #     return -1
        # 
        updatedNum1 = sum1+numCount1
        updatedNum2 = sum2+numCount2
        #
        if updatedNum1 < updatedNum2 and numCount1 ==0:
            return -1
        elif updatedNum2 < updatedNum1 and numCount2 == 0:
            return -1

        return max(updatedNum1,updatedNum2)
    









if __name__ == "__main__":
    s = Solution()
    num1:List[int] = [3,2,0,1,0]
    num2:List[int] = [6,5,0]
    print(s.minSum(num1,num2))
