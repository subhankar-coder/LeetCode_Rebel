package main

import (
	"myGoApp/Node"
)

func main() {

	var linkedList Node.LinkedList
	linkedList.Val = 1
	//linkedList.Insert(2)
	linkedList.Insert(2)
	linkedList.Insert(3)
	linkedList.Insert(3)
	linkedList.Insert(4)
	linkedList.Insert(5)

	removeDuplicat(&linkedList)

}
func removeDuplicat(head *Node.LinkedList) {
	if head == nil || head.Next == nil {
		return
	}
	// var count=0
	var temp = head.Next
	var prev = head
	var result Node.LinkedList

	for temp != nil {
		if prev == head && temp.Val != prev.Val {
			result.Insert(prev.Val)
		}
		if temp.Next == nil && prev.Val != temp.Val {
			result.Insert(temp.Val)
		}
		if temp.Next != nil && temp.Next.Val != temp.Val && temp.Val != prev.Val {
			result.Insert(temp.Val)
		}
		prev = prev.Next
		temp = temp.Next
	}
	result.Display()

}
