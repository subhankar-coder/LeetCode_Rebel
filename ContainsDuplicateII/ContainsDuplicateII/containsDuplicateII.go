package main

import (
	"fmt"
	"math"
)

func main() {
	var nums []int = []int{1, 2, 3, 1, 2, 3}
	var k = 2
	var mp map[int][]int = make(map[int][]int)

	for i, val := range nums {
		array, ok := mp[val]
		if ok {
			for _, v := range array {
				if math.Abs(float64(v-i)) <= float64(k) {
					fmt.Println(true)
					return
				}
			}
			array = append(array, i)
			mp[val] = array
		} else {
			mp[val] = []int{i}
		}
	}
	fmt.Println(false)
	return
}
