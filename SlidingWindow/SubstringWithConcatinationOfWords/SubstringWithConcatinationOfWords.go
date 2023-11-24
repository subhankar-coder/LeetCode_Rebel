package main

import "fmt"

// func main() {
// 	words := []string{"a"}
// 	str := "a"
// 	var res = make([]int, 0)
// 	wordLen := len(words[0])
// 	strLen := len(str)
// 	subLen := wordLen * len(words)
// 	var i = 0
// 	for i+subLen <= strLen {
// 		ok, _ := searchForEle(words, str[i:i+wordLen])
// 		if ok {
// 			temp := make([]string, len(words))
// 			copy(temp, words)
// 			if i+subLen <= strLen && isValid(str[i:i+subLen], temp, wordLen, subLen) {
// 				res = append(res, i)
// 				i += wordLen
// 				continue
// 			}

// 		}
// 		i++
// 	}
// 	fmt.Println(res)
// }
// func isValid(str string, words []string, wordLen int, pieceLen int) bool {

// 	for startIndex := 0; startIndex < pieceLen; startIndex += wordLen {
// 		ok, index := searchForEle(words, str[startIndex:startIndex+wordLen])
// 		if ok {
// 			words = append(words[:index], words[index+1:]...)
// 		} else {
// 			return false
// 		}
// 	}
// 	return true
// }
// func searchForEle(array []string, value string) (bool, int) {
// 	for i, val := range array {
// 		if val == value {

// 			return true, i
// 		}
// 	}
// 	return false, -1
// }

func main() {
	words := []string{"a"}
	str := "a"
	var res = make([]int, 0)
	wordLen := len(words[0])
	strLen := len(str)
	subLen := wordLen * len(words)
	var i = 0
	hashMap := make(map[string]int, len(words))

	for i := 0; i < len(words); i++ {
		_, ok := hashMap[words[i]]
		if ok {
			hashMap[words[i]] = hashMap[words[i]] + 1
		} else {
			hashMap[words[i]] = 1
		}
	}

	for i+subLen <= strLen {
		_, ok := hashMap[str[i:i+wordLen]]
		if ok {
			temp := copyMap(hashMap)

			if i+subLen <= strLen && isValid(str[i:i+subLen], words, wordLen, subLen, temp) {
				res = append(res, i)
				i += wordLen
				continue
			}

		}
		i++
	}
	fmt.Println(res)
}
func isValid(str string, words []string, wordLen int, pieceLen int, hashMap map[string]int) bool {
	for startIndex := 0; startIndex < pieceLen; startIndex += wordLen {
		_, ok := hashMap[str[startIndex:startIndex+wordLen]]
		if ok {
			if hashMap[str[startIndex:startIndex+wordLen]] == 0 {
				return false
			}
			hashMap[str[startIndex:startIndex+wordLen]] = hashMap[str[startIndex:startIndex+wordLen]] - 1
		} else {
			return false
		}
	}
	return true
}

func copyMap(hashMap map[string]int) map[string]int {
	tempMap := make(map[string]int, len(hashMap))
	for key, val := range hashMap {
		tempMap[key] = val
	}
	return tempMap
}
