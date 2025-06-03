from collections import deque
from typing import List
class Solution:
    def maxCandies(self, status: List[int], candies: List[int], keys: List[List[int]], containedBoxes: List[List[int]], initialBoxes: List[int]) -> int:
        queue = deque(initialBoxes)
        vis = set()
        obtainedKeys = set()
        candy = 0
        while queue:
            currentBox = queue.popleft()
            print(currentBox)
            if currentBox not in vis:
                if status[currentBox] == 0:
                    if currentBox not in obtainedKeys:
                        if queue:
                            queue.append(currentBox)
                        # pass
                    else:
                        candy += candies[currentBox]
                        queue.extend(containedBoxes[currentBox])
                        vis.add(currentBox)
                        obtainedKeys.update(keys[currentBox])
                        
                else:
                    candy += candies[currentBox]
                    queue.extend(containedBoxes[currentBox])
                    obtainedKeys.update(keys[currentBox])
                    vis.add(currentBox)
                    
        return candy




if __name__ == "__main__":
    s = Solution()
    status:List = [1,0,1,0]
    candies:List = [7,5,4,100]
    keys:List[List] = [[],[],[1],[]]
    containedBoxes:List[List] = [[1,2],[3],[],[]]
    initialBoxes:List = [0]
    print(s.maxCandies(status, candies, keys, containedBoxes, initialBoxes))