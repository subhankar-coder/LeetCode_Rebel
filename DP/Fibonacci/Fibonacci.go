package main
import "fmt"
func main(){
	var n = 5
	dp:= make([]int,n+1)
	for i:= range dp{
		dp[i]=-1
	}
	dp[0]=0
	dp[1]=1
	fmt.Println(fibonacci(n,dp))
}
func fibonacci(n int,dp [] int)int{
	if dp[n]!=-1{
		return dp[n]
	}else{
		dp[n]=fibonacci(n-1,dp)+fibonacci(n-2,dp)
	}
	return dp[n]
}
