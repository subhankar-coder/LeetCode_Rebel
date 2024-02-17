package main;

import (
	"fmt"
	"math"
)

func main(){
	
	str :="bbbab"
	n := len(str)

	dp := make([][]int,n);

	var maxLen int = 1;

	 for i:=0 ;i<n;i++{
	 	dp[i]=make([]int ,n)
	 }

	 for i:=0;i<n;i++{
	 	dp[i][i]=1;
	 	if i+1<n && str[i]==str[i+1]{
	 		dp[i][i+1]=2
	 		maxLen=2;
	 	}else if i+1<n{
	 		dp[i][i+1]=1
	 	}
	 }

	 for k:=2;k<n;k++{
	 	for i:=0;i+k<n;i++{
	 		max:=1
	 		for j:=i;j<i+k;j++{
	 			if str[i+k]==str[j]{
	 				max =  int(math.Max(float64(max),float64(dp[j+1][i+k-1]+2)))
	 			}else{
	 				max=int(math.Max(float64(max),float64(dp[i][j])))
	 			}
	 		}
	 		dp[i][i+k]=max;
	 		maxLen=int(math.Max(float64(maxLen),float64(max)))
	 	}
	 }
	 


	 fmt.Println(maxLen)
	 fmt.Println(dp)
}

