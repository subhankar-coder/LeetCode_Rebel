package main

import "myGoApp/Node"

func main() {
	var linkedList Node.LinkedList
	linkedList.Val = 1
	linkedList.Insert(3)
	linkedList.Insert(4)

	var linkedList2 Node.LinkedList
	linkedList2.Val = 1
	linkedList2.Insert(2)
	linkedList2.Insert(4)
	result := mergetwoList(&linkedList, &linkedList2)
	result.Display()
}
func mergetwoList(list1 *Node.LinkedList, list2 *Node.LinkedList) *Node.LinkedList {
	if list1 == nil {
		return list2
	} else if list2 == nil {
		return list1
	}
	var result *Node.LinkedList
	if list1.Val < list2.Val {
		result = list1
		result.Next = mergetwoList(list1.Next, list2)
	} else {
		result = list2
		result.Next = mergetwoList(list1, list2.Next)
	}
	return result
}
