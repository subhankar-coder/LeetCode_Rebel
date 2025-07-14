from typing import List
import bisect

class Solution:
    def matchPlayersAndTrainers(self, players: List[int], trainers: List[int]) -> int:
    	
    	trainers.sort()
    	count = 0
    	for player in players:
    		n = len(trainers)
    		if n <=0:
    			break

    		if player > trainers[n-1]:
    			continue;
    		lower_bound = bisect.bisect_left(trainers,player)
    		del trainers[lower_bound]
    		count+=1
    	return count


if __name__ == "__main__":
	s = Solution()
	
	players:List[int] = [1,1,1]
	trainers:List[int] = [10]

	print(s.matchPlayersAndTrainers(players,trainers))