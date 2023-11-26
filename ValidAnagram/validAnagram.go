package main

import "fmt"

func main() {

	var s string = "rat"
	var t string = "car"

	if len(s) != len(t) {
		fmt.Println(false)
		return
	}

	mp := make(map[byte]int)

	for i := 0; i < len(s); i++ {
		val, ok := mp[byte(s[i])]

		if ok {
			mp[byte(s[i])] = val + 1
		} else {
			mp[byte(s[i])] = 1
		}
	}

	for i := 0; i < len(t); i++ {

		val, ok := mp[byte(t[i])]

		if ok {
			mp[byte(t[i])] = val - 1

			if val-1 == 0 {
				delete(mp, byte(t[i]))
			}
		} else {
			fmt.Println(false)
			return
		}
	}
	fmt.Println(true)

}
