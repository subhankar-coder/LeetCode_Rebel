package DP.LargestDivisableSubset;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LargestDivisableSubset {
    static Map<Integer,List<Integer>> map;
    public static void main(String[] args) {
        int [] nums = {3,4,16,8};
        map = new HashMap<>();
        Arrays.sort(nums);
        List<Integer> res=new ArrayList<>();
       
        for(int i=0;i<nums.length;i++){
            List<Integer> dup = solve(nums, i, nums.length);
            if( dup.size()>res.size()){
                res=dup;
            }
        }
        
        System.out.println(res);
    }
    public static List<Integer> solve(int [] nums, int index,int n ){
        if(map.containsKey(index))  
            return map.get(index);
        if(index>=n-1)
            return Arrays.asList(nums[n-1]);
        List<Integer> max = new ArrayList<>(Arrays.asList(nums[index]));
            for(int i=index+1;i<n;i++){
                if(nums[i]%nums[index]==0){
                    List<Integer> res = new ArrayList<>(Arrays.asList(nums[index]));
                    res= Stream.concat(res.stream(), solve(nums, i, n).stream()).collect(Collectors.toList());

                if(res.size()>max.size()){
                    max=res;
                }
            }
        }
        map.put(index,max);
        return max;
    }
    
}
