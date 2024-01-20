package main

import (
	"fmt"
	"math"
)

func main() {
	var s = "adobecodebanc"
	var t = "abc"
	var res = ""
	var array = []rune(s)
	var target = []rune(t)
	var sLen = len(s)
	var tLen = len(t)
	var index = 0
	var hashMap = make(map[rune]int)
	var count = tLen
	var maxLen = math.MaxInt
	for _, ele := range target {
		val, ok := hashMap[ele]
		if ok {
			hashMap[ele] = val + 1
		} else {
			hashMap[ele] = 1
		}
	}
	var copyIndex = index
	var isBuilding = true
	var temp = copyMap(hashMap)
	for i := 0; i < sLen; i++ {
		val, ok := temp[array[i]]
		if ok {
			if !isBuilding {
				copyIndex = index
			}
			if val == 0 {
				temp = copyMap(hashMap)
				copyIndex = i
				index = i
				count = tLen - 1
				temp[array[i]] = val - 1

			} else {
				temp[array[i]] = val - 1
				isBuilding = true
				count--
				if index < sLen && count == 0 && maxLen > i-copyIndex {
					res = s[copyIndex : i+1]
					maxLen = i - copyIndex
					index = i + 1
					count = tLen
					isBuilding = false
					temp = copyMap(hashMap)
					continue
				}

			}
		} else {
			index = i + 1
		}
		// else {
		// 	temp = copyMap(hashMap)
		// 	index = i + 1
		// 	i++
		// }
	}
	fmt.Println(res)
}
func copyMap(hashMap map[rune]int) map[rune]int {
	var temp = make(map[rune]int)
	for key, val := range hashMap {
		temp[key] = val
	}
	return temp
}
