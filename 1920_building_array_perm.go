package main

import(
	"fmt"
)
func main()  {
	var nums []int = []int{0,2,1,5,3,4}
	buildArray(nums)
}
func buildArray(nums []int) []int{
	var n int = len(nums)
	for i,ele := range nums{
		var a int = ele
		var b int = nums[a]%n
		nums[i] = a+b*n
		
	}	

	fmt.Println(nums)

	for i,ele := range nums{
		nums[i] = ele/n
	}
	fmt.Println(nums)
	return nums
}
