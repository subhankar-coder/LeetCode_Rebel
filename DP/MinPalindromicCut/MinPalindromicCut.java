package DP.MinPalindromicCut;

public class MinPalindromicCut {
    public static void main(String[] args) throws Exception {
        String str = "ababbbabbababa";
        int n = str.length();

        int [][]cost = new int [n][n];

        int [][] min = new int [n][n];

        for(int i=0;i<n;i++)
            cost[i][i]=1;

        for(int i=0;i<n-1;i++){
            if(isPalindrom(str, i, i+1)){
                cost[i][i+1]=1;
                min[i][i+1]=i+1;
            }else{
                cost[i][i+1]=2;
                min[i][i+1]=i;
            }
        }
        
        for(int j=2;j<n;j++){
            for(int i=0;i+j<n;i++){

              if(isPalindrom(str, i, i+j)){
                cost[i][i+j]=1;
                min[i][i+j]=i+j;
              }else{
                int minValue = Integer.MAX_VALUE;
                for(int k=i;k<i+j;k++){
                    if(minValue > cost[i][k]+cost[k+1][i+j]){
                        minValue=cost[i][k]+cost[k+1][i+j];
                        min[i][i+j]=k;
                    }
                }
                cost[i][i+j]=minValue;
              }

            }
        }

        System.out.println(cost[0][n-1]);
    }

    public static boolean isPalindrom(String str,int start,int end) throws Exception{
        if(end>=str.length())
            throw new Exception("ex");
        if(start>=end)
            return true;

        if(str.charAt(start)!=str.charAt(end))
            return false;
        
        if(isPalindrom(str, start+1, end-1))
            return true;

        return false;
    }
}
