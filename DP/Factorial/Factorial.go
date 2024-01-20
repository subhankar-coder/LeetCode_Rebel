package main
import "fmt"

func main(){
	var n=5
	dp:=make([]int,n+1)
	for i:= range dp{
		if i<2{
		  dp[i]=i
		}else{
		  dp[i]=-1
		}
	}
	fmt.Println(factorial(n,dp))

}
func factorial(n int,dp []int)int{
	if dp[n]!=-1{
		return dp[n]
	}else{
		dp[n]=n*factorial(n-1,dp)
		return dp[n]
	}

}
