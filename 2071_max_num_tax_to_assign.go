package main

import(
	"fmt"
	"sort"
	"container/list"
)

func main(){

	tasks := []int {3,4}
	workers := []int {1,5}
	pills := 1
	strength := 2
	maxTaskAssign(tasks,workers,pills,strength)
}

func maxTaskAssign(tasks []int, workers []int, pills int, strength int) int {
 	  	sort.Ints(tasks)
		sort.Slice(workers,func(a,b int)bool{
			return workers[a]>workers[b]
		})
		var result int =-1
		max_k := min(len(tasks),len(workers))
		// fmt.Println:(isAssignable(tasks,workers,pills,strength,6,max_k))
		low,mid,high := 0,0,max_k

		for low <= high{
			mid = low +(high-low)/2
			var canAssign bool = isAssignableDeque(tasks , workers, pills, strength, mid)
			fmt.Println(canAssign)
			if canAssign{
				result = mid
				fmt.Println("result",result)
				low = mid+1
			}else{
				high = mid-1
			}
			fmt.Println("workers",workers)
		}
		fmt.Println("res",result)
		return result

}

func isAssignableDeque(tasks [] int , workers [] int, pills int, strength int, k int)bool{
	deque := list.New()
	workers_len := len(workers)
	for i:= workers_len-k; i<workers_len ;i++{
		deque.PushBack(workers[i])
	}
	for i := k-1;i>=0;i--{
		t := tasks[i]
		if deque.Len() > 0 && deque.Back().Value.(int) >=t{
			deque.Remove(deque.Back())
		}else if pills >0 && deque.Len() > 0 && deque.Front().Value.(int)+strength >= t{
			deque.Remove(deque.Front())
			pills--
		}else{
			return false
		}
	}
	return true
}


func isAssignable(tasks [] int , workers [] int , pills int, strength int, k int)bool{

	fmt.Println("k val",k)
	var lb int = -1
	var max_k int =0
	temp := workers[len(workers)-(k+1):]
	fmt.Println("temp",temp)
	for i:=0;i<=k;i++{
			lb = lowerBound(temp,tasks[i])
			fmt.Println("lower bound",lb)
			fmt.Println("element ", tasks[i])
			max_k = len(temp)
			if lb < max_k{
				if lb!=0 &&  pills >0  &&  strength+temp[lb-1] >= tasks[i] && strength+temp[lb-1]-tasks[i] <= temp[lb]-tasks[i]{
					  // if strength+temp[lb-1] >= tasks[i] && strength+temp[lb-1]-tasks[i] < temp[lb]-tasks[i]{
						var smallestLb int = lb-1
						for smallestLb>=0 &&  strength+temp[smallestLb] >= tasks[i]{
							smallestLb--
						}
						// fmt.Println("smallest",smallestLb)
						smallestLb++
						temp = append(temp[:smallestLb],temp[smallestLb+1:]...) 
						pills--
				}else{
					temp = append(temp[:lb],temp[lb+1:]...)
				}
			}else{
				if pills>0 && temp[max_k-1]+strength >= tasks[i]{
						temp = temp[:len(temp)-1]
						pills--
				}else{
					return false
				}
			}
		fmt.Println("temp array ", temp)
	}
	return true
}


func lowerBound(array []int,target int)int {
	low,high :=0,len(array)
	for low < high{
		mid := low +(high-low)/2
		if array[mid]< target{
			low = mid+1
		}else{
			high = mid
		}
	}
	return low
}

func min(a, b int)int{
	if a<b{
		return a
	}
	return b
}
