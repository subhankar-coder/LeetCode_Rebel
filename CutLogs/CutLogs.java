package CutLogs;


import java.util.*;

public class CutLogs{

	public static void main(String[] args) {
		int [] arr ={4, 42, 40, 26, 46};
		int k = 20;
		int n = arr.length;

		int max = Integer.MIN_VALUE;
		int min = 0;

		for(int num : arr){
			max = Math.max(max,num);
			// min = Math.min(min,num);
		}
		int res =0;
		while(min<=max){

			int mid = (min+max)/2;

			int wood = woods(arr,mid,n);

			// System.out.println(" wood "+wood+" mid "+ mid);

			if(wood<k){
				max= mid-1;
			}else{
				res=mid;
				min=mid+1;
			}
		}
		System.out.println(res);
	}

	public static int woods(int [] arr,int height,int n){

		int wood =0;

		for(int i=0;i<n;i++){

			if(arr[i]>height){
				wood+=(arr[i]-height);
			}
		}

		return wood;
	}
}