package main

import (
	"fmt"
)

var N int

func main() {

	var nums = []int{4, 1, 2, 7, 5, 3, 1}
	N = len(nums)
	dp:= make([]int,N)
	fmt.Println(solve(nums, N-1,dp))
}
func rob(nums []int, max int, ind int, money int, lastIndex int) int {

	if lastIndex >= N {
		return money
	}
	for ind < N {
		money += nums[lastIndex]
		var collect int = maxInt(rob(nums, max, ind, money, lastIndex+2), rob(nums, max, ind, money-nums[lastIndex], lastIndex+1))
		if collect >= max {
			max = collect
		}
		ind++
		money = 0
		lastIndex = ind
	}
	return max
}
func maxInt(a int, b int) int {
	if a < b {
		return b
	}
	return a
}
func solve(nums []int, n int,dp [] int) int {
	if n < 0 {
		return 0
	}
	if n == 0 {
		return nums[0]
	}
	if dp[n]!=0{
		return dp[n]
	}
	pick := nums[n] + solve(nums, n-2,dp)
	notPick := solve(nums, n-1,dp)

	dp[n]=maxInt(pick, notPick)
	return dp[n]
}
