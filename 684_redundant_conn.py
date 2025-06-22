from typing import List
# from collections import defaultdict
class DSU:
    def __init__(self):
        self.parent= {}
        self.rank = {}
    
    def find(self,x):
        if x not in self.parent:
            self.parent[x]=x
            self.rank[x]=0
        if self.parent[x]!=x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def union(self,a,b):
        loc_a = self.find(a)
        loc_b = self.find(b)
        if loc_a == loc_b:
            return False
        
        if self.rank[loc_a] < self.rank[loc_b]:
            self.parent[loc_a] = loc_b
        elif self.rank[loc_a] > self.rank[loc_b]:
            self.parent[loc_b] = loc_a
        else:
            self.parent[loc_a]=loc_b
            self.rank[loc_b]+=1
       
        return True
            
        



class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        dsu = DSU()
        idx = 0
        for i,edge in enumerate(edges):
            if not dsu.union(edge[0],edge[1]):
                idx = i
        return edges[idx]

if __name__ == "__main__":
    sol = Solution()
    edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
    print(sol.findRedundantConnection(edges))