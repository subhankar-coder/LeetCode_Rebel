package IsoMorphString;

import java.util.*;

public class IsoMorphicString{

	public static void main(String[] args) {
		String s="paper";
		String t="title";

			int len = s.length();

			if(len!=t.length()){
				System.out.println("false");
				return;
			}
			System.out.println(isIsoMorph(s,t,len));

	}

	public static boolean isIsoMorph(String s,String t,int len){
		HashMap<Character,Character> hmap =new HashMap<>();

		for(int i=0;i<len;i++){
			if(s.charAt(i)!=t.charAt(i)){
				char ch = hmap.getOrDefault(s.charAt(i),' ');
				if(ch==' '){
					hmap.put(s.charAt(i),t.charAt(i));
				}else if(ch!=t.charAt(i))
					return false;
			}
		}
		return true; 
	}
}