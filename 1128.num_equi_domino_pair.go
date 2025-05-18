package main

import(
	"fmt"
)

func main(){
	var dominoes [][]int = [][]int{{1,1},{2,2},{1,1},{1,2},{1,2},{1,1}};
	numEquivDominoPairs(dominoes)
	// fmt.Println(dominoes)
}

func numEquivDominoPairs(dominoes [][]int) int {
	var mp map[[2]int]int = make(map[[2]int]int)
	for _,row:= range dominoes{
		a := row[0]
		b := row[1]
		key := [2]int{min(a,b), max(a,b)}
		
		mp[key]++
	
	}
	fmt.Println(mp)
	var res int =0
	for _,val := range mp{
		if val >1{
			res += (val*(val-1)/2)
		}
	}
	fmt.Println(res)
	return 0
}

func min(a,b int)int{
	if a<b{
		return a
	}
	return b
}

func max(a,b int)int{
	if a<b{
		return b
	}
	return a
}


