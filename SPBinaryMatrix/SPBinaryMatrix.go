package main

import "fmt"

type Pair struct {
	row int
	col int
}

func main() {

	grid := [][]int{
		{1, 0, 0}, {1, 1, 0}, {1, 1, 0},
	}

	n := len(grid)
	visited := make([][]bool, n)
	for i := 0; i < n; i++ {
		visited[i] = make([]bool, n)
	}
	// fmt.Println(visited)
	fmt.Print(solve(grid, n, visited))
}

func solve(grid [][]int, n int, visited [][]bool) int {

	level := 0
	queue := []Pair{}
	if grid[0][0] == 0 {

		queue = append(queue, Pair{0, 0})
	}
	for len(queue) > 0 {
		length := len(queue)
		for i := 0; i < length; i++ {
			peek := queue[i]
			row := peek.row
			col := peek.col

			if row == n-1 && col == n-1 {
				// fmt.Println(level)
				return level
			}

			if !visited[row][col] {

				visited[row][col] = true

				//row down
				if row+1 < n && grid[row+1][col] == 0 {
					queue = append(queue, Pair{row + 1, col})
				}
				//row up
				if row-1 >= 0 && grid[row-1][col] == 0 {
					queue = append(queue, Pair{row - 1, col})
				}
				//col right
				if col+1 < n && grid[row][col+1] == 0 {
					queue = append(queue, Pair{row, col + 1})
				}
				//col left
				if col-1 >= 0 && grid[row][col-1] == 0 {
					queue = append(queue, Pair{row, col - 1})
				}
				//right down
				if row+1 < n && col+1 < n && grid[row+1][col+1] == 0 {
					queue = append(queue, Pair{row + 1, col + 1})
				}
				//left down
				if row+1 < n && col-1 >= 0 && grid[row+1][col-1] == 0 {
					queue = append(queue, Pair{row + 1, col - 1})
				}
				//right up
				if row-1 >= 0 && col+1 < n && grid[row-1][col+1] == 0 {
					queue = append(queue, Pair{row - 1, col + 1})
				}
				//left up
				if row-1 >= 0 && col-1 >= 0 && grid[row-1][col-1] == 0 {
					queue = append(queue, Pair{row - 1, col - 1})
				}
			}
		}
		level++
		queue = queue[length:]

	}

	return -1
}
