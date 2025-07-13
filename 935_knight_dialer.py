
from functools import lru_cache

class Solution:
    def knightDialer(self, n: int) -> int:
        dict = {0:[4,6],1:[6,8],2:[7,9],3:[4,8],4:[0,3,9],5:[],6:[0,1,7],7:[2,6],8:[1,3],9:[2,4]}
        vis = [0]*10
        count=0
        MOD = 10**9+7
        
        @lru_cache()
        def helper(key,n):
            if n<=1:
                return 1    
            res = 0
            # print(dict[key])
            for ele in dict[key]:
                print("element ",ele)
                if vis[ele] !=1:
                    # print(ele)
                    vis[ele]=1
                    res = (res+helper(ele,n-1)) %MOD
                    # print(res)
                    vis[ele] =0
            print("result",res)
            return res

        for i in range(10):
            # print(i)
            count= (count+helper(i,n))%MOD
            print("done with",i)
        return count
    
    

if __name__ == "__main__":
    n = 10
    s = Solution()
    print(s.knightDialer(2))
