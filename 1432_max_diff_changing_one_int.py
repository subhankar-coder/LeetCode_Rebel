class Solution:
    def maxDiff(self, num: int) -> int:
        num1 = str(num)
        num2 = str(num)
        max_int = ""
        min_int = ""
        min_flag = True
        for i in range(len(num1)):
            if max_int == "" and num1[i] !="9":
                max_int = num1[i]
            if num1[i] == max_int:
                num1 = num1[:i] + "9" + num1[i+1:]
            
            if min_int == "" and num2[i] != "1" and num2[i]!= "0" :
                min_int = num2[i]
                min_flag = True if i == 0 else False
            if num2[i] == min_int:
                num2 = num2[:i] + "1"+num2[i+1:] if min_flag else num2[:i] + "0" + num2[i+1:]
        return int(num1) - int(num2)




if __name__ == "__main__":
    num = "1101057"
    s= Solution()
    print(s.maxDiff(num))