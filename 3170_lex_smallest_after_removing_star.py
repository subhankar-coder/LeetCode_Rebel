import heapq

class Task:
    def __init__(self,val,index):
        self.val = val
        self.index = index  
    def __lt__(self,other):
        if self.val != other.val:
            return self.val < other.val
        return self.index > other.index
    
    def __repr__(self):
        return f"Task(val={self.val}, index={self.index})"

class Solution:
    
    def clearStars(self, s: str) -> str:
    #   onlyChar = ''.join(filter(lambda x: x != '*',s))
      pq = []
      res  = list(s)
      
      for i in range(0,len(s),1):
        if s[i] != '*':
            pq.append((s[i],-i))
        else:
            heapq.heapify(pq)
            tp = heapq.heappop(pq)
            res[i]=''
            res[-tp[1]]=''

            
      
    #   print (res)
      
    #   for i in range(0,len(onlyChar),1):
    #     ch = onlyChar[i]
    #     tmpString = onlyChar[:i]+onlyChar[i+1:]
    #     heapq.heappush(pq,Task(ch,tmpString))
    #   for ch in range(onlyChar):
    #     heapq.heappush(pq,Task(ch,))
    #   heapq.heappush(pq,Task("a","aba"))
    #   heapq.heappush(pq,Task("a","aba"))
    #   heapq.heappush(pq,Task("b","aaa"))
    #   heapq.heappush(pq,Task("a","aab"))

    #   while pq:
    #     top = heapq.heappop(pq)
    #     print(top.first,top.second)
      return ''.join(res)


if __name__ == "__main__":
    s = Solution()
    print(s.clearStars("aaba*"))