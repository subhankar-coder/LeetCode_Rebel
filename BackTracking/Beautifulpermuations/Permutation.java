package BackTracking.Permutation;

import java.util.*;
import java.util.stream.Collectors;

public class Permutation{
    static List<List<Integer>> result=new ArrayList<>();
    public static void main(String[] args) {
        int [] arr={1,2,3};
        doPermutation(arr, 0, arr.length-1);
        System.out.println(result);
    }
    public static void doPermutation(int [] arr,int start,int end){
        if (start==end){
           result.add((Arrays.stream(arr).boxed().collect(Collectors.toList())));
            return;
        }
        for(int i=start;i<=end;i++){
            swap(arr, i, start);
            doPermutation(arr, start+1, end);
            swap(arr, i, start);
        }

    }
    public static void swap(int [] arr,int a,int b){
        int temp=arr[b];
        arr[b]=arr[a];
        arr[a]=temp;
    }
}