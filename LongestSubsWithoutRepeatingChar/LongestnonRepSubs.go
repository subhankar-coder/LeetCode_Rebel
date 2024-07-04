package main

import "fmt"

func main() {

	s := "abba"
	n := len(s)

	array := []rune(s)

	mp := make(map[rune]int)
	start := 0

	result := 1

	for i := 0; i < n; i++ {
		_, ok := mp[array[i]]

		if !ok {
			mp[array[i]] = i
		} else {
			result = max(result, i-start)
			start = max(start, mp[array[i]]+1)
			mp[array[i]] = i
		}
	}
	result = max(result, n-start)
	fmt.Println(result)
}

func max(a int, b int) int {
	if a < b {
		return b
	}
	return a
}
