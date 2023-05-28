package Node

type LinkedList struct {
	Val  int
	Next *LinkedList
}

func (l *LinkedList) Insert(val int) {

	list := &LinkedList{

		Val:  val,
		Next: nil,
	}
	if l == nil {
		l = list
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
			println(L.Val)
			L = L.Next
		}
	}
}
