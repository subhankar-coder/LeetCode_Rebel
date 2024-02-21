package BitwiseAndOfRange;


import java.util.*;


public class BitwiseAndOfRange{

	
	public static void main(String[] args) {
		int left = 1;
		int right = Integer.MAX_VALUE;

	
		String rightInBit = Long.toBinaryString( right & 0xffffffffL | 0x100000000L ).substring(1);

		char [] ch = rightInBit.toCharArray();

		String leftBit =   Long.toBinaryString( left & 0xffffffffL | 0x100000000L ).substring(1);

		int padding = rightInBit.length()-leftBit.length();
		
		int ind =0;

		for(;ind<leftBit.length();ind++){
			if(leftBit.charAt(ind)!=rightInBit.charAt(ind+padding))
					break;
		}

		int index = ch.length-1;

		while(index>=ind){
			if(ch[index]=='1'){

					ch[index]='0';
					// break;
				}
				index--;

		}
		System.out.println(Arrays.toString(ch));
	}
}