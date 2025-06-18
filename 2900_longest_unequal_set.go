package main

func getLongestSubsequence(words []string, groups []int) []string {

    res := []string{words[0]}
    alt_ele := groups[0]
    for  i:=1;i<len(groups);i++{
        ele := groups[i]
        if ele != alt_ele{
            res=append(res,words[i])
            alt_ele = ele
        }
    }
    return res   
}