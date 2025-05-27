class Solution:
    def differenceOfSums(self, n: int, m: int) -> int:
        
        totSum = n*(n+1)//2
        divBound = n//m

        divisableSum = m*divBound*(divBound+1)//2

        return totSum-2*divisableSum

        




if __name__ == "__main__":
    s = Solution()
    n,m = 10,3
    print(s.differenceOfSums(n,m))

