package main

import(
	"fmt"
	"math"
)

func main(){
	fmt.Println(maxDifference("abbbcccccddddddddeeeeeeeeffffffff"))
}

func maxDifference(s string) int {
    mp := make(map[rune]int)
	
	var even int = math.MaxInt
	var odd  int = math.MinInt
	for _,ch := range s{
		
		mp[ch] = mp[ch]+1
		
	}
    for _,val := range mp{
        fmt.Println(val)
        if val%2==0{
            even=min(even,val)
        }else{
            odd = max(odd,val)
        }
        
    }
	return odd-even
}

func max(a,b int)int{
	if a<b{
		return b
	}
	return a
}

func min(a,b int)int{
	if a<b{
		return a
	}
	return b
}