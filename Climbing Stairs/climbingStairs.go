package main

import "fmt"

func main() {
	var n int = 45
	dp := make([]int, n+1)
	dp[0] = 1
	dp[1] = 1
	fmt.Println(getStairs(n, dp))

}
func getStairs(n int, dp []int) int {

	if n <= 1 {
		return 1
	}
	if dp[n] != 0 {
		return dp[n]
	}
	dp[n] = getStairs(n-1, dp) + getStairs(n-2, dp)

	return dp[n]
}
