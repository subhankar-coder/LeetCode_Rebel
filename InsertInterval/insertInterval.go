package main

import (
	"fmt"
)

func main() {

	intervals := [][]int{
		{1, 3}, {6, 9},
	}
	newInterval := []int{2, 5}
	if len(intervals)==0{
		intervals=append(intervals,newInterval)
	}
	for i, _ := range intervals {

		if intervals[i][0] >= newInterval[0] {
			intervals = append(intervals, []int{0})
			copy(intervals[i+1:], intervals[i:])
			intervals[i] = newInterval
			break
		} else if i+1 == len(intervals) {
			intervals = append(intervals, newInterval)
		}
	}
	mergeIntervals(intervals)
	fmt.Println(mergeIntervals(intervals))

}

func mergeIntervals(intervals [][]int) [][]int {

	var start int = 0
	var end int = start + 1

	for end < len(intervals) {
		if intervals[start][1] >= intervals[end][0] {
			if intervals[start][1] > intervals[end][1] {
				intervals = append(intervals[:start+1], intervals[start+2:]...)
			} else {
				intervals[start][1] = intervals[end][1]
				intervals = append(intervals[:start+1], intervals[start+2:]...)
			}
		} else {
			start = end
			end++
		}
	}
	return intervals
}
