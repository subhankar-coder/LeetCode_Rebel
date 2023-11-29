package main

import (
	"fmt"
	"strconv"
)

func main() {

	var nums = []int{0, 2, 3, 4, 6, 8, 9}
	var prev int = 0
	var start int = 1
	var lastVal = nums[0]
	var val = nums[1]
	var result = []string{}

	for i := 0; start < len(nums); i++ {

		val = nums[start]
		if i == 0 {
			continue
		}
		if val-1 != lastVal {

			if prev+1 == start {
				result = append(result, strconv.Itoa(nums[start-1]))
			} else {
				result = append(result, strconv.Itoa(nums[prev])+"->"+strconv.Itoa(nums[start-1]))
			}
			prev = start
		}
		lastVal = val
		start++
	}
	if prev+1 == start {
		result = append(result, strconv.Itoa(nums[start-1]))
	} else {
		result = append(result, strconv.Itoa(nums[prev])+"->"+strconv.Itoa(nums[start-1]))
	}

	fmt.Println(result)

}
