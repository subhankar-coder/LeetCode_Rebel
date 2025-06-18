mod = 10**9+7
class Solution:
    def countGoodNumbers(self, n: int) -> int:
    
        oddNum = n //2
        evenNum = n//2 if n%2 ==0 else n//2+1

        def fastExponential(a,b):
            result = 1
            while b > 0:
                if b % 2 ==1:
                    result = (result * a)%mod
                a = (a*a) %mod
                b = b//2
            return result
        return (fastExponential(5,evenNum)* fastExponential(4,oddNum)) % mod