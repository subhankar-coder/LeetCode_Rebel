package main

func main() {
	wordDirectory := []string{"cats", "and", "dogs", "cat"}
	var s = "catsanddogs"
	println(wordBreak2(s, wordDirectory))

}
func wordBreak(word string, dictionary []string) bool {
	var len = len(word)
	if len == 0 {
		return true
	}
	array := make([]int32, len+1)
	for i := 1; i <= len; i++ {
		if array[i] == 0 && dictionaryContains(word[:i], dictionary) {
			array[i] = 1
		}
		if array[i] == 1 {
			if i == len {
				return true
			}
			for j := i + 1; j <= len; j++ {
				if array[j] == 0 && dictionaryContains(word[i:j], dictionary) {
					array[j] = 1
				}
				if j == len && array[j] == 1 {
					return true
				}
			}
		}
	}
	return false
}
func wordBreak2(word string, dictionary []string) int32 {
	var len = len(word)
	if len == 0 {
		return 1
	}
	dp := make([]int32, len+1)
	dp[0] = 1

	for i := 0; i <= len; i++ {
		for j := 0; j < i; j++ {
			if dp[j] == 1 && dictionaryContains(word[j:i], dictionary) {
				dp[i] = 1
				break
			}
		}
	}
	return dp[len]
}

func dictionaryContains(word string, dictionary []string) bool {

	for _, val := range dictionary {
		if val == word {
			return true
		}
	}
	return false
}
