package MinTapsToWaterGarden;

import java.util.*;

public class MinTapsToWaterGraden{

	public static void main(String[] args) {
		int n=2;
		int ranges [] = {0,0,0};

		int [] dp = new int [n+1];

		for(int i=0;i<=n;i++){

			int l = Math.max(0,i-ranges[i]);
			int r = Math.min(n,i+ranges[i]);
			dp[l]= Math.max(dp[l],r);
		}

		int prev=0;
		int end =0;
		int taps =0;

		for(int i=0;i<=n;i++){
			end = Math.max(end,dp[i]);
	
			if(prev==i){	
				prev=end;
				taps++;		
			}

		}

		List<List<Integer>> list = new ArrayList<>();

		for(int i=0;i<=n;i++){
			int a = i-ranges[i];
			int b = i+ranges[i];

			list.add(new ArrayList<>(Arrays.asList(a,b)));
		}

		list.sort((a,b)->a.get(0)-b.get(0));

		System.out.println(list);

		int target =0;
		int i=0;
		int res =0;
		while(target<n){

			int currMax =target;

			while(i<=n && list.get(i).get(0)<=currMax){
				
				target = Math.max(target,list.get(i).get(1));
                i++;
			}

			if(currMax==target){
				
				return ;
			}
			res++;

		}

		System.out.println(res);		
	}
}