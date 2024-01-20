package main

import (
	"fmt"
	"math"
)

func main() {
	var array = []int{1, 2, 3, 4, 5}
	var res = math.MaxInt
	var end = len(array)
	var dp = make([]int, end)
	dp[0] = array[0]
	for i := 1; i < end; i++ {
		dp[i] = dp[i-1] + array[i]
	}
	var target = 15
	for i := 0; i < end; i++ {
		if dp[i] >= target {
			index := binarySearch(dp, dp[i]-target, 0, i)
			res = int(math.Min(float64(res), float64(i-index)))
		}
	}

	fmt.Println(res)

}
func binarySearch(array []int, target int, left int, right int) int {
	if left >= right {
		return right
	}
	mid := left + (right-left)/2
	if array[mid] == target {
		return mid
	} else if array[mid] > target && array[mid+1] < target {
		return mid
	} else if array[mid] < target {
		return binarySearch(array, target, mid+1, right)
	} else {
		return binarySearch(array, target, left, mid-1)
	}
}
