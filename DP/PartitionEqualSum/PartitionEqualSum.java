package DP.PartitionEqualSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PartitionEqualSum {
    static Map<String,Boolean> map;
    public static void main(String[] args) {
         int [] nums = {1,5,11,5};
         int n = nums.length;
         int sum = Arrays.stream(nums).boxed().mapToInt(i->i).sum();
         if(sum%2!=0)
         return;
         int target = sum/2;
        
        
        boolean [][] dp = new boolean [n+1][target+1];
        
        for(int i=0;i<=n;i++)
            dp[i][0]=true;
        

        for(int i=1;i<=n;i++){
                for(int j=1;j<=target;j++){
                    if(j<nums[i-1]){
                        dp[i][j]=dp[i-1][j];
                    }else{
                        dp[i][j]= dp[i-1][j] || dp[i-1][j-nums[i-1]];
                    }
                }
        }
        
        for(boolean [] arr: dp)
            System.out.println(Arrays.toString(arr));
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //  map=new HashMap<>();
        // System.out.println(solve(nums, n, target, 0));
    }
    public static boolean solve(int [] nums ,int n,int target,int start){
       String key = start+" "+target;
       
        if(start>=n)
            return false;
        if(target<nums[start])
            return false;
        if(target==nums[start] || target==0)
            return true;
        
        if(map.containsKey(key))
            return map.get(key);
        for(int i=start+1;i<n;i++){
            if(solve(nums, n, target-nums[start], i)){
                map.put(key,true);
                return true;
            }
        }
        map.put(key,false);
        return false;
        
    }
    
}
