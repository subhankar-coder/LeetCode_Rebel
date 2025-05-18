package main

import(
	"fmt"
)

const mod int = 1_000_000_007
func main()  {
	var n int =30
	fmt.Println(numTilings(n))
}
func numTilings(n int)int  {
	var dp []int = []int{1,1,2,5}
	for i:=4;i<=n;i++{
		fmt.Println(i)
		next := (2*dp[i-1]+dp[i-3])%mod
		fmt.Println(next)
		dp = append(dp,next)
		fmt.Println(dp)

	}

	// fmt.Println(dp)
	return dp[n]
}
