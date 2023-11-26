package main

import (
	"fmt"
)

func main() {

	var s string = "badc"
	var t string = "baba"

	if len(s) != len(t) {
		fmt.Println("false")
	}

	mp := make(map[byte]byte)
	values:= make(map[byte]bool)

	for i := 0; i < len(s); i++ {

		val, ok := mp[byte(s[i])]

		if ok {
			if val != byte(t[i]) {
				fmt.Println("false")
				break
			}
		} else {
			_,ok= values[byte(t[i])]
			if ok{
				fmt.Println(false)
				break;
			}else{
				values[byte(t[i])]=true
			}

			mp[byte(s[i])] = byte(t[i])

		}
	}
	fmt.Println(true)

}
