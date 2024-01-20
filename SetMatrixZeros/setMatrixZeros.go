package main

import "fmt"

var N int
var M int

type Index struct {
	a, b interface{}
}

func main() {

	matrix := [][]int{
		{0, 1, 2, 0},
		{3, 4, 5, 2},
		{1, 3, 1, 5},
	}

	N = len(matrix)
	M = len(matrix[0])
	var arrayIndex []Index

	for i := 0; i < N; i++ {
		for j := 0; j < M; j++ {
			if matrix[i][j] == 0 {
				arrayIndex = append(arrayIndex, Index{i, j})
			}
		}
	}
	for _, val := range arrayIndex {

		a := val.a.(int)
		b := val.b.(int)
		make_row_zero(matrix, a)
		make_col_zero(matrix, b)
	}

	for _, val := range matrix {
		fmt.Println(val)
	}

}
func make_row_zero(matrix [][]int, row int) {

	for i := 0; i < M; i++ {
		matrix[row][i] = 0
	}
}

func make_col_zero(matrix [][]int, col int) {

	for i := 0; i < N; i++ {
		matrix[i][col] = 0
	}
}
