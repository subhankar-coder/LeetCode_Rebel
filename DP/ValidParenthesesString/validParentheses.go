package main

import (

	"fmt"
	// "math"
	"strconv"
)
var mp map[string]bool
func main(){
	s:= "(((((*)))**"
	len := len(s)

	var stack [] rune = make([]rune,0)

	fmt.Println(solve(s,len,stack,0))
	
	 mp = make(map[string]bool)
	
	fmt.Println(solveCount(s,len,0,0))
	
}
func solve(s string,n int , stack []rune,index int) bool{

	fmt.Println(index,stack)
	
	// fmt.Println()
	if index==n {
		if len(stack)==0{
			return true
		}
		return false
	}
	fmt.Println(s[index])
	if s[index]==40{
		fmt.Println("ind ",index)
		if solve(s,n,append(stack,rune(s[index])),index+1){
			return true
		}
	}else if s[index]==41{
		fmt.Println("hrer ")
		if len(stack)==0{
			return false
		}else {
			if solve(s,n,stack[:len(stack)-1],index+1){
				return true
			}
		}
	}else{
		if solve(s,n,append(stack,rune('(')),index+1){
			return true
		}else if len(stack)>0 && solve(s,n,stack[:len(stack)-1],index+1){
			return true
		}else if solve(s,n,stack,index+1){
			return true
		}
	}
	return false
}

func solveCount (s string ,n int ,index int ,left int ) bool{

	if index==n {
		if left==0{
			return true
		}
		return false
	}

	if left<0{
		return false
	}

    key:= strconv.Itoa(index)+" "+strconv.Itoa(left)

    _,ok:= mp[key]
    if ok{
        return mp[key]
    }
	if s[index]==40{
		if solveCount(s,n,index+1,left+1){
			return true
		}
	}else if s[index]==41{
		if solveCount(s,n,index+1,left-1){
			return true
		}
	}else {
		if solveCount(s,n,index+1,left+1){
			return true
		}else if solveCount(s,n,index+1,left-1){
			return true
		}else if solveCount(s,n,index+1,left){
			return true
		}
	}
    mp[key]=false;
	return false
}