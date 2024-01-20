package DP.MaxSquareSubMatrix;

public class MaxSquareSubMatrix {

    public static void main(String[] args) {
        // String [][] matrix={{"1","0","1","0","0"},{"1","0","1","1","1"},{"1","1","1","1","1"},{"1","0","0","1","0"}};
        String [][] matrix={{"0","1"},{"0","1"}};
        int m=matrix.length;
        int n=matrix[0].length;
        int max=Integer.MIN_VALUE;
        int [][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            if(matrix[i][0]=="1"){
                max=1;
                dp[i][0]=1;
            }
        }
        for(int i=0;i<n;i++){
            if(matrix[0][i]=="1"){
                max=1;
                dp[0][i]=1;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]!="0"){
                    dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                    max=Math.max(max, dp[i][j]);
                }
            }
        }

        System.out.println(max);
    }
    
}
