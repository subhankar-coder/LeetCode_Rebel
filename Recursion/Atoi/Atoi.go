package main
import (
	"fmt"
	//"math"
	//"strconv"
)
func main() {
	var str="123G"
	var n = len(str)
	//var r= []rune(str)
	recursiveAtoi(str,n,0,1)
}
func recursiveAtoi(str string ,n int,res int,index int){
	if n==0{
		fmt.Println(res)
		return
	}
	if (rune(str[n-1])>=97 && rune(str[n-1])<=122) || (rune(str[n-1])>=65 && rune(str[n-1])<=90){
		fmt.Println(0)
		return
	}

	recursiveAtoi(str,n-1,res+int(rune(str[n-1])-48)*index,index*10)
}