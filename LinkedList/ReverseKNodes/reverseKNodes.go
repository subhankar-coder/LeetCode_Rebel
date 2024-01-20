package main

import (
	"myGoApp/Node"
)

func main() {
	//var linkedList Node.LinkedList
	//	linkedList.Val = 1
	//	linkedList.Insert(2)
	//		linkedList.Insert(3)
	//		linkedList.Insert(4)
	//		linkedList.Insert(5)
	//		linkedList.Insert(6)
	reverseKNode(nil, 1).Display()

}

func reverseKNode(linkedList *Node.LinkedList, n int) *Node.LinkedList {
	if linkedList == nil || linkedList.Next == nil {
		return linkedList
	}
	var array []*Node.LinkedList
	var node *Node.LinkedList
	var head = linkedList
	var count = 0
	for head != nil {
		if count != n {
			if node == nil {
				node = &Node.LinkedList{
					Val:  head.Val,
					Next: nil,
				}
			} else {
				node.Insert(head.Val)
			}
			head = head.Next
			count++
		} else {

			array = append(array, reverseLinkedList(node))
			node = nil
			count = 0
		}
		if head == nil {
			if count == n {
				array = append(array, reverseLinkedList(node))
			} else {

				array = append(array, node)
			}

		}
	}
	var prev = array[0]
	for i := range array {
		for prev.Next != nil {
			prev = prev.Next
		}
		if i != 0 {
			prev.Next = array[i]
		}
	}
	return array[0]
}
func reverseLinkedList(head *Node.LinkedList) *Node.LinkedList {
	var rest *Node.LinkedList
	if head == nil || head.Next == nil {
		return head
	}
	rest = reverseLinkedList(head.Next)
	head.Next.Next = head
	head.Next = nil

	return rest
}
