package main

import "myGoApp/Node"

func main() {

	var linkedList Node.LinkedList
	linkedList.Val = 1
	linkedList.Insert(2)
	linkedList.Insert(3)
	linkedList.Insert(4)
	linkedList.Insert(5)
	reverseList2(&linkedList, 1, 5)

}
func reverseList2(head *Node.LinkedList, left int, right int) {
	var result = head
	var reversed *Node.LinkedList
	var count = 1
	if head == nil || head.Next == nil {
		return
	}
	if left == right {
		return
	}
	var prev = head
	var start = head
	var end = head
	for head != nil {
		if count == left-1 {
			prev = head
		} else if count == left {
			start = head
		} else if count == right {
			end = head.Next
			head.Next = nil
			break
		}
		head = head.Next
		count++
	}

	if start == result {
		reversed = reverse(start)
		result = reversed
		for reversed.Next != nil {
			reversed = reversed.Next
		}
		reversed.Next = end
	} else {

		reversed = reverse(start)
		prev.Next = reversed
		for prev.Next != nil {
			prev = prev.Next
		}
		prev.Next = end
	}
	result.Display()

}
func reverse(head *Node.LinkedList) *Node.LinkedList {
	if head == nil || head.Next == nil {
		return head
	}
	rest := reverse(head.Next)
	head.Next.Next = head
	head.Next = nil

	return rest

}
