package DP.PerfectSquare;

import java.util.Arrays;

public class PerfectSquare {
 
    static int min;
    static int dp[];
    public static void main(String[] args) {

        int nums=1000;
        min=Integer.MAX_VALUE;
        if(nums<=1)
            return ;
        int key = (int)Math.sqrt(nums);
        solve(nums,key,0);
        
        System.out.println( min);
    }
    public static void solve(int nums ,int key,int count){
        if(count>=min)
            return;
        if(nums==0){
            min=Math.min(min,count);
            return ;
        }
        for(int i=key;i>=1;i--){
            if(Math.pow(i,2)<=nums){
                solve(nums-(int)Math.pow(i,2),(int)(Math.sqrt(nums-(int)Math.pow(i,2))),count+1);

            }
        }  
    }
    
}
