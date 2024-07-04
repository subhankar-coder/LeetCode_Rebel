package PaintHouseII;

import java.util.HashMap;

public class PaintHouseII {
    
    public static int paintCostUtilDP(int [][] cost,int n,int k,int r,int c,int lock,HashMap<String,Integer>dp){
		if(r>=n)
			return 0;

		String key = r+"_"+lock;

		if(dp.containsKey(key))
			return dp.get(key);

		int minValue=Integer.MAX_VALUE;
		for(int i=0;i<k;i++){
			if(lock!=i){
				int value = paintCostUtilDP(cost,n,k,r+1,i,i,dp);
				minValue=Math.min(minValue,value+cost[r][i]);
			}
		}

		dp.put(key, minValue);
		return minValue;

	}
}
