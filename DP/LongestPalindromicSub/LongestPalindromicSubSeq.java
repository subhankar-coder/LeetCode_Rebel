package DP.LongestPalindromicSub;

import java.util.Arrays;

public class LongestPalindromicSubSeq{
    public static void main(String[] args) {
        String str = "babad";
        int n=str.length();
        int [][] graph = new int[n][n];
        String maxString =String.valueOf(str.charAt(0));
        int maxLen=1;

        //for substr of len 1
        for(int i=0;i<n;i++){
            graph[i][i]=1;
        }

        //for substr of len 2

        for(int i=0;i<n-1;i++){
            if(str.charAt(i)==str.charAt(i+1)){
                maxLen=2;
                maxString=str.substring(i, i+2);
                graph[i][i+1]=1;
            }
        }

        for(int j=2;j<n;j++){
            for(int i=0;j-i>=2;i++){
                if(str.charAt(i)==str.charAt(j) && graph[i+1][j-1]==1){
                    if((j-i)+1>maxLen){
                        maxLen=(j-i)+1;
                        maxString=str.substring(i, j+1);
                    }
                    graph[i][j]=1;
                }
            }
        }
        System.out.println(maxString);
        //print the graph
        for (int [] arr:graph){
            System.out.println(Arrays.toString(arr));
        }
    }
}