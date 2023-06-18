package main

import (
	"sort"
	"fmt"
)

func main(){

	str  := []string{"eat","tea"}
	result := [][]string{}
	if len(str)==0{
		fmt.Println(result)
	}
	
	m:= make(map[string][]string)
	for val:= range str{
		_,ok:= m[sortString(str[val])]
		if !ok{
			m[sortString(str[val])]=[]string{str[val]}
		}else {
			array:=m[sortString(str[val])]
			array=append(array,str[val])
			m[sortString(str[val])]=array
		}
	}
	for _,val:= range m{
		result=append(result,val)
	}
	fmt.Println(result)
}
func sortString(str string)string{

	charArray:= []rune(str)
	sort.Slice(charArray,func(i,j int) bool{
		return charArray[i]<charArray[j]
	})
	return string(charArray)
}
