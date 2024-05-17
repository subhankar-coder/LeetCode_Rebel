package main

import (
	"container/heap"
	"fmt"
	"math"
)

type Node struct {
	score    int
	location []int
}

type PriorityQueue []*Node

func (pq PriorityQueue) Len() int {
	return len(pq)
}
func (pq PriorityQueue) Less(i, j int) bool {
	return pq[i].score > pq[j].score
}
func (pq PriorityQueue) Swap(i, j int) {
	pq[i], pq[j] = pq[j], pq[i]
}

func (pq *PriorityQueue) Push(x interface{}) {
	*pq = append(*pq, x.(*Node))
}

func (pq *PriorityQueue) Pop() interface{} {

	ln := len(*pq)
	item := (*pq)[ln-1]
	*pq = (*pq)[:ln-1]

	return item
}

func main() {
	grid := [][]int{
		{0, 0, 0, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}, {1, 0, 0, 0},
	}

	n := len(grid)
	bfs := make([][]int, n)

	for i := 0; i < n; i++ {
		bfs[i] = make([]int, n)
		for j := 0; j < n; j++ {
			if grid[i][j] == 1 {
				bfs[i][j] = 0
			} else {
				bfs[i][j] = math.MaxInt
			}

		}
	}

	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 1 {
				performBFS(&bfs, i, j, n)
			}
		}
	}

	fmt.Println(bfs)

	r := min(bfs[0][0], bfs[n-1][n-1])
	// upperLimit:= r
	l := 0
	result := 0

	for l <= r {
		mid := l + (r-l)/2

		if isPathAvailable(&bfs, mid, n) {
			result = mid
			l = mid + 1
		} else {
			r = mid - 1
		}

	}

	fmt.Println(result)
	fmt.Println(getMinSafteyFactor(&bfs, n))

}

func getMinSafteyFactor(bfs *[][]int, n int) int {
	pq := make(PriorityQueue, 0)
	heap.Push(&pq, &Node{(*bfs)[0][0], []int{0, 0}})
	safeScore := math.MaxInt
	visited := make([][]bool, n)
	for i := 0; i < n; i++ {
		visited[i] = make([]bool, n)
	}
	for pq.Len() != 0 {

		node := heap.Pop(&pq).(*Node)
		row := node.location[0]
		col := node.location[1]

		safeScore = min(safeScore, node.score)
		if row == n-1 && col == n-1 {
			// safeScore=node.score
			break
		}

		rowList := []int{1, -1, 0, 0}
		colList := []int{0, 0, 1, -1}

		for i := 0; i < 4; i++ {
			if isSafe(&visited, row+rowList[i], col+colList[i], n) {
				heap.Push(&pq, &Node{(*bfs)[row+rowList[i]][col+colList[i]], []int{row + rowList[i], col + colList[i]}})
			}
		}

	}

	return safeScore

}

func isPathAvailable(bfs *[][]int, limit int, n int) bool {

	queue := [][]int{}
	queue = append(queue, []int{0, 0})
	visited := make([][]bool, n)
	for i := 0; i < n; i++ {
		visited[i] = make([]bool, n)
	}

	for len(queue) != 0 {
		length := len(queue)

		for i := 0; i < length; i++ {
			row := queue[0][0]
			col := queue[0][1]

			queue = queue[1:]

			if row == n-1 && col == n-1 {
				return true
			}

			if isSafe(&visited, row+1, col, n) && (*bfs)[row+1][col] >= limit {
				queue = append(queue, []int{row + 1, col})
			}

			if isSafe(&visited, row-1, col, n) && (*bfs)[row-1][col] >= limit {
				queue = append(queue, []int{row - 1, col})
			}

			if isSafe(&visited, row, col+1, n) && (*bfs)[row][col+1] >= limit {
				queue = append(queue, []int{row, col + 1})
			}

			if isSafe(&visited, row, col-1, n) && (*bfs)[row][col-1] >= limit {
				queue = append(queue, []int{row, col - 1})
			}

		}

	}

	return false

}

func performBFS(bfs *[][]int, r int, c int, n int) {

	queue := [][]int{}
	level := 0

	queue = append(queue, []int{r, c})
	visited := make([][]bool, n)
	for i := 0; i < n; i++ {
		visited[i] = make([]bool, n)
	}

	for len(queue) != 0 {

		length := len(queue)

		for i := 0; i < length; i++ {

			row := queue[0][0]
			col := queue[0][1]

			queue = queue[1:]
			if isSafe(&visited, row+1, col, n) {
				queue = append(queue, []int{row + 1, col})
				(*bfs)[row+1][col] = min((*bfs)[row+1][col], level+1)
			}

			if isSafe(&visited, row-1, col, n) {
				queue = append(queue, []int{row - 1, col})
				(*bfs)[row-1][col] = min((*bfs)[row-1][col], level+1)
			}

			if isSafe(&visited, row, col+1, n) {
				queue = append(queue, []int{row, col + 1})
				(*bfs)[row][col+1] = min((*bfs)[row][col+1], level+1)
			}

			if isSafe(&visited, row, col-1, n) {
				queue = append(queue, []int{row, col - 1})
				(*bfs)[row][col-1] = min((*bfs)[row][col-1], level+1)
			}
		}
		level++

	}

}

func isSafe(visited *[][]bool, r int, c int, n int) bool {
	if r >= n || r < 0 || c >= n || c < 0 || (*visited)[r][c] {
		return false
	}
	(*visited)[r][c] = true
	return true
}

func min(a int, b int) int {
	if a < b {
		return a
	}
	return b
}
