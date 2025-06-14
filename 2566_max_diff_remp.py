class Solution:
    def minMaxDifference(self, num: int) -> int:
        num1 = str(num)
        num2 = str(num)

        max_char = ""
        min_char = ""
        for i in range(0,len(num1)):
            if num1[i] != "9" and max_char == "":
                max_char = num1[i]

            if max_char == num1[i]:
                num1 = num1[:i] + "9" + num1[i+1:] 
            
            if num2[i] != "0" and min_char == "":
                min_char = num2[i]

            if min_char == num2[i]:
                num2 = num2[:i] + "0" + num2[i+1:] 
            
        print(num1,num2)

        return int(num1) - int(num2)


if __name__ == "__main__":
    s = Solution()
    num = 11891
    print(s.minMaxDifference(num))