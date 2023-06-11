package main

import "myGoApp/Node"

func main() {
	var linkedList Node.LinkedList
	linkedList.Val = 1
	linkedList.Insert(2)
	linkedList.Insert(3)
	// linkedList.Insert(4)
	// linkedList.Insert(5)
	rotateList(&linkedList, 2).Display()

}
func rotateList(head *Node.LinkedList, k int) *Node.LinkedList {
	var dupHead = head
	if(k<=0){
		return head
	}

	
for dupHead.Next.Next != nil {
		dupHead = dupHead.Next
	}
	var newHead = dupHead.Next
	newHead.Next = head
	dupHead.Next = nil
	return rotateList(newHead, k-1)
}
