package DP.LongestValidParentheses;

import java.util.Stack;

public class LongestValidParentheses{
    public static void main(String ... args){
        
        String s = ")()())()()(";
        Stack<Integer> stk = new Stack<Integer>();
        int n=s.length();
        stk.add(-1);
        int result = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                stk.push(i);
            }else{
                if(!stk.isEmpty()){
                    stk.pop();
                }
                if(!stk.isEmpty()){
                    result=Math.max(result, i-stk.peek());
                }else{
                    stk.add(i);
                }
            }
        }
        System.out.println(result);
    }
}