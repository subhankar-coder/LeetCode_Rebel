package main

func maxAdjacentDistance(nums []int) int {
    n := len(nums)
    res := 0
    for i:=0;i<n;i++{
        res = max(res,abs(nums[i],nums[(i+1)%n]) )
    }   
    return res
}

func abs(a,b int)int{
    if a <b{
        return b-a
    }
    return a-b
}

func max(a,b int) int{
    if a <b{
        return b
    }
    return a
}