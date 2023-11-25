package main

import (
	"fmt"
	"strconv"
)

var N int = 9

func main() {
	data := [][]string{
		{"8" , "3", ".", ".", "7", ".", ".", ".", "."},
		{"6", ".", ".", "1", "9", "5", ".", ".", "."},
		{".", "9", "8", ".", ".", ".", ".", "6", "."},
		{"8", ".", ".", ".", "6", ".", ".", ".", "3"},
		{"4", ".", ".", "8", ".", "3", ".", ".", "1"},
		{"7", ".", ".", ".", "2", ".", ".", ".", "6"},
		{".", "6", ".", ".", ".", ".", "2", "8", "."},
		{".", ".", ".", "4", "1", "9", ".", ".", "5"},
		{".", ".", ".", ".", "8", ".", ".", "7", "9"}}
	fmt.Println(solve(data))
	for _, val := range data {
		fmt.Println(val)
	}

}
func isSafe(data [][]string, row int, col int, c int) bool {
	if row >= N || row < 0 || col >= N || col < 0 {
		return false
	}
	//check row wise data

	for i := 0; i < N; i++ {

		if data[i][col] == "." {
			continue
		}
		value, _ := strconv.Atoi(data[i][col])
		if value == c {
			return false
		}

	}

	//check col wise

	for i := 0; i < N; i++ {

		if data[row][i] == "." {
			continue
		}

		value, _ := strconv.Atoi(data[row][i])
		if value == c {
			return false
		}
	}

	//check grid wise

	var sRow int = 0 + 3*(row/3)
	var sCol int = 0 + 3*(col/3)

	for i := sRow; i < sRow+3; i++ {
		for j := sCol; j < sCol+3; j++ {

			if data[i][j] == "." {
				continue
			}

			value, _ := strconv.Atoi(data[i][j])
			if value == c {
				return false
			}
		}

	}
	return true
}
func solve(data [][]string) bool {
	var isFilled bool = true
	var row = -1
	var col = -1

	for i := 0; i < N; i++ {
		for j := 0; j < N; j++ {
			if data[i][j] == "." {
				row = i
				col = j
				isFilled = false
				break
			}
		}
		if !isFilled {
			break
		}

	}

	if isFilled {
		return true
	}

	for c := 1; c <= N; c++ {
		if isSafe(data, row, col, c) {
			data[row][col] = strconv.Itoa(c)
			if solve(data) {
				return true
			} else {
				data[row][col] = "."
			}
		}
	}

	return false
}
