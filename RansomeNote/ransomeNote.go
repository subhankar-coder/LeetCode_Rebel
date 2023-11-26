package main

import "fmt"

func main() {

	var ransomeNote string = "aa"
	var magazine string = "ab"

	ransomeNoteArray := []byte(ransomeNote)
	magazineArray := []byte(magazine)

	mp := make(map[byte]int)

	for _, val := range magazineArray {
		_, ok := mp[val]

		if ok {
			mp[val] = mp[val] + 1
		} else {
			mp[val] = 1
		}
	}

	for _, val := range ransomeNoteArray {

		_, ok := mp[val]

		if ok {
			mp[val] = mp[val] - 1
			if mp[val]==0{
				delete(mp,val)
			}

		} else {
			fmt.Println(false)
			break
		}
	}
	fmt.Println(true)
}
