package MinSubArrayWithRequiredSum;


import java.util.*;

public class MinSubArrayWithSum{

	public static void main(String[] args) {
		
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2,3,1,1,1,1,1));
		int n = arr.size();
		int target = 5;
		ArrayList<Integer> res=new ArrayList<>();

		int low =0;
		int high=0;

		long [] array = new long[n];
		array[0]=1L*arr.get(0);

		for(int i=1;i<n;i++){
			array[i]=array[i-1]+arr.get(i);
		}

		int ub = upperBound(array,0,n,target);

		System.out.println(ub);
		int i=0;

		if(ub>=n){
			if(array[ub-1]==target){
				System.out.println(n);
				return;
			}
		}

		System.out.println(ub);
		int ans = Integer.MAX_VALUE;
		for(;ub<n;ub++){
            for(;i<ub;i++){
                if(array[ub]-array[i]<=target){
                    break;
                }
            }
            if(ans> (ub-i+1)){
            	ans=ub-i+1;
            	low=i;
            	high=ub;
            }
        }

        System.out.println(ans+" low "+low +" high "+high);

		for(;low<=high;low++){
			res.add(arr.get(low));
		}
		System.out.println(res);

	}	
	public static int upperBound(long [] arr,int low,int high,int target){

		while(low<high){
			int mid = low+(high-low)/2;
			if((target*1L) >=arr[mid]){
				low=mid+1;
			}else{
				high=mid;

			}
		}
		return low;
	}
}