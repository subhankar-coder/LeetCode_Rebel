package MaxOddBinaryNumber;

import java.util.*;

public class MaxOddBinaryNumber{

	public static void main(String[] args) {
		String s ="0101";
		int len = s.length();
		int count=0;
		char [] ch = new char[len];
		for(int i=0;i<len;i++)
			if(s.charAt(i)=='1')
				count++;

		ch[len-1]='1';
		count--;
		int index=0;
		while(index<len-1 ){
			if(count>0){

				ch[index]='1';
				count--;
			}else{
				ch[index]='0';
			}
			index++;
		}
		System.out.println(new String(ch));
	}
}