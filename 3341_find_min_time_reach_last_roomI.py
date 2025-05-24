from typing import List
import heapq
class Solution:
    __directions = [(0,-1),(-1,0),(1,0),(0,1)]

    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        print(moveTime)
        return self.dijkstra(moveTime)
    def dijkstra(self,grid) -> int:
        n,m = len(grid), len(grid[0])
        dist = [[float('inf')]*m for _ in range(n)]
        
        heap = [(0,0,0)]
        while heap:
            cost, x, y = heapq.heappop(heap)

            if (x,y) == (n-1,m-1):
                return cost

            if cost > dist[x][y]:
                continue;

            for dx,dy in self.__directions:
                nx,ny = x+dx, y+dy

                if 0 <= nx <n and 0<=ny <m:
                    new_cost = max(cost,grid[nx][ny])+1
                    if new_cost < dist[nx][ny]:
                        dist[nx][ny] = new_cost
                        heapq.heappush(heap,(new_cost,nx,ny))

        return -1
    


if __name__ == "__main__":
    matrix : List[List[int]] = [
                [0,4],
                [4,4]

            ]
    sol = Solution()
    print(sol.minTimeToReach(matrix))
    
