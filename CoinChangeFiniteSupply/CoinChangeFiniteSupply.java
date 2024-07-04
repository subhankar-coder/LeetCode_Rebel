
package CoinChangeFiniteSupply;


import java.util.*;

public class CoinChangeFiniteSupply{

	static HashMap<String,Integer> map = new HashMap<>();
	public static void main(String[] args) {

		int n = 2;
		int [] coins = {1,2};
		int [] freq = {5,3};
		
		int v = 5;
		System.out.println(solve(coins,freq,v,n-1,freq[n-1]));

	}
	public static int solve(int [] coins,int [] freq,int v,int index,int f){

		if(v<0 || index<0 || f<0)
			return 0;
		if(v==0)
			return 1;

		String key = v+" "+f+" "+index;

		if(map.containsKey(key))
			return map.get(key);

		int ans =0;

		if(f>0 && v-coins[index]>=0){
			ans = solve(coins,freq,v-coins[index],index,f-1);
		}
		ans += solve(coins,freq,v,index-1,index>0 ?freq[index-1]:-1);

		map.put(key,ans);

		return ans;

	}
}
