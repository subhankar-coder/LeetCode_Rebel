package LongestCommonPrefix;

import java.util.*;

public class LongestCommonPrefix{

	public static void main(String[] args) {
		String [] arr = {"dog","racecar","car"};
		System.out.println(longestCommonPrefix(arr));
	}
	public static String longestCommonPrefix(String[] arr) {

        int n = arr.length;
        int minLen=Integer.MAX_VALUE;
        String minStr="";
		for(int i=0;i<n;i++){
			if(arr[i].length()<minLen){
                minLen=arr[i].length();
                minStr = arr[i];
            }
		}

		String res="";

		int start =0;
        int end =minLen;

      System.out.println(minStr);
        while(start<end){
            int mid =(start+end)/2;
            String prefix = minStr.substring(start,mid+1);
            boolean hasCommon=true;
            for(String s:arr){
              System.out.println(s.substring(start,mid+1)+"   "+start+"   "+mid+"  ");
                if(!s.substring(start,mid+1).equals(prefix)){
                    hasCommon=false;
                    end=mid;
                    break;
                }
            } 
            if(hasCommon){
                    res+=prefix;
                    start=mid+1;
             }
        }

		return res;
    }
}