package ValidParentheses;

import java.util.*;

public class ValidParenthesis{

	static Map<String,Boolean> map;
	public static void main(String[] args) {
		map = new HashMap<>();
		String s ="(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
		System.out.println(checkIsValidStringUtil(s,0,0,s.length(),0));

	}
	public static boolean checkIsValidStringUtil(String s,int left ,int right,int len,int index){

		// System.out.println("index "+index+" left "+left+" right "+right);

		String key = left+" "+right+" "+index;

		if(map.containsKey(key))
				return map.get(key);
		if(index==len){
			if(right==left){
				return true;
			}
			return false;
		}

		if(left<right){
			map.put(key,false);
			return false;
		}

		if(s.charAt(index)=='('){
			if(checkIsValidStringUtil(s,left+1,right,len,index+1))
				return true;
		}
		else if(s.charAt(index)==')'){
			if(checkIsValidStringUtil(s,left,right+1,len,index+1))
				return true;
		}else{

			// System.out.println(left+" "+right);
			
			if(checkIsValidStringUtil(s,left+1,right,len,index+1) || checkIsValidStringUtil(s,left,right,len,index+1) || checkIsValidStringUtil(s,left,right+1,len,index+1) )
				return true;
			}
			
		map.put(key,false);
		return false;
	}
}