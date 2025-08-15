import math

class Solution:
    def isPowerOfFour(self, n: int) -> bool:
        if n <= 0:
             return False
        q=(math.log(abs(n))/math.log(4))
        return q.is_integer()