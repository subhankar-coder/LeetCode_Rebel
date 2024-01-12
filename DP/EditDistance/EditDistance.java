package DP.EditDistance;

public class EditDistance {

    public static void main(String[] args) {
        String str1="horse";
        String str2="ros";
        int m=str1.length();
        int n = str2.length();
        System.out.println(getMinConversion(str1, str2, m, n));
    }
    public static int getMinConversion(String str1,String str2,int m,int n){

        //if first string ele are done looping then return the left over of n element (add them)
        if(m==0){
            return n;
        }

        //else if all the elements of the second string are done looping then return the left over of the second string (remove them )
        if(n==0){
            return m;
        }

        // if the last char of both the string matches 
        if(str1.charAt(m-1)==str2.charAt(n-1)){
            return getMinConversion(str1, str2, m-1, n-1);
        }else{
            return 1+Math.min(Math.min(
            
            //remove an ele 
            getMinConversion(str1, str2, m-1, n), 
            //replace an element 
            getMinConversion(str1, str2, m-1, n-1)),
            
            //add an ele 
            getMinConversion(str1, str2, m, n-1)
            );
        }
    }
    
    
}
