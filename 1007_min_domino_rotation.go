 package main

import(
	"fmt"
	// "math"
)

// type Pair struct{
// 	X int
// 	Y int
// }
func main(){
	
	tops := []int {2,1,2,4,2,2}
	bottoms  := []int {5,2,6,2,3,2}
	var res int =minDominoRotations(tops,bottoms)
	
    fmt.Println(res)
}

  func minDominoRotations(tops []int, bottoms []int) int {

    var len int = len(tops)
   	var topCandidate int = tops[0]
	var bottomCandidate int = bottoms[0]

	var topCount int = calculateMinRotation(tops,bottoms,topCandidate,len)
	if topCount !=-1{
		return topCount
	}else if topCandidate != bottomCandidate{

		return calculateMinRotation(tops,bottoms,bottomCandidate,len)
	}
	return -1
	     
}

func calculateMinRotation(tops[]int,bottoms[]int,key int,len int) int{
	var topConversion int =0
	var bottomConversion int =0 
	for i:=0;i<len;i++{
		if key != bottoms[i] && key != tops[i]{
			return -1
		}else if key != tops[i]{
			topConversion++
		}else if key != bottoms[i]{
			bottomConversion++
		}
	}
	return min(topConversion, bottomConversion) 
}

func min(a,b int)int{
		if a<b{
			return a
		}
		return b
}

