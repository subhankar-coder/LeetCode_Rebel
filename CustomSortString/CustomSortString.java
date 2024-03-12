package CustomSortString;

import java.util.*;

public class CustomSortString{

	public static void main(String[] args) {
		String order ="bcafg";
		String s = "abcd";


		Map<Character,Integer> map = new HashMap<>();

		for(int i=0;i<order.length();i++){
			map.put(order.charAt(i),i+1);
		}

		int n = s.length();
		
		String str ="";
		for(int i=0;i<n;i++){
			if(!map.containsKey(s.charAt(i))){
				str+=String.valueOf(s.charAt(i));
			}else{
				if(str.isEmpty() || !map.containsKey(str.charAt(0)) || map.get(str.charAt(0))>=map.get(s.charAt(i))){
					str= String.valueOf(s.charAt(i))+str;

				}else{
					int j=0;
					while(map.containsKey(str.charAt(j)) && map.get(str.charAt(j))< map.get(s.charAt(i))){
						j++;
					}
					str = str.substring(0,j)+String.valueOf(s.charAt(i))+str.substring(j);
				}
			}
		}
		System.out.println(str);
	}
}