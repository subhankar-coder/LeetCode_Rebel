package main

func main() {
	dictionary := []string{"dogs", "cats", "sand", "and", "cat"}
	var s = "catsanddogs"
	wordBreak2(len(s), s, dictionary, "")

}
func wordBreak2(n int, s string, dictionary []string, ans string) {

	for i := 1; i <= n; i++ {
		if dictionaryContains(s[:i], dictionary) {
			if i == n {
				ans += s[:i]
				println(ans)
			}
			wordBreak2(n-i, s[i:], dictionary, ans+s[:i]+" ")
		}

	}

}
func dictionaryContains(s string, dictionary []string) bool {
	for _, word := range dictionary {
		if word == s {
			return true
		}
	}
	return false
}
