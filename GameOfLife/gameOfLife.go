package main

import "fmt"

var R int
var C int


func main() {

	board := [][]int{
		{0, 1, 0},
		{0, 0, 1},
		{1, 1, 1},
		{0, 0, 0},
	}
	R = len(board)
	C = len(board[0])

	status := make([][]int, R)

	for i := 0; i < R; i++ {
		status[i] = make([]int, C)
	}

	for i := 0; i < R; i++ {
		for j := 0; j < C; j++ {

			live := number_of_live_and_dead_neighbout(board, i, j)
			status[i][j] = live
			// fmt.Println("the ele is ", i, j, " the number of live cell ", live, " the number of dead cell ", dead)
		}
	}

	for i:=0;i<R;i++{
		for j:=0;j<C;j++{
			processRules(board,i,j,status[i][j])
		}
	}

	printMatrix(board)

}

func number_of_live_and_dead_neighbout(board [][]int, row int, col int)int {
	var live int = 0

	// check the above cell
	if row-1 >= 0 {
		if board[row-1][col] == 1 {
			live++
		} 
	}

	// check the below cell

	if row+1 < R {
		if board[row+1][col] == 1 {
			live++
		}
	}

	// check the right cell

	if col+1 < C {
		if board[row][col+1] == 1 {
			live++
		} 
	}

	// check the left cell

	if col-1 >= 0 {
		if board[row][col-1] == 1 {
			live++
		} 
	}

	//check the up diagonal

	if col-1 >= 0 && row-1 >= 0 {
		if board[row-1][col-1] == 1 {
			live++
		} 
	}

	if col+1 < C && row+1 < R {
		if board[row+1][col+1] == 1 {
			live++
		} 
	}

	// check the down diagonal

	if col+1 < C && row-1 >= 0 {
		if board[row-1][col+1] == 1 {
			live++
		} 
	}

	if col-1 >= 0 && row+1 < R {
		if board[row+1][col-1] == 1 {
			live++
		} 
	}

	return live

}

func processRules(board [][]int, row int, col int,live int  ) {

	// Rule 1: Any live cell with fewer than two live neighbors dies as if caused by under-population
	// Rule 2: Any live cell with two or three live neighbors lives on to the next generation.
	// Rule 3: Any live cell with more than three live neighbors dies, as if by over-population
	// Rule 4: Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

	if board[row][col] == 1 {

		if live < 2 {
			board[row][col] = 0
		} else if live >= 2 && live <= 3 {
			board[row][col] = 1
		} else if live > 3 {
			board[row][col] = 0
		}
	} else {
		if live == 3 {
			board[row][col] = 1
		}
	}
}

func printMatrix(board [][] int ){
	
	for _,val:= range board{
		fmt.Println(val)
	} 
}
