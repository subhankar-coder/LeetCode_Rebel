from typing import List
from itertools import groupby

class Solution:
    def threeConsecutiveOdds(self, arr: List[int]) -> bool:
        return True if max(map(lambda g: len(list(g[1])) if g[0] else 0, groupby(arr,key=lambda x: x%2 ==1))) >= 3 else False
        
    



if __name__ == "__main__":
    arr: List[int] = [1,2,34,3,4,5,7,23,12]
    s = Solution()
    print(s.threeConsecutiveOdds(arr))
