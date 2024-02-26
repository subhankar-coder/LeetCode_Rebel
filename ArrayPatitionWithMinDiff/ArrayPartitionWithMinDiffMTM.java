package ArrayPatitionWithMinDiff;

import java.util.*;

public class ArrayPartitionWithMinDiffMTM{

	public static void main(String[] args) {
		
		int [] arr = {0,6,11,17,18,24};
		int n = arr.length;


		int m = n/2;

		List<List<Integer>> leftDp = generateDp(arr, 0, m-1, m);

		List<List<Integer>> rightDp = generateDp(arr, m, n-1, m);

		for(int i=1;i<=m;i++)
			Collections.sort(rightDp.get(i));

		// System.out.println(leftDp);

		// System.out.println(rightDp);

		int res = Integer.MAX_VALUE;

			int sum =0;
			for(int num : arr){
				sum+=num;
			}
			int target = sum/2;

			for(int i=1;i<=m;i++){
				for(int ele:leftDp.get(i)){
					int sec = target-ele;
					List<Integer> li = rightDp.get(m-i);

					// Collections.sort(li);
					int ind=Collections.binarySearch(li, sec);
					if(ind<0)
						ind = -1*(ind+1);
					if(ind >=li.size())
						ind = ind-1;
					int ele2 = li.get(ind);

					int currSum = ele+ele2;
					int diff = Math.abs( (sum-currSum)-currSum );

					res = Math.min(res, diff);
				}
			}

			System.out.println(res);
	}
	public static List<List<Integer>> generateDp(int [] arr,int start,int end,int n ){

		List<List<Integer>> dp = new ArrayList<>();
		dp.add(new ArrayList<>(Arrays.asList(0)));
		List<Pair> sum =new ArrayList<>();
		for(int i=1;i<=n;i++)
			dp.add(new ArrayList<>());

		sum.add(new Pair(0,0));

		for(int i=start;i<=end;i++){
			int size= sum.size();
			for(int j=0;j<size;j++){
				Pair p = sum.get(j);
				int index=p.index;
				int value = p.value;

				dp.get(index+1).add(value+arr[i]);
				Pair pair = new Pair(index+1, value+arr[i]);
				sum.add(pair);
			}
		}

		return dp;
	}
}

class Pair{
	public int index;
	public int value;

	public Pair(int index,int value){
		this.index=index;
		this.value=value;
	}
}