package DP.SplitArrayLargestSum;

import java.util.Arrays;

public class SplitArrayLargestSum {
    static int minSum;
    public static void main(String[] args) {
        
        int [] nums = {1,2,3,4};
        int k=3;
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int sum = Arrays.stream(nums).boxed().mapToInt(i->i).sum();

        System.out.println(binarySearch(nums, max, sum, k, n));
        
        // minSum=Integer.MAX_VALUE;
        // solve(nums, k, n, new int []{},Integer.MIN_VALUE);
        // System.out.println(minSum);
    }
    public static void solve(int [] nums,int k,int index,int [] subArray,int max){

        if(index<=0){
            return ;
        }
        // System.out.println(Arrays.toString(subArray));
        if(k==1){
           
            minSum= Math.min(minSum,Math.max(max,Arrays.stream(Arrays.copyOfRange(nums, 0, index)).sum()));
            // System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, index)));
            return;
        }


        for(int i=index-1;i>=0;i--){
            solve(nums, k-1, i, Arrays.copyOfRange(nums, i,index),Math.max(max,Arrays.stream(Arrays.copyOfRange(nums, i,index)).sum()));
        }
    }
    public static  int getMaxStudents(int [] nums,int maxValue,int n ){

        int count =1;
        int value =0;
        for(int i=0;i<n;i++){
            if(value+nums[i] <= maxValue){
                value+=nums[i];
            }else{
                value=nums[i];
                count++;
            }
        }
        return count;
    }
    public static int binarySearch(int [] nums,int start,int end,int k,int n){
        if(start>=end)
            return start;

        int mid = (start+end)/2;
        if(getMaxStudents(nums, mid, n)<=k){
            return binarySearch(nums, start, mid, k, n);
        }else{
            return binarySearch(nums, mid+1, end, k, n);
        }
        
    }

}
