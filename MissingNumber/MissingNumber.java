package MissingNumber;

import java.util.*;

public class MissingNumber{
	public static void main(String[] args) {
		
	}
	public static String findMissingNumber(ArrayList<String> binaryNums, int n)  {
		
		int total = (n*(n+1))/2;
		int sum=0;
		for(int i=0;i<n;i++){
			sum+=Integer.parseInt(binaryNums.get(i),2);
		}
		return Integer.toBinaryString(total-sum);
	}
}