package DP.InterleavingString;

import java.util.Arrays;

public class InterleavingString {

    public static void main(String[] args) {
        String s1="aabcc";
        String s2= "dbbca";
        String s3="aadbbcbcac";

        int m=s2.length();
        int n=s1.length();

        int [][] graph = new int[m+1][n+1];
        graph[0][0]=1;
        int r=0;
        int c=0;
        int index=-1;
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n ;j++){
                if(graph[i][j]==0){
                    if(i==0){
                        if(s3.charAt(i+j-1)==s1.charAt(j-1) && graph[i][j-1]==1)
                            graph[i][j]=1;
                    }else if(j==0 ){
                        if(s3.charAt(i+j-1)==s2.charAt(i-1) && graph[i-1][j]==1)
                            graph[i][j]=1;
                    }else{
                        if((graph[i-1][j]==1 && s2.charAt(i-1)==s3.charAt(i+j-1)) || (graph[i][j-1]==1 && s1.charAt(j-1)==s3.charAt(i+j-1))){
                            graph[i][j]=1;
                        }
                    }
                }
                
            }
        }
        for(int [] arr:graph){
                    System.out.println(Arrays.toString(arr));
                }
    }
    
}
