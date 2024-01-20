package main

import "myGoApp/Node"

func main() {
	var linkedList Node.LinkedList
	linkedList.Val = 1
	linkedList.Insert(2)
	linkedList.Insert(3)
	linkedList.Insert(4)
	linkedList.Insert(5)
	removeNthFromEnd(&linkedList, 1)

}

func removeNthFromEnd(linkedList *Node.LinkedList, n int) {
	var len = linkedList.Len()
	var result = linkedList.Remove(len - n)
	result.Display()

}
