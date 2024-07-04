package CountBits;

import java.util.*;


public class CountBits{
	private static boolean end=false;
	public static void main(String[] args) {
		
		int n = 17;
		String binaryString = Integer.toBinaryString(n);
		int len = binaryString.length();
		int [] charray = new int[len];

		System.out.println(solve(charray,len,0,0,true,binaryString)); 
	}

	public static int solve(int [] charray,int len,int index,int oneCount,boolean isSet,String capString){

		if(index>=len ){
			// System.out.println("one count "+oneCount+" index "+index);
			return oneCount;
		}
		int ub = (int)capString.charAt(index);
		ub=ub-48;

		int upperLimit = 1;

		if(isSet){
			upperLimit=ub;
		}

		if(index==len-1 && isSet ){
			System.out.println("here"+(2*oneCount+1));
			// end =true;
			return ub==1?(2*oneCount+1):oneCount;
		}
		// System.out.println(ub+" "+isSet);
		// System.out.println("one count "+oneCount+" index "+index);

		int count =0;
		for(int i=0;i<=upperLimit;i++){

			System.out.println("before "+count+" index "+index+" one cnt "+oneCount+" i "+i);

			count+= solve(charray,len,index+1,i==1?oneCount+1:oneCount,(isSet && ub==i),capString);

			System.out.println("after "+count+" index "+index+" one cnt "+oneCount+" i "+i);
		}

		return count;

	}
}