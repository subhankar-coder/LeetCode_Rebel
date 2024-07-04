package AggressiveCows;

import java.util.*;
import java.util.stream.Collectors;


public class AggressiveCows{
	public static void main(String[] args) {

		int [] stalls = new int []{10 ,1 ,2 ,7 ,5};
		int n = stalls.length;
		int k = 3;
		List<Integer> li = Arrays.stream(stalls).boxed().mapToInt(i->i).boxed().collect(Collectors.toList());
		Collections.sort(li);

		int ans =-1;
		int l = 1;
		int r = li.get(n-1)-li.get(0);

		for(int i=0;i<n;i++){
			
			while(l<=r){
				int mid = (l+r)/2;
				if(getMax(mid,li,k-1,li.get(i),n)){
					ans=mid;
					l=mid+1;
				}else{
					r=mid-1;
				}
			}
		}
		// int ind = Collections.binarySearch(li,9);
		System.out.println(ans);
	}
	public  static boolean getMax(int max,List<Integer> li , int k,int start,int n){

		if(k==0){
			return true;
		}
		int index =Collections.binarySearch(li,start+max);

		if(index==-(n+1)){
			return false;
		}
		int next = index<0 ? li.get(-1*(index+1)):li.get(index);
		if(getMax(max,li,k-1,next,n)){
			return true;
		}

		return false;

	}
		
}
