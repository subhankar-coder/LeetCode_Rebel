package main

import "myGoApp/Node"

func main() {
	var linkedList Node.LinkedList
	var linkedList1 Node.LinkedList
	var linkedList2 Node.LinkedList
	linkedList.Val = 1
	linkedList.Insert(4)
	linkedList.Insert(5)

	linkedList1.Val = 1
	linkedList1.Insert(3)
	linkedList1.Insert(4)

	linkedList2.Val = 2
	linkedList2.Insert(6)

	lists := []*Node.LinkedList{&linkedList, &linkedList1, &linkedList2}
	mergeKLists(lists)

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
func mergeKLists(lists []*Node.LinkedList) {
	var last = len(lists) - 1
	var i = 0
	for i < last {
		lists[i] = mergetwoList(lists[i], lists[last])
		last--
	}
	lists[0].Display()

}
