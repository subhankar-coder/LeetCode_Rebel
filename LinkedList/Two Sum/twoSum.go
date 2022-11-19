package main

import "fmt"

type ListNode struct {
	val  int
	next *ListNode
}

func insert(L *ListNode, val int) {
	list := &ListNode{
		val:  val,
		next: nil,
	}
	for L.next != nil {
		L = L.next
	}
	L.next = list

}

func display(L *ListNode) {
	for L != nil {

		fmt.Print(fmt.Sprintf("%v", L.val) + " ")
		L = L.next
	}
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) (head *ListNode) {
	borrow := 0
	head = &ListNode{
		val:  -1,
		next: nil,
	}
	for l1 != nil || l2 != nil {
		digitAdd := 0
		if l1 == nil {
			digitAdd = l2.val + borrow
			l2 = l2.next
		} else if l2 == nil {
			digitAdd = l1.val + borrow
			l1 = l1.next
		} else {
			digitAdd = l1.val + l2.val + borrow
			l1 = l1.next
			l2 = l2.next
		}
		borrow = digitAdd / 10
		digitAdd = digitAdd % 10
		if head.val == -1 {
			head.val = digitAdd
			
		} else {
			insert(head, digitAdd)
		}
		if l1 == nil && l2 == nil && borrow != 0 {
			insert(head, borrow)
			borrow = 0
		}

	}

	return

}

func main() {
	L1 := &ListNode{
		val:  5,
		next: nil,
	}
	// insert(L1, 9)
	// insert(L1, 9)
	// insert(L1, 9)
	// insert(L1, 9)
	// insert(L1, 9)
	// insert(L1, 9)
	L2 := &ListNode{
		val:  5,
		next: nil,
	}
	// insert(L2, 9)
	// insert(L2, 9)
	// insert(L2, 9)

	head := addTwoNumbers(L1, L2)
	display(head)

}
