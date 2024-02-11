package DP.RotateFunction;

public class RotateFunction {
    public static void main(String[] args) {
        int [] nums = {100};
        int n = nums.length;
        int [][] dp = new int [n][n];
        int max = Integer.MIN_VALUE;
        for(int j=n-1;j>=0;j--){
            int sum=0;
            for(int i=0;i<n;i++){
                if(i<j){
                    sum+=nums[i]*((n-1-j )+i+ 1);
                }else{
                    sum+= nums[i]*(i-j);
                }
            }
            max=Math.max(max, sum);
         }
         System.out.println(max);
    }
}
