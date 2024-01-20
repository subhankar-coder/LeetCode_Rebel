package Node

type LinkedList struct {
	Val  int
	Next *LinkedList `default:"nil"`
}

func (l *LinkedList) Insert(val int) {

	list := &LinkedList{

		Val:  val,
		Next: nil,
	}
	if l == nil {
		l = list
		return
	} else {
		for l.Next != nil {
			l = l.Next
		}
	}
	l.Next = list
}
func (L *LinkedList) Display() {
	if L != nil {
		for L != nil {
			print(L.Val," ")
			L = L.Next
		}
	}
}

func (linkedList *LinkedList) Remove(n int) *LinkedList {
	if n == 0 {
		linkedList = linkedList.Next
	}
	var head = linkedList
	var prevHead = linkedList
	for i := 0; i < n; i++ {
		prevHead = head
		head = head.Next
	}
	if head.Next != nil {
		prevHead.Next = head.Next
	}
	return linkedList
}
func (l *LinkedList) Len() int {
	var count = 0
	for l != nil {
		count++
		l = l.Next
	}
	return count
}
