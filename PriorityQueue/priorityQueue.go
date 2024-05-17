package main

import (
	"container/heap"
	"fmt"
)

type Node struct {
	priority int
	location []int
}

type PriorityQueue []*Node

func (pq PriorityQueue) Len() int { return len(pq) }

func (pq PriorityQueue) Less(i, j int) bool { return pq[i].priority < pq[j].priority }

func (pq PriorityQueue) Swap(i, j int) {
	pq[i], pq[j] = pq[j], pq[i]
}

func (pq *PriorityQueue) Push(x interface{}) {
	*pq = append(*pq, x.(*Node))
}

func (pq *PriorityQueue) Pop() interface{} {
	old := *pq

	ln := len(old)

	item := old[ln-1]

	*pq = old[:ln-1]

	return item
}

func main() {
	pq := make(PriorityQueue, 0)
	heap.Push(&pq, &Node{3, []int{0, 0}})
	heap.Push(&pq, &Node{1, []int{1, 0}})
	heap.Push(&pq, &Node{31, []int{0, 1}})
	heap.Push(&pq, &Node{13, []int{2, 0}})

	fmt.Println(heap.Pop(&pq).(*Node))
}
