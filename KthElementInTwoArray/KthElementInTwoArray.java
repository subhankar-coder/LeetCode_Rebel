package KthElementInTwoArray;

import java.util.*;

public class KthElementInTwoArray{

	public static void main(String[] args) {
		int [] arr1={2,3,6,7,9};
		int [] arr2={1,4,8,10};

		int m= arr1.length;
		int n = arr2.length;

		System.out.println(divideAndConqure(arr1,m,arr2,n,5));
	}
	public static int divideAndConqure(int [] arr1,int m ,int [] arr2,int n,int k ){

		if(k==1)
				return Math.min(arr1[0],arr2[0]);

		if(m>n){
			return divideAndConqure(arr2,n,arr1,m,k);
		}

		if(m==0)
				return arr2[k-1];

		int i=Math.min(m,k/2);
		int j=Math.min(n,k/2);

		if(arr1[i-1]>arr2[j-1]){
			return divideAndConqure(arr1,m,Arrays.copyOfRange(arr2,j,n),n-j,k-j);
		}
		return divideAndConqure(Arrays.copyOfRange(arr1,i,n),m-i,arr2,n,k-i);
	}
}