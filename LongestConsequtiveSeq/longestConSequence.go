package main

import (
	"fmt"
	"math"
)

type Node struct {
	value     int
	next      *Node `default:nil`
	hasParent bool  `default:false`
}

func main() {

	nums := []int{0, 0, -1, 1}
	keyset := []int{}

	mp := make(map[int]*Node)

	for _, val := range nums {

		_, ok := mp[val]

		if ok {

			continue
		} else {
			keyset = append(keyset, val)
			mp[val] = &Node{value: val}
		}
	}
	for _, val := range keyset {
		_, ok := mp[val+1]
		if ok {
			temp := mp[val]
			for temp.next != nil {

				temp = temp.next
			}
			mp[val+1].hasParent = true
			temp.next = mp[val+1]
		}
	}

	var len int = 0

	for _, val := range keyset {

		if !mp[val].hasParent {
			len = int(math.Max(float64(getLen(mp[val])), float64(len)))
		}
	}
	fmt.Println(len)
}

func getLen(node *Node) int {

	var len int = 0

	for node != nil {
		len++
		node = node.next
	}
	return len
}
