package ShortestSuperSeq;

import java.util.*;

public class ShortestSuperSeq{

	public static void main(String[] args) {
		
		String str1= "blinding";
		String str2 = "lights";

		int m = str1.length();
		int n = str2.length();

		int len = Math.min(m,n);

		List<Character> set = new ArrayList<>();

		int [][] dp = new int [m+1][n+1];

		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){

				if(str1.charAt(i-1)==str2.charAt(j-1)){
					dp[i][j]= dp[i-1][j-1]+1;
					set.add(dp[i-1][j-1],str1.charAt(i-1));
				}else{
					dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		int i =m;
		int j = n;
		String res ="";
		while(i>0 && j>0){
			if(str1.charAt(i-1)==str2.charAt(j-1)){
				res=Character.toString(str1.charAt(i-1))+res;
				i--;
				j--;
			}else if(dp[i-1][j]>dp[i][j-1]){
				i--;
			}else{
				j--;
			}

		}
		String str="";

		i=0;
		j=0;
		int index =0;
		while (i<m || j<n) {
			
			String s1="";
			String s2="";

			if(i<m){
				s1=Character.toString(str1.charAt(i));
				i++;
			}
			if(j<n){
				s2=Character.toString(str2.charAt(j));
				j++;
			}

			if(index<res.length() &&s1.equals(s2) && s1.equals(Character.toString(res.charAt(index))) ){
				str+=Character.toString(res.charAt(index));
				index++;
			}else if(index<res.length() && s1.equals(Character.toString(res.charAt(index))) ){
				str+=s2;
				i--;
			}else if(index<res.length() &&s2.equals(Character.toString(res.charAt(index))) ){
				str+=s1;
				j--;
			}else{
				str+=(s1+s2);
			}

			// if(str1.charAt(i)==str2.charAt(j) && str1.charAt(i)==res.charAt(index)){
			// 		str+=Character.toString(res.charAt(index));
			// 		index++;
			// }else {
			// 	str+=(Character.toString(str1.charAt(i))+Character.toString(str2.charAt(j)));
			// }
			// i++;
			// j++;
		}
		System.out.println(res);
		System.out.println(str);
	}
}