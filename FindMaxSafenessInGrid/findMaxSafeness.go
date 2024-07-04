package main

import (
	"fmt"
	"math"
)

func main() {

	grid := [][]int{
		{1, 1, 1},
		{0, 1, 1},
		{0, 0, 0},
	}

	n := len(grid)
	visited := make([][]int, n)
	bfs:= make([][]int ,n)
	for i := 0; i < n; i++ {
		visited[i] = make([]int, n)
		bfs[i]= make([]int,n)
	}

	
	maxManhatanDist := 0

	allPath(grid, 0, 0, n, &visited, &theifLocation, math.MaxInt, &maxManhatanDist)
	fmt.Println(maxManhatanDist)

}
func allPath(grid [][]int, r int, c int, n int, visited *[][]int, theifLocation *[][]int, manhatanDist int, maxManhatanDist *int) {

	if r >= n || r < 0 || c >= n || c < 0 || (*visited)[r][c] == 1 {

		return
	}

	fmt.Println(r, c)
	manhatanDist = min(manhatanDist, minManhatenDistance(theifLocation, r, c, n))
	if r == n-1 && c == n-1 {
		fmt.Println("ended", manhatanDist)
		*maxManhatanDist = max(*maxManhatanDist, manhatanDist)
	}
	(*visited)[r][c] = 1

	allPath(grid, r+1, c, n, visited, theifLocation, manhatanDist, maxManhatanDist)
	allPath(grid, r-1, c, n, visited, theifLocation, manhatanDist, maxManhatanDist)
	allPath(grid, r, c+1, n, visited, theifLocation, manhatanDist, maxManhatanDist)
	allPath(grid, r, c-1, n, visited, theifLocation, manhatanDist, maxManhatanDist)

	(*visited)[r][c] = 0
}

func abs(a int, b int) int {
	if a-b < 0 {
		return b - a
	}
	return a - b
}

func min(a int, b int) int {
	if a < b {
		return a
	}
	return b
}

func max(a int, b int) int {
	if a < b {
		return b
	}
	return a
}

func minManhatenDistance(theifLocation *[][]int, r int, c int, n int) int {

	if r >= n || r < 0 || c >= n || c < 0 {
		return math.MaxInt
	}
	dist := math.MaxInt
	for _, slice := range *theifLocation {
		dist = min(dist, abs(slice[0], r)+abs(slice[1], c))
	}
	return dist
}
