from typing import List


class Solution:
    def maxEvents(self, events: List[List[int]]) -> int:

    	events = sorted(events,key = lambda x: (x[0],x[1]))

    	

    	return 0


if __name__ == "__main__":
	s = Solution()
	events: List[List[int]] = [[1,2],[2,3],[3,4]]
	print(s.maxEvents(events))