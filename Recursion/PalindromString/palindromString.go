package main

import "fmt"

func main(){
	var str="geeks"
	createPalindromstring(str,0,"")
}
func createPalindromstring(str string,index int,out string){
	if index==len(str){
		fmt.Println(out)
	}
	for i:=index;i<len(str);i++{
		if isPalindrom(str[index:i+1]){
			createPalindromstring(str,i+1,out+" "+str[index:i+1])
		}
	}
}
func isPalindrom(str string)bool{
	if len(str)<2{
		return true
	}
	for i,j:=0,len(str)-1;i<=j;i,j=i+1,j-1{
		if str[i]!=str[j]{
			return false
		}

	}
	return true
}
