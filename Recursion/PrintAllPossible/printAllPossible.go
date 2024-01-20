package main
import "fmt"

func main(){
	var dict = []string{"a","b"}
	var k = 3
	printAllPossible(k,dict,"")

}
func printAllPossible(k int,dict []string,res string){
	if k==0{
		fmt.Println(res[:])
		return 
	}
	for _,val:= range dict{
		printAllPossible(k-1,dict,res+val)
	}
}