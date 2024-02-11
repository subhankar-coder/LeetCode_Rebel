package DP.BurstBallons;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BurstBallons {

     public static void main(String[] args) {
        
        int [] array = {4,3,2,6};
        int n = array.length;
        // List<Integer> list = Stream.concat(Stream.concat(Stream.of(1), Arrays.stream(array).boxed()),Stream.of(1)).mapToInt(i->i).boxed().collect(Collectors.toList());
        // System.out.println(list);
        solve(array);
     }
     public static void solve(int [] array){

        int n = array.length;
        int [][] cost = new int [n+1][n+1];
        int [][] minCut = new int[n+1][n+1];

        int [] arrayCp = new int[n+2];
        System.arraycopy(array, 0, arrayCp, 1, n);
        arrayCp[0]=1;
        arrayCp[n+1]=1;
        for(int i=1;i<=n;i++){
            cost[i-1][i]= arrayCp[i-1]*arrayCp[i]*arrayCp[i+1];
        }

        for(int i=2;i<=n+1;i++){
            for(int j=0;i+j<=n;j++){
                int max=Integer.MIN_VALUE;
                for(int k=j;k<i+j;k++){
                    max=Math.max(max, cost[j][k]+cost[k+1][i+j]+arrayCp[j]*arrayCp[k+1]*arrayCp[i+j+1]);
                }
            cost[j][j+i]=max;
            }
        }
        for(int [] arr: cost){
            System.out.println(Arrays.toString(arr));
        }
     }
}