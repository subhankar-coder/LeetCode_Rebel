package main

import "myGoApp/Node"

func main() {
	var linkedList Node.LinkedList
	linkedList.Val = 1
	linkedList.Insert(2)
	linkedList.Insert(3)
	linkedList.Insert(4)
	linkedList.Insert(5)
	reverseList(&linkedList).Display()

}
func reverseList(head *Node.LinkedList) *Node.LinkedList {
	if head.Next == nil || head == nil {
		return head
	}

	rest := reverseList(head.Next)
	head.Next.Next = head
	head.Next = nil

	return rest
}
