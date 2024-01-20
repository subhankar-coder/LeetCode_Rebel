package main

import (
	"fmt"
	"sort"
)

func main() {
	array := []int{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}
	var l = len(array)
	sort.Ints(array)
	var hashMap = make(map[int]int)
	var result = make(map[[3]int]bool)
	for i := 0; i < l; i++ {
		hashMap[array[i]] = i
	}
	for i := 0; i < l-1; i++ {
		var target = 0 - array[i]
		var j = i + 1

		for j < l {
			var tmp [3]int
			tmp[0] = array[i]
			_, ok := hashMap[target-array[j]]
			if ok && hashMap[target-array[j]] != i && hashMap[target-array[j]] != j {
				tmp[1] = array[j]
				tmp[2] = target - array[j]
				sort.Ints(tmp[:])
				_, ok := result[tmp]
				if !ok {
					result[tmp] = true
				}
			}
			j++
		}

	}

	var keys [][]int
	var i = 0
	for key, _ := range result {
		dest := make([]int, len(key))
		copy(dest, key[:])
		keys = append(keys, dest)
		i++
	}
	fmt.Println(keys)
}
