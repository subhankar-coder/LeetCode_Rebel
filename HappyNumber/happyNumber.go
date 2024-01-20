package main

import (
	"fmt"
	"math"
)

func main() {
	var n int = 2

	mp := make(map[int]bool)

	mp[n] = true
	fmt.Println(makeSquareSum(n, mp))

}

func makeSquareSum(n int, mp map[int]bool) bool {

	if n == 1 {
		return true
	}
	var seed int = 10
	var sum int = 0

	for n > 0 {

		var mod float64 = float64(n % seed)
		sum += int(math.Pow(mod, 2))
		n = n / seed
	}
	_, ok := mp[sum]

	if ok {
		return false
	} else {
		mp[sum] = true
		return makeSquareSum(sum, mp)
	}
}
