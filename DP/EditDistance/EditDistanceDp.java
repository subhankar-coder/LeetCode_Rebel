package EditDistance;

import java.util.Arrays;

public class EditDistanceDp {

    public static void main(String[] args) {
        String str1="horse";
        String str2="ros";
        int m=str1.length();
        int n = str2.length();
        int [][] board=new int [m+1][n+1];
        for(int [] arr:board){
            Arrays.fill(arr, -1);
        }
        System.out.println(getMinConversion(board,str1, str2, m, n));
    }

    private static int getMinConversion(int [][] board,String str1, String str2, int m, int n) {
        
        if(m==0)
            return n;
        if(n==0)
            return m;

        if(board[m][n]!=-1)
            return board[m][n];

        if(str1.charAt(m-1)==str2.charAt(n-1)){
            return board[m][n]=getMinConversion(board, str1, str2, m-1, n-1);
            
        }
        else{
            return board[m][n]= 1+Math.min(Math.min(
            
            //remove an ele 
            getMinConversion(board,str1, str2, m-1, n), 
            //replace an element 
            getMinConversion(board,str1, str2, m-1, n-1)),
            
            //add an ele 
            getMinConversion(board,str1, str2, m, n-1)
            );

            
        }

    }
    
    
}
