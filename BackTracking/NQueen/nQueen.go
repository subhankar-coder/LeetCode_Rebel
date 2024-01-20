package main

import "fmt"

func main() {
	var n = 4
	var board = make([][]int, n)
	for i := range board {
		var init = make([]int, n)
		board[i] = init
	}
	if getSolution(board, 0, n) {
		fmt.Print("herr")
		fmt.Println(board)
	}
}
func isSafe(board [][]int, row int, col int, n int) bool {
	//check the cols
	for i, j := col+1, col-1; i < n || j >= 0; i, j = i+1, j-1 {
		if j >= 0 && board[row][j] == 1 {
			return false
		}
		if i < n && board[row][i] == 1 {
			return false
		}
	}
	//check the rows
	for i, j := row+1, row-1; i < n || j >= 0; i, j = i+1, j-1 {
		if j >= 0 && board[j][col] == 1 {
			return false
		}
		if i < n && board[i][col] == 1 {
			return false
		}
	}
	//check the up diagonal
	for h, i, j, k := row+1, row-1, col+1, col-1; i >= 0 || h < n; i, h = i-1, h+1 {

		if k >= 0 && i >= 0 && board[i][k] == 1 {
			return false
		}
		if j < n && i >= 0 && board[i][j] == 1 {
			return false
		}
		if k >= 0 && h < n && board[h][k] == 1 {
			return false
		}
		if j < n && h < n && board[h][j] == 1 {
			return false
		}
		j++
		k--
	}

	return true
}

func getSolution(board [][]int, col int, n int) bool {
	if col >= n {
		// fmt.Println(board)
		return true
	}
	for i := 0; i < n; i++ {
		if isSafe(board, i, col, n) {
			board[i][col] = 1
		}
		//fmt.Println(board)
		getSolution(board, col+1, n)
		board[i][col] = 0
	}
	return false
}
