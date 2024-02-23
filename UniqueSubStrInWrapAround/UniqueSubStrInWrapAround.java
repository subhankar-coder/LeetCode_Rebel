package UniqueSubStrInWrapAround;


import java.util.*;

public class UniqueSubStrInWrapAround{

	public static void main(String[] args) {
		String s = "zab";
		System.out.println(findSubstringInWraproundString(s));
	}
	public static int findSubstringInWraproundString(String s) {
        int [] dp = new int [26];
        int ans =0;
        int currLen=0;
        for(int i=0;i<s.length();i++){
            int curr = s.charAt(i)-'a';
            if(i>0 && s.charAt(i-1)!= (26+curr-1)%26+'a'){
                currLen =0;
            }
            currLen++;

            if(dp[curr]<currLen){
                ans+=(currLen-dp[curr]);
                dp[curr]=currLen;
            }
        }
        return ans;
    }
}