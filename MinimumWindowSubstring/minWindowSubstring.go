package main

import (
	"fmt"
	"math"
)

func main() {

	var s string = "this is a test string"
	var t string = "tist"
	var temp string

	mp := make(map[byte]int)
	var tLen int = len(t)

	for i := 0; i < tLen; i++ {
		val, ok := mp[byte(t[i])]
		if ok {
			mp[byte(t[i])] = val + 1
		} else {
			mp[byte(t[i])] = 1
		}
	}

	array := []byte(s)

	var start int = 0
	var end int = 0
	var min_str string = ""
    var min_len = math.MaxInt
	var count = 0
	var sLen = len(s)
	for end <= sLen {

		// curr := string(array[start:end])

		// fmt.Println(curr)

		if count < tLen {
			if end >= sLen {
				break
			}
			val, ok := mp[array[end]]
			if ok {
				mp[array[end]] = val - 1
				if val > 0 {

					count++
				}
			}
			end++

		}
		if count >= tLen {
			if count == tLen {

				temp = string(array[start:end])
			}
			if len(temp) < min_len {
				min_str = temp
                min_len=len(temp)
			}
			val, ok := mp[array[start]]
			if ok {
				mp[array[start]] = val + 1
				if mp[array[start]] >0 {
					count--
				}
			}
			start++
		}
	}
	fmt.Println(min_str)
}
