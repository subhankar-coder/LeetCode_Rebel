package main

import (
	"fmt"
	"math"
	"strconv"
)

func main(){
	str:= "abcabc"
	len:= len(str)

	dp:= make([][]int ,len)
	for i:=0;i<len;i++{
		dp[i]=make([]int ,len)
	}

	for i:=0;i<len;i++{
		dp[i][i]=0;
		if i+1<len &&str[i+1]==str[i]{
			dp[i][i+1]=0
		}else if i+1<len{
			dp[i][i+1]=1
		}
	}

	for i:=2;i<len;i++{
		for j:=0;i+j<len;j++{
			min:= math.MaxInt32
			fmt.Println("for string ======== > i+j "+strconv.Itoa(i+j)+" j "+strconv.Itoa(j)+" "+str[j:i+j+1] )
			fmt.Println()
			for k:=j;k<i+j;k++{
				fmt.Print(" str portion "+str[j:k+1]+" to "+str[k+1:i+j+1]+" min ")
				
				 min=int(math.Min(float64(min),float64(1+dp[j][k]+dp[k+1][i+j])))
				fmt.Println(min)
			}
			if str[j]==str[i+j]{
				min--
			}
			dp[j][i+j]=min
		}
	}
	fmt.Println(dp[0][len-1]+1)
}