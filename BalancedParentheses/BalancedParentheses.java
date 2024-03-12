package BalancedParentheses;

import java.util.*;

public class BalancedParentheses{
	public static void main(String[] args) {
		
		int n=1;
		
		generateParentheses(n,0,0,"");
		
	}
	public static void generateParentheses(int n ,int left,int right,String res){
		
		if(right>left)
			return;
		if(left<n){
		
			generateParentheses(n,left+1,right,res+"(");
		}
		
		if(right<n){
			generateParentheses(n,left,right+1,res+")"); 
		}
		
		if(right==n && left==n){
			System.out.println(res);
			
			
		}
		
	}
}
