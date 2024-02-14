package DP.PredictWinner;

import java.util.Arrays;

public class PredictWinner {
    public static void main(String[] args) {
        int [] nums = {1,5,233,7};
        int sum = Arrays.stream(nums).boxed().mapToInt(i->i).sum();
        
        System.out.println(solve(nums, 0, nums.length-1));
    }   
    public static int solve(int [] nums,int i,int j){
        
        if(i>j)
            return 0;
        if(i==j)
            return nums[i];
        
        int sum = Math.max(nums[i]+Math.min(solve(nums, i+2, j),solve(nums, i+1, j-1)),
         nums[j]+Math.min(solve(nums, i, j-2),solve(nums, i+1, j-1)));
        
        return sum;
    } 
}
