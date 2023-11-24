package main

import (
	"fmt"
)

func main() {
	var str1 = "AGGTAB"
	var str2 = "GXTYAYB"
	var len1 = len(str1)
	var len2 = len(str2)
	var dp = make([][]int, len1+1)
	temp := make([]int, len2+1)
	for j := range temp {
		temp[j] = -1
	}
	for i := range dp {
		dp[i] = temp
	}
	fmt.Println(dp)
	fmt.Println(lcs(str1, str2, len1, len2, dp))
}
func lcs(str1 string, str2 string, len1 int, len2 int, dp [][]int) int {
	if len1 == 0 || len2 == 0 {
		return 0
	}
	if dp[len1][len2] != -1 {
		return dp[len1][len2]
	}
	if str1[len1-1] == str2[len2-1] {
		dp[len1][len2] = 1 + lcs(str1, str2, len1-1, len2-1, dp)
		return dp[len1][len2]
	}
	dp[len1][len2] = max(lcs(str1, str2, len1, len2-1, dp), lcs(str1, str2, len1-1, len2, dp))

	return dp[len1][len2]

}
func max(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
