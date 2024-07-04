package main

import (
	"fmt"
)

func main() {
	mat := [][]int{
		{7, 7, 5},
		{2, 4, 6},
		{8, 2, 0},
	}

	n := len(mat)
	m := len(mat[0])

	// count := 1
	visited := make([][]int, n)
	dp := make([][]int, n)

	for i := 0; i < n; i++ {
		dp[i] = make([]int, m)
		visited[i] = make([]int, m)
	}

	res := 1
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {

			res = max(res, solveDp(mat, i, j, n, m, &visited, &dp))

		}

	}

	fmt.Println(res)

}

func solve(mat [][]int, row int, col int, n int, m int, res int, count *int, visited *[][]int) {

	// fmt.Println(count)

	if row >= n || row < 0 || col >= m || col < 0 || (*visited)[row][col] == 1 {

		return
	}

	(*visited)[row][col] = 1

	*count = max(*count, res)

	if row+1 < n && mat[row][col] < mat[row+1][col] {
		solve(mat, row+1, col, n, m, res+1, count, visited)
	}

	if row-1 >= 0 && mat[row][col] < mat[row-1][col] {
		solve(mat, row-1, col, n, m, res+1, count, visited)
	}

	if col+1 < m && mat[row][col] < mat[row][col+1] {
		solve(mat, row, col+1, n, m, res+1, count, visited)
	}

	if col-1 >= 0 && mat[row][col] < mat[row][col-1] {
		solve(mat, row, col-1, n, m, res+1, count, visited)
	}
	(*visited)[row][col] = 0
}

func solveDp(mat [][]int, row int, col int, n int, m int, visited *[][]int, dp *[][]int) int {
	if row >= n || row < 0 || col >= m || col < 0 || (*visited)[row][col] == 1 {

		return 0
	}

	(*visited)[row][col] = 1

	if (*dp)[row][col] != 0 {
		(*visited)[row][col] = 0
		return (*dp)[row][col]
	}

	res := 1

	if row+1 < n && mat[row][col] < mat[row+1][col] {
		res = max(res, 1+solveDp(mat, row+1, col, n, m, visited, dp))
	}

	if row-1 >= 0 && mat[row][col] < mat[row-1][col] {
		res = max(res, 1+solveDp(mat, row-1, col, n, m, visited, dp))
	}

	if col+1 < m && mat[row][col] < mat[row][col+1] {
		res = max(res, 1+solveDp(mat, row, col+1, n, m, visited, dp))
	}

	if col-1 >= 0 && mat[row][col] < mat[row][col-1] {
		res = max(res, 1+solveDp(mat, row, col-1, n, m, visited, dp))
	}
	(*visited)[row][col] = 0
	(*dp)[row][col] = res

	return res

}

func max(a int, b int) int {
	if a < b {
		return b
	} else {
		return a
	}
}
