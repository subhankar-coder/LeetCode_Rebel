package main

import(
	"fmt"
)

const MOD = 1_000_000_007

func main(){
	s,t :=  "azbk",1
	fmt.Println(lengthAfterTransformations(s,t))
}

func lengthAfterTransformations(s string, t int) int {
	array := make([]int,26)
	for _,ch := range s{
		array[ch-97] += 1
	}
	// fmt.Println(array)
	// dupArray := make([]int,26)

	// count := 0
	
	for t >0 {
		// for index,ele := range array{
		// 	if array[index]!=0{
		// 		if index == 25{
		// 			array[25] =0
		// 			dupArray[0] = (dupArray[0]+ele) % MOD
		// 			dupArray[1] = (dupArray[1]+ele) % MOD
		// 			if t==1{
		// 				count = (count+2*ele) % MOD
		// 			}
		// 		}else{
		// 			dupArray[index+1] = (dupArray[index+1]+ele) % MOD
		// 			array[index] = 0
		// 			if t==1{
		// 				count = (count+ele)%MOD
		// 			}
		// 		}
		// 	}
		// }

		// better approach 

		tmp := array[25]
        copy(array[1:],array[:25])
		array[0]=tmp

        if array[0] > 0{
            array[1] = (array[0]+array[1]) % MOD
        }
		//
		// array,dupArray = dupArray,array	
		
		t--
	}
	
	count :=0
    for _,ele := range array{
        count = (count+ele) %MOD
    }

	return count
}