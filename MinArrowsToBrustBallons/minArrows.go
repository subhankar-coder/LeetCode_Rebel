package main

import (
	"fmt"
	"math"
	"sort"
)

func main() {

	points := [][]int{{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}}

	sort.SliceStable(points, func(i, j int) bool {
		if points[i][0] == points[j][0] {
			return points[i][1] < points[j][1]
		}
		return points[i][0] < points[j][0]
	})

	mergeOverlapping(points)
}
func mergeOverlapping(points [][]int) {
	var start int = 0
	var end int = start + 1
	var endPoint = points[start][1]
	// var startPoint = points[start][0]

	var count = len(points)

	for end < len(points) {
		
		if points[end][0]<= endPoint{
			count--
			endPoint=int (math.Min(float64(points[end][1]),float64(endPoint)))
		}else{
			start=end
			endPoint=points[start][1]
		}

		end++
	}
	fmt.Println(count)
}
