from typing import List
import heapq


class Solution:
    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        directions = [(0,1),(0,-1),(1,0),(-1,0)]
        n,m = len(moveTime), len(moveTime[0])
        dist = [[float('inf')]*m for _ in range(n)]

        heap = [(0,0,0,0)]

        while heap:
            cost, path , r, c = heapq.heappop(heap)

            if ( r,c ) == (n-1,m-1):
                return cost

            if cost > dist[r][c]:
                continue

            for dr,dc in directions:
                nr,nc = r+dr, c+dc

                if 0<= nr < n and 0<= nc < m:
                    wait_time = 1 if path % 2==0 else 2
                    new_cost = max(cost,moveTime[nr][nc])+wait_time
                    # print(nr, nc, new_cost)
                    if new_cost < dist[nr][nc]:
                        dist[nr][nc] = new_cost
                        heapq.heappush(heap,(new_cost,path+1,nr,nc))

        return -1


if __name__ == "__main__":
    matrix: List[List[int]] = [
                [0,0,0,0],
                [0,0,0,0] 
            ]
    sol = Solution()
    print(sol.minTimeToReach(matrix))
