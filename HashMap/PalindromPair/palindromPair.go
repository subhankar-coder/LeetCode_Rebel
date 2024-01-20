package main

import "fmt"

func main(){
	var words=[]string{"ab","ba","abc","cba"}
	var reverseMap map[string]int = creatReverseMap(words)
	fmt.Println(reverseMap)
	for i,word:= range words{
		j,ok:=reverseMap[word]
		if ok && i!=j{
			fmt.Println(i,j)
		}
		length:=len(word)
		for key,element:= range reverseMap{
			if len(key)>length {
				if key[:length]==word && isPalindrom(key[length:]){

					fmt.Println(i,element)
				}
					if key[len(key)-length:]==word && isPalindrom(key[:len(key)-length]){
					fmt.Println(element,i)
				}
			}
		}
		
	}
	 
}
func creatReverseMap(words []string) map[string]int{
	len:=len(words)
	reverseMap:=make(map[string]int)
	for i:=0;i<len;i++{
		reverseMap[reverseString(words[i])]=i
	}
	return reverseMap
}
func isPalindrom(s string)bool{
	len :=len(s)
	if len==0 ||len==1{
		return true
	}
	for i,j:=0,len-1;i<=j;i,j=i+1,j-1{
		if s[i]!=s[j]{
			return false
		}
	}
	return true
}
func reverseString(word string)string{
	var len=len(word)
	wordArray:= []rune(word)
	for i,j:=0,len-1;i<j;i,j=i+1,j-1{
		wordArray[i],wordArray[j]=wordArray[j],wordArray[i]
	}
	return string(wordArray)
}