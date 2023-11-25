package main

import "fmt"

var N int

func main() {

	// matrix := [][]int{
	// 	{1, 2, 3, 4, 5},
	// 	{6, 7, 8, 9, 10},
	// 	{11, 12, 13, 14, 15},
	// 	{16, 17, 18, 19, 20},
	// 	{21, 22, 23, 24, 25},
	// }

	matrix := [][]int{
		{1, 2, 3, 4},
		{5, 6, 7, 8},
		{9, 10, 11, 12},
		{13, 14, 15, 16},
	}
	N = len(matrix)
	spiralOrder(matrix)

	for _, val := range matrix {
		fmt.Println(val)
	}

}

func spiralOrder(matrix [][]int) {

	isVisited := make([][]int, N)
	for i := 0; i < N; i++ {
		isVisited[i] = make([]int, N)
		copy(isVisited[i], matrix[i])
	}

	var u int = 0
	var d int = N - 1
	var r int = N - 1
	var l int = 0
	var seed int = N - 1

	var row int = 0
	var col int = 0

	for u <= d && l <= r {

		if seed <= 0 {
			break
		}

		//ele of the toppest row

		for col = l; col <= r; col++ {
			if col+seed <= r {
				matrix[u][col+seed] = isVisited[u][col]
			} else {
				matrix[u+col+seed-r][r] = isVisited[u][col]
			}
		}
		u++

		//ele of the rightest col

		for row = u; row <= d; row++ {
			if row+seed <= d {
				matrix[row+seed][r] = isVisited[row][r]
			} else {
				matrix[d][r-(row+seed-d)] = isVisited[row][r]
			}
		}
		r--

		//ele of the downest row

		for col = r; col >= l; col-- {
			if seed <= col-l {
				matrix[d][l+seed-col] = isVisited[d][col]
			} else {
				matrix[d-(seed-(col-l))][l] = isVisited[d][col]
			}
		}
		d--

		//ele of the leftest col

		for row = d; row >= u; row-- {

			if u+seed <= row {
				matrix[row-seed][l] = isVisited[row][l]
			} else {
				matrix[u-1][l+seed-(row-(u-1))] = isVisited[row][l]
			}

		}
		l++
		seed = seed - 2

	}
	// fmt.Println(matrix)

}
