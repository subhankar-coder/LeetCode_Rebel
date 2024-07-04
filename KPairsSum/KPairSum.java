package KPairsSum;

import java.util.*;

public class KPairSum{

	public static void main(String[] args) {
		int [] arr ={1, 5, 7, -1, 5};
		int k =6;
		int n = arr.length;
		Arrays.sort(arr);
		List<int []> res = new ArrayList<>();
		for(int i=0;i<n;i++){
			int x = arr[i];
			int lb = lowerBound(arr,i+1,n,k-x);
			int ub = upperBound(arr,i+1,n,k-x);

			for(int j=0;j<(ub-lb);j++){
				res.add(new int []{x,k-x});
			}
		}
		for(int [] ele: res){
			System.out.println(Arrays.toString(ele));
		}

	}
	public static int lowerBound(int [] arr,int start,int end,int target){
		while(start<end){
			int mid = start+(end-start)/2;
			if(arr[mid]<target){
				start=mid+1;
			}else{
				end=mid;
			}
		}
		return start;
	}

	public static int upperBound(int [] arr,int start,int end,int target){

		while(start<end){
			int mid = start+(end-start)/2;
			if(arr[mid]<=target){
				start=mid+1;
			}else {
				end = mid;
			}
		}
		return start;
	}
}