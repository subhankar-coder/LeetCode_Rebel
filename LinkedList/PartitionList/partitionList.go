package main

import "myGoApp/Node"

func main(){
	var linkedList Node.LinkedList
	var less Node.LinkedList
	var higher Node.LinkedList
	linkedList.Val=1
	linkedList.Insert(4)
	linkedList.Insert(3)
	linkedList.Insert(2)
	linkedList.Insert(5)
	linkedList.Insert(2)
	partition(&linkedList,0,&less,&higher).Display()
}
func partition(head *Node.LinkedList,x int,less *Node.LinkedList, higher *Node.LinkedList) *Node.LinkedList{
	if head==nil || head.Next==nil{
		return head
	}

	var result *Node.LinkedList
	for head!=nil{
		if head.Val<x{
			less.Insert(head.Val)
		}else{
			higher.Insert(head.Val)
		}
		head=head.Next
	}
	if less!=nil{
		if less.Next==nil{
			
			return higher.Next
		}else{
			result=less.Next
			for less.Next!=nil{
			less=less.Next
		}
	}
	less.Next=higher.Next
	}
	
	return result
}
