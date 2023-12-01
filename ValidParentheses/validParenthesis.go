package main

import "fmt"

func main() {

	var s string = "([]"
	var stack = []byte(s)
	var slen = len(stack) - 1
	var top = []byte{}

	if len(stack) <= 1 || string(stack[slen]) == "(" || string(stack[slen]) == "{" || string(stack[slen]) == "[" {
		fmt.Println(false)
		return
	}

	for slen >= 0 {
		if string(stack[slen]) == "(" || string(stack[slen]) == "{" || string(stack[slen]) == "[" {
			if len(top)==0 ||!isMatching(stack, slen, string(top[len(top)-1])) {
				fmt.Println(false)
				return
			} else {
				top = top[:len(top)-1]
				slen--
				continue
			}
		}
		top = append(top, stack[slen])
		slen--
	}
	if len(top)==0{
		fmt.Println(true)
	}
	fmt.Println(false)
}
func isMatching(stack []byte, curr int, top string) bool {

	if string(stack[curr]) == "(" && top == ")" {
		return true
	} else if string(stack[curr]) == "{" && top == "}" {
		return true
	} else if string(stack[curr]) == "[" && top == "]" {
		return true
	} else {
		return false
	}
}
