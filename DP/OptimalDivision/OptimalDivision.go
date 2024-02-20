package main

import(
	"fmt"
	"strconv"
)
// var mp map[string]int=make(map[string]int)
func main(){

	nums := []int {1000,100,10,2}
	n:= len(nums)
	
	res:=strconv.Itoa(nums[0])

	res+="/("+strconv.Itoa(nums[1])

	for i:=2;i<n;i++{
		res+=("/"+strconv.Itoa(nums[i]))
	}

	res+=")"

	fmt.Println(res)

}


