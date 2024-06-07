package DiceThrows;

import java.util.*;

public class DiceThrows {
	public static int mod = 1000000007;
	public static HashMap<String,Integer> map;
  public static void main(String[] args) {

    int d = 3;
    int f = 6;
    int s = 11;

		map = new HashMap<>();
	
		System.out.println(solve(0,d,f,s,0,"")); 
		
  }

	public static int solve(int index,int d,int f,int s,int sum,String str){

		String key = index+" "+sum;
		if(map.containsKey(key))
				return map.get(key);
    if(sum>s){
			return 0;
		}
		
		if(index>=d){
			if(sum==s)
					return 1; 
			return 0; 
		}

	//	System.out.println("here"+" "+sum);
		int total_sum=0;
		for(int i=1;i<=f;i++){
			
			total_sum= (total_sum+solve(index+1,d,f,s,sum+i,str+" "+String.valueOf(i)))%mod;
		}

		map.put(key,total_sum%mod);
		return (total_sum%mod);

	}
}
