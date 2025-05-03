package main

import(
	"fmt"
	"strings"
	// "strconv"
)

func main(){

	var dominoes string = "RR.L"
	fmt.Println(pushDominoes(dominoes))
	
}


func pushDominoes(dominoes string) string {



	runes := []rune(dominoes)
	var len int = len(dominoes)
	var array []int = make([]int,len)
	var power int =0
	//Left to right
	for i:=0;i<len;i++{
		if runes[i]=='L'{
			// fmt.Println("Left",runes[i])
			power =0
		}else if runes[i]=='R'{
			// fmt.Println("Right",runes[i])
			power = len
		}else if power>0{
			power-=1
		}
		array[i]=power
	}
	power =0
	for i:=len-1;i>=0;i--{
		if runes[i] == 'L'{
			power = len
		}else if runes[i] == 'R'{
			power = 0
		}else if power>0{
			power -=1
		}
		array[i]-=power
	}
	strArr := make([]string,len)
	for i,v:= range array{
		strArr[i] = func(x int)string{
			if x>0{				
			return "R"
			}else if x<0{
				return "L"
			}else{
				return "."
			}
		}(v)
	}
	result := strings.Join(strArr,"")
	// fmt.Println("res",result)
	return result    
}
