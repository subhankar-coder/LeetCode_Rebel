/*
 *  
 *  This is a typical problem of recursion,  if we see a character " + , - , *, / " 
 *  We will divide the the string into two halves , left and right , and will recursively do the same until we reach a single or double 
 *  digit number , then we can perform the operation and save the results to a array , like that we can solve the right half and left half
 *  by divide and conqure method, then based on the opeand charecter we can do the operation and save the result to an array res
 *  return it, and like that we can solve the right and left halves recursively and solve the problem
 * 
 *  we can also use a memorization to store the overlapping value
 * 
 */


package DP.DifferrentWayToPutParentheses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DifferentWaysToAddParentheses {
  static int N;
  static HashMap<String,List<Integer>> map;
    public static void main(String[] args) {
         String expression = "2*3-4*5";
         int len = expression.length();
         N=len;
         map=new HashMap<>();
         System.out.println((solve(expression)));
    }
    public static List<Integer> solve(String expression){
       int n = expression.length();

       if(map.containsKey(expression))
            return map.get(expression);
       List<Integer> res=new ArrayList<>();
       if(n==1)
            return Arrays.asList(Integer.valueOf(expression.substring(0,1)));
        if(n==2){
            int ascii = (int)expression.charAt(0);
            if(ascii>=48 && ascii<=57){
                return Arrays.asList(Integer.valueOf(expression.substring(0, 2)));
            }
        }
        for(int i=n-1;i>=0;i--){
            if(expression.charAt(i)=='*' || expression.charAt(i)=='+' || expression.charAt(i)=='-' || expression.charAt(i)=='/')
                continue;
            if(i!=0 && (expression.charAt(i-1)=='*' || expression.charAt(i-1)=='+' || expression.charAt(i-1)=='-' || expression.charAt(i-1)=='/')){
                List<Integer> left = solve(expression.substring(0, i-1));
                List<Integer> right = solve(expression.substring(i, n));
                for(int l:left){
                    for(int r:right){
                        res.add(operation(l,r, expression.substring(i-1, i)));
                    }
                }
            }

        }
        map.put(expression,res);
        return res;
    }
    public static int operation(int num1,int num2 , String  operands){

        
        switch (operands) {
            case "+":
                return num1+num2;
            case "-":
                return num1-num2;
            case  "/":
               return num1/num2;
            case "*":
                return num1*num2;
            default:
                return 0;
        }
    }
    
}
