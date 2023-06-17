package main

import "myGoApp/Node"

func main() {
	var linkedList Node.LinkedList
	linkedList.Val = 1
	linkedList.Insert(2)
	linkedList.Insert(3)
	linkedList.Insert(4)
	linkedList.Insert(5)
	//linkedList.Insert(6)
	swapPairs(&linkedList)

}
func swapPairs(linkedList *Node.LinkedList) *Node.LinkedList {
	var head = linkedList
	var prev = linkedList
	var flag bool = true
	if linkedList == nil || linkedList.Next == nil {
		return linkedList
	}
	var newHead *Node.LinkedList = nil
	for head != nil && head.Next != nil {
		if head.Next.Next != nil {
			newHead = head.Next.Next
		} else {
			newHead = nil
		}
		if head == linkedList {
			linkedList = head.Next
		}
		var temp = head
		head = head.Next
		head.Next = temp
		if flag {
			flag = false
		} else {
			prev.Next = head
		}
		prev = temp
		head.Next.Next = newHead
		head = newHead
	}
	linkedList.Display()
	return linkedList
}
