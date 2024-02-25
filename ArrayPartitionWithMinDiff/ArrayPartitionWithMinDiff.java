package ArrayPartitionWithMinDiff;

import java.util.*;

public class ArrayPartitionWithMinDiff{

	static int min =Integer.MAX_VALUE;
	public static void main(String[] args) {
		int [] arr ={3, 1, 5, 2, 8};
		int n = arr.length;
		int sum = Arrays.stream(arr).boxed().mapToInt(i->i).sum();
		solve(arr,n,sum,0,0);
		System.out.println(min);
	}
	public static void solve(int [] arr,int n,int sum,int currSum,int index){

			if(index>=n)
					return;

			int diff = (int) (Math.abs((sum-currSum)-currSum));
			min = Math.min(min,diff);

			for(int i=index;i<n;i++){
				solve(arr,n,sum,currSum+arr[i],i+1);
			}
	}

}