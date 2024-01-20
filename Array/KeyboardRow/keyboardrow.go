package main
import (
	"fmt"
	"strings"
)

func main(){
	var firstRow=[]rune("qwertyuiop")
	var secondrow=[]rune("asdfghjkl")
	var thirdRow=[]rune("zxcvbnm")
	var row1= make(map[rune]bool)
	var row2= make(map[rune]bool)
	var row3= make(map[rune]bool)
	for _,char:=range firstRow{
		row1[char]=true
	}
	for _,char:=range secondrow{
		row2[char]=true
	}
	for _,char:=range thirdRow{
		row3[char]=true
	}
	var words = []string{"adsdf","sfd"}
	fmt.Println(firstRow,secondrow,thirdRow)
	for _,word:= range words{
		
		lowerWord:=removeDuplicate(strings.ToLower(word))
		lowerWordsRune:=[]rune(lowerWord)
		if row1[lowerWordsRune[0]]{
			flag:=0
			for _,char:= range lowerWordsRune{
				if !row1[char]{
					flag=1
					break
				}
			}
			if flag==0{
				fmt.Println(word)
			}
			
		}else if row2[lowerWordsRune[0]]{
			flag:=0
			for _,char:= range lowerWordsRune{
				if !row2[char]{
					flag=1
					break
				}
			}
			if flag==0{
				fmt.Println(word)
			}
		}else{
			flag:=0
			for _,char:= range lowerWordsRune{
				if !row3[char]{
					flag=1
					break
				}
			}
			if flag==0{
				fmt.Println(word)
			}
		}
		
	}
}
func removeDuplicate(s string)string{
	chars:= []rune(s)
	var result = []rune{chars[0]}
	var last rune=chars[0]
	for _,char:= range chars{
		if char!=last{
			result=append(result,char)
			last=char
		}
	}
	return string(result)
}