package main

import (
	"fmt"
	"strings"
)

func main() {

	var pattern string = "abba"
	var s string = "dog dog dog dog"

	strArray := strings.Split(s, " ")

	if len(pattern) != len(strArray) {
		fmt.Println(false)
		return
	}

	mp := make(map[byte]string)
	values := make(map[string]bool)

	for i := 0; i < len(pattern); i++ {

		val, ok := mp[byte(pattern[i])]

		if ok {

			if strArray[i] != val {
				fmt.Println(false)
				return
			}
		} else {
			_, ok = values[strArray[i]]
			if ok {
				fmt.Println(false)
				return
			}
			mp[byte(pattern[i])] = strArray[i]
			values[strArray[i]] = true
		}
	}
	fmt.Println(true)

}
