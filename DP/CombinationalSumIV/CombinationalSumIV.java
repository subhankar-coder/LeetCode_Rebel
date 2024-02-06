package DP.CombinationalSumIV;

import java.util.Arrays;

public class CombinationalSumIV {
    // static int count;
    static long [] dp ;
    public static void main(String[] args) {
        int [] nums = {2,1,3};
        // Arrays.sort(nums);
        int target=35;
        int n=nums.length;
        dp = new long [target+1];
        Arrays.fill(dp, -1);
        System.out.println(solve(nums, n, target));
        // System.out.println(count);
    }
    public static long solve(int [] nums,int n,int target){   
        if(dp[target]!=-1)
            return dp[target];
        if(target==0){
                // System.out.println(str);
                // count++;
                return 1;           
            }
            int count=0;
            for(int i=0;i<n;i++){
                if(target-nums[i]>=0)
                    count+=solve(nums,n, target-nums[i]);
            }
            dp[target]=count;
            return count;
    }
}
