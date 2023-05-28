package main

import "myGoApp/Node"

func main() {
	var linkedList Node.LinkedList
	linkedList.Val = 9
	linkedList.Next = nil

	linkedList.Insert(9)
	linkedList.Insert(9)
	linkedList.Insert(9)
	linkedList.Insert(9)
	linkedList.Insert(9)

	var linkedList2 Node.LinkedList
	linkedList2.Val = 9
	linkedList2.Next = nil

	linkedList2.Insert(9)
	linkedList2.Insert(9)
	linkedList2.Insert(9)
	twoSum(&linkedList, &linkedList2)

}
func twoSum(l1 *Node.LinkedList, l2 *Node.LinkedList) {
	var borrow = (l1.Val + l2.Val) / 10
	var result Node.LinkedList
	result.Val = (l1.Val + l2.Val) % 10
	result.Next = nil

	for l1.Next != nil && l2.Next != nil {
		l1 = l1.Next
		l2 = l2.Next
		result.Insert((l1.Val + l2.Val + borrow) % 10)
		borrow = (l1.Val + l2.Val + borrow) / 10
	}
	if l1.Next != nil {
		for l1.Next != nil {
			l1 = l1.Next
			result.Insert((l1.Val + borrow) % 10)
			borrow = (l1.Val + borrow) / 10
		}
	} else if l2.Next != nil {
		for l2.Next != nil {
			l2 = l2.Next
			result.Insert((l2.Val + borrow) % 10)
			borrow = (l2.Val + borrow) / 10
		}
	}
	if borrow != 0 {
		result.Insert(borrow)
	}
	result.Display()
}
