package main
import (
	"fmt"
)
func main(){
	var str1="abcba"
	var str2 = "abcbcba"
	var len1= len(str1)
	var len2=len(str2)
	var dp = make([][]int,len1+1)
	for i:= range dp{
		dp[i]=make([]int,len2+1)
	}
	fmt.Println(lcs(str1,str2,len1,len2,dp))
}
func lcs(str1 string , str2 string ,len1 int,len2 int, dp [][]int)int{
	for i:=1;i<=len1;i++{
		for j:=1;j<=len2;j++{
			if str1[i-1]==str2[j-1]{
				dp[i][j]=1+dp[i-1][j-1]
			}else{
				dp[i][j]=max(dp[i-1][j],dp[i][j-1])
			}
		}
	}
	fmt.Println(dp)
	return dp[len1][len2]
}
func max(a int,b int)int{
	if a>b{
		return a
	}else{
		return b
	}
}