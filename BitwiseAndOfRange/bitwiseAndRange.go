package main

import (
	"fmt"
	"strconv"
)

var res int64

func main() {

	var left int64 = 5
	var right int64 = 7
	res = 1

	str := strconv.FormatInt(right, 2)
	ch := []rune(str)
	solve(ch, left, right, len(str)-1)
	fmt.Println(res)
}

func solve(ch []rune, left int64, right int64, index int) {
	if index < 0 {
		return
	}

	val, _ := strconv.ParseInt(string(ch), 2, 64)
	// fmt.Println(val)
	if val < left || val > right {
		return
	}

	fmt.Println(res, val)
	// fmt.Println(7 & 1)
	res = (res & val)

	for i := index; i >= 0; i-- {
		if ch[i] == 48 {
			ch[i] = 49
			solve(ch, left, right, i-1)
			ch[i] = 48
		} else {
			ch[i] = 48
			solve(ch, left, right, i-1)
			ch[i] = 49
		}
	}
}
