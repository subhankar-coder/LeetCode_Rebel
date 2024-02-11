package DP.LongestArithmaticSubSeq;

import java.util.*;
public class LongestArithmaticSubSeq {
    public static void main(String[] args) {
         int [] nums = {83,20,17,43,52,78,68,45};
         int n = nums.length;
         solve(nums, n);
    }
    public static void solve(int []nums ,int n){

        
           Map<Integer,Integer> [] map = new HashMap[n];
            int max = 1;
            map[0]= new HashMap<>();
           for(int i=1;i<n;i++){
            map[i]=new HashMap<>();
            for(int j=0;j<i;j++){
                int diff = nums[i]-nums[j];
                
                if(map[j].containsKey(diff)){
                    max=Math.max(max, map[j].get(diff)+1);
                    map[i].put(diff, map[j].get(diff)+1);
                }
                else{
                    max=Math.max(max, 2);
                    map[i].put(diff,2 );
                }
                
            }

           }
        
           System.out.println(max);
    }
}
