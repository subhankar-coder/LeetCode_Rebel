package main

import (
	"fmt"
	"math"
)

func main() {
	s := "dvdf"
	array := []rune(s)
	hashMap := make(map[rune]int)
	index := 0
	res := 0
	for i, ele := range array {
		val, ok := hashMap[ele]
		if !ok {
			hashMap[ele] = i
			res = int(math.Max(float64(res), float64(i-index)))
		} else {
			if val < index {
				hashMap[ele] = i
				res = int(math.Max(float64(res), float64(i-index)))
			} else {

				index = hashMap[ele] + 1
				res = int(math.Max(float64(res), float64(i-index)))
				hashMap[ele] = i
			}
		}
	}
	fmt.Println(res)
}
