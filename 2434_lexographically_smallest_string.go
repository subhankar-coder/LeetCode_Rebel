package main

import(
	"fmt"
	// "math"
)


func main(){
	s := "bzeyxf"
	fmt.Println(robotWithString(s))
}

func robotWithString(s string) string {
	cnt := make([]int,26)
	for _,c := range s{
		cnt[c-'a']++
	}
	st := []rune{}
	str :=""
	lastMin := 'a'
	for _,c := range s{
		cnt[c-'a']--
		st = append(st,c)
		for lastMin != 'z' && cnt[lastMin-'a']==0{
			lastMin++
		}
		for len(st) >0 && lastMin >= st[len(st)-1]{
			str += string(st[len(st)-1])
			st = st[:len(st)-1]
		}
	}
	return str
}
