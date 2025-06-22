from collections import defaultdict
from typing import List

class Graph:
    def __init__(self,V):
        self.V = V
        self.adj = defaultdict(list)
    
    def addEdge(self,u,v):
        self.adj[u].append(v)
    
    def topologicalSort(self,n):
        vis = [False]*n
        stack:List[int] = []
        for ele in range(n):
            if not vis[ele]:
                self.topologicalSortHelper(ele,stack,vis)
       
        return stack[::-1]

    def topologicalSortHelper(self,curr,stack,vis):
        vis[curr]=True
        
        for neighbour in self.adj[curr]:
            if not vis[neighbour]:
                self.topologicalSortHelper(neighbour,stack,vis)
        stack.append(curr)

    def isChild(self,parent,target,vis):
        if parent == target:
            return True
        vis[parent]=True
        for neighbour in self.adj[parent]:
            if not vis[neighbour]:
                if self.isChild(neighbour,target,vis):
                    return True
        return False

class GraphMatrix:
    def __init__(self,V):
        self.V = V
        self.matrix = [[0 if i==j else float("inf") for j in range(V)]for i in range(V)]
    
    def addEdge(self,u,v):
        self.matrix[u][v]=1
    
    def floydWarshall(self):
        for k in range(self.V):
            for i in range(self.V):
                for j in range(self.V):
                    self.matrix[i][j] = min(self.matrix[i][j], self.matrix[i][k]+self.matrix[k][j])
    
    def isPathExists(self,u,v):
        return self.matrix[u][v] != float("inf")

class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        res:List[bool] = []

        graph = Graph(numCourses)
        for li in prerequisites:
            # print(li)
            graph.addEdge(li[0],li[1])
        
        topo = graph.topologicalSort(numCourses)
        print(topo)
        # for query in queries:
        #     res.append(graph.isChild(query[0],query[1],[False]*numCourses) )

        matrix = GraphMatrix(numCourses)
        for li in prerequisites:
            matrix.addEdge(li[0],li[1])
        
        matrix.floydWarshall()
        for query in queries:
            res.append(matrix.isPathExists(query[0],query[1]))
            
        return res


if __name__ == "__main__":
    numCourses=4
    prerequisites:List[List[int]] = [[2,3],[2,1],[0,3],[0,1]]
    queries:List[List[int]] = [[0,1],[0,3],[2,3],[3,0],[2,0],[0,2]]
    sol = Solution()
    graph = Graph(numCourses)
    print(numCourses)
    
    print(sol.checkIfPrerequisite(numCourses,prerequisites,queries))