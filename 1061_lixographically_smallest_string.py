class UnionFind:
    def __init__(self):
        self.parent = {}

    def find(self,x):

        if x not in self.parent:
            self.parent[x]=x

        if self.parent[x]!=x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def union(self,a,b):
        find_a = self.find(a)
        find_b = self.find(b)

        if find_a == find_b:
            return False
        
        if find_a > find_b:
            self.parent[find_a] = find_b
        else:
            self.parent[find_b]= find_a
        
        return True

class Solution:
    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        u = UnionFind()
        for c1,c2 in zip(s1,s2):
            u.union(c1,c2)
        
        res = ""
        for ch in baseStr:
            res += u.find(ch)
    
        return res





if __name__ == "__main__":
    s1,s2,baseStr = "leetcode","programs", "sourcecode"
    s=Solution()
    print(s.smallestEquivalentString(s1,s2,baseStr))
