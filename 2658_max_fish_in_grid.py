from typing import List

class Solution:
    def findMaxFish(self, grid: List[List[int]]) -> int:
        xRows = [-1,1,0,0]
        xCols = [0,0,-1,1]
        R,C = len(grid),len(grid[0])

        def dfs(r,c,vis):
            vis[r][c]=True
            fish = grid[r][c]
            print(r,c,"fish",fish)
            for i in range(4):
                xRow = xRows[i]
                xCol = xCols[i]

                if r+xRow >= R or r+xRow < 0 or c+xCol >= C or c+xCol < 0:
                     continue
                print(r+xRow,c+xCol,grid[r+xRow][c+xCol])
                if not vis[r+xRow][c+xCol] and grid[r+xRow][c+xCol] > 0:
                   fish += dfs(r+xRow,c+xCol,vis)
            return fish
        
        fish = 0
        for row in range(R):
            for col in range(C):
                if grid[row][col] > 0:
                    fish = max(fish,dfs(row,col,[[False for i in range(C)]for j in range(R)]))

        # print(dfs(1,3,[[False for i in range(C)]for j in range(R)]))
        return fish
                        


if __name__ == "__main__":
    grid = [[1,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,1]]
    sol = Solution()
    print(sol.findMaxFish(grid))