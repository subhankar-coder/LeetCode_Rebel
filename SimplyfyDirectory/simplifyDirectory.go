package main

import "fmt"

func main() {

	path := "/../..ga/b/.f..d/..../e.baaeeh./.a"
	stack := [][]byte{}
	pathSlice := []byte(path)

	for i := 0; i < len(pathSlice); i++ {

		if string(pathSlice[i]) == "/" {
			if len(stack) != 0 && string(stack[len(stack)-1]) == "/" {
				continue
			}
			stack = append(stack, []byte{pathSlice[i]})
		} else if string(pathSlice[i]) == "." {

			temp := []byte{}
			for i < len(pathSlice) && string(pathSlice[i]) != "/" {
				temp = append(temp, pathSlice[i])
				i++
			}
			i--
			stack = append(stack, temp)
		} else {
			temp := []byte{}
			for i < len(pathSlice) && string(pathSlice[i]) != "/" {
				temp = append(temp, pathSlice[i])
				i++
			}
			i--
			stack = append(stack, temp)
		}
	}
	if string(stack[len(stack)-1]) == "/" {

		stack = stack[:len(stack)-1]
	}

	n := len(stack) - 1
	count := 0
	for n >= 0 {

		if string(stack[n]) == "." {

			stack = append(stack[:n-1], stack[n+1:]...)
			n--
		} else if string(stack[n]) == ".." {

			stack = append(stack[:n-1], stack[n+1:]...)
			count++
			n--
		} else {
			if count != 0 {

				stack = append(stack[:n-1], stack[n+1:]...)
				n--
				count--
			}
		}
		n--

	}
	for _, val := range stack {
		fmt.Print(string(val))
	}

}
