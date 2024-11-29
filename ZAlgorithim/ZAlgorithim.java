package ZAlgorithim;

import java.util.*;

public class ZAlgorithim{

	public static void main(String[] args) {
		
		String s="baabaa";
		String p = "aab";

		int n = s.length();
		int m = p.length();

		zAlgorithim(s,p);
	}
	public static void zAlgorithim(String s,String p){
		String concat = p+"$"+s;
		int [] z = createZFunction(concat);
		System.out.println(Arrays.toString(z));
	}	
	public static int [] createZFunction(String str){

		int len = str.length();

		int [] z = new int [len];
		
		int l=0;
		int r =0;

		for(int k=1;k<len;k++){
			if(k>r){
				l=r=k;
				while(r<len && str.charAt(r)==str.charAt(r-l)){
					r++;
				}
				z[k]= r-l;
				r--;
			}else{
				int k1= k-l;

				if(z[k1]+k <= r){
					z[k]=z[k1];
				}else{
					l=k;	
					 while(r<len && str.charAt(r)==str.charAt(r-l)){
					r++;
				}
				z[k]= r-l;
				r--;
				}
			}
		}
		return z;
	}
}
