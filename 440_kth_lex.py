
class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        def count_ele_btwn(n,start,end):
            count = 0
            while start <= n:
                count += min(end,n+1) - start
                start *=10
                end *=10

            return count
        curr = 1
        while k >0:
            count = count_ele_btwn(n,curr,curr+1)
            print(curr,count,k)
            if count < k:
                k -= count
                curr+=1
            else:
                k-=1
                curr = curr*10
        return curr


if __name__ == "__main__":
    s = Solution()
    n,k = 100,10
    print(s.findKthNumber(n,k))
