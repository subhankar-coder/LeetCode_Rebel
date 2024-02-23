package FindEleInRotatedArray;

import java.util.*;

public class SearchInRotatedSortedArray{

	public static void main(String[] args) {
		ArrayList<Integer> arr= new ArrayList<>(Arrays.asList(2 ,3 ,5 ,8));
		int target =1;
		System.out.println(binarySearch(arr,0,arr.size()-1,3,arr.size()));
	}
	public static int binarySearch(ArrayList<Integer> arr,int start,int end ,int target,int n){

		if(start>end){
			return -1;
		}
		int mid = (start+end)/2;

		if(arr.get(mid)==target){
			return mid;
		}else if (arr.get(mid)>target){

			int m= mid;
			while(m+1<=end && arr.get(m)<arr.get(m+1)){
				m++;
			}
			if(m+1<=end){
				int right = binarySearch(arr,m+1,end,target,n);
				if(right!=-1)
						return right;
				int left = binarySearch(arr,start,mid-1,target,n);
				if(left!=-1)
						return left;
			}else{
				m=mid;
				while(start<=m-1 && arr.get(m-1)<arr.get(m)){
					m--;
				}
				int left = binarySearch(arr,m,mid-1,target,n);
				if(left!=-1)
						return  left;
			}
		}else{
				int m = mid;
				while(start<=(m-1) && arr.get(m-1)<arr.get(m)){
					m--;
				}
				if(start<=m-1){
					int left = binarySearch(arr,start,m-1,target,n);
					if(left!=-1)
							return  left;
					int right= binarySearch(arr,mid+1,end,target,n);
					if(right!=-1)
						return right;
				}
				else{
					m=mid;
					while (m+1<=end && arr.get(m)<arr.get(m+1)){
						m++;
					}
					int right = binarySearch(arr,mid+1,m,target,n);
					if(right!=-1)
						return right;
				}
			}
			return -1;
	}
}