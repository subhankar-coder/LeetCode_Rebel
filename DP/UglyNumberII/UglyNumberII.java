package DP.UglyNumberII;

import java.util.*;

public class UglyNumberII {

    public static void main(String[] args) {
        int n =10;
        // if(n<=5)
        //     System.out.println(n);
        // List<Integer> ans = new ArrayList<>();
        // for(int i=1;i<=5;i++){
        //     ans.add(i);
        // }
        // List<Integer> dict = Arrays.asList(2,3,5);
        
        // for(  int i=5;i<n;i++){
        //     int min = Integer.MAX_VALUE;

        //     for(int j=0;j<i;j++){
        //         for(int factor : dict){
        //             if(Long.valueOf(ans.get(j)*factor) >Long.valueOf(ans.get(i-1))){
        //                 min=(int)Math.min(Long.valueOf(min),Long.valueOf(ans.get(j)*factor));
        //             }
        //         }
        //     }
        //     ans.add(min);
      System.out.println(uglyNumber(n));

        // System.out.println(ans);
    }
    public static int uglyNumber(int n){
        int [] dp = new int [n];
        dp[0]=1;
        int f2=2,f3=3,f5=5;

        int ind2=0,ind3=0,ind5=0;

        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(f2,f3),f5);
            dp[i]=min;
            if(min==f2){
                ind2++;
                f2=2*dp[ind2];
            }
            if(min==f3){
                ind3++;
                f3=3*dp[ind3];
            }
            if(min==f5){
                ind5++;
                f5=5*dp[ind5];
            }
        }
        return dp[n-1];
    }
    
}

// 2123366400-2147483647
