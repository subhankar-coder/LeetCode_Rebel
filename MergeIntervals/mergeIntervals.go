package main

import (
	"fmt"
	"sort"
)

func main() {

	var nums [][]int = [][]int{
		{1, 4},
		{0, 4},
		// {8, 10},
		// {15, 18},
	}

	sort.SliceStable(nums,func(i, j int) bool {
		return nums[i][0]<nums[j][0]
	})

	var start int = 0
	var end int = start + 1

	for end < len(nums) {
		if nums[start][1] >= nums[end][0] {

            if nums[start][1]>= nums[end][1]{
                nums=append(nums[:start+1],nums[start+2:]...)
            }else{
                nums[start][1] = nums[end][1]
                nums = append(nums[:start+1], nums[start+2:]...)
            }
		} else { 
			start = end
			end++
		}
	}

	fmt.Println(nums)
}
