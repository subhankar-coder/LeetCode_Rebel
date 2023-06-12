package main
import( 
	"myGoApp/Node" 
	"fmt"
)

func main(){
	var linkedList Node.LinkedList
	linkedList.Val=1
	linkedList.Insert(1)
	linkedList.Insert(2)
	linkedList.Insert(2)
	linkedList.Insert(3)
	linkedList.Insert(3)
	removeDuplicate(&linkedList)
}
func removeDuplicate(head *Node.LinkedList){

	if head==nil || head.Next==nil{
		return 
	}
	var prev = head
	var temp = head
	var result Node.LinkedList
	result.Insert(head.Val)

	for temp!=nil{
		if temp.Val!=prev.Val{
			fmt.Printf("prev %d and temp %d \n",prev.Val,temp.Val)
			result.Insert(temp.Val)
			prev=temp
		}
		temp=temp.Next
	}
	result.Next.Display()
}
