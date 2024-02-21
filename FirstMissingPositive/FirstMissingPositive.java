package FirstMissingPositive;


import java.util.*;

public class FirstMissingPositive{

	public static void main(String[] args) {
		 
		 int [] nums ={2, 1};
		 int n = nums.length;
		 int min =Integer.MAX_VALUE;

		 for(int i:nums){
            if(i>0){
                min = Math.min(min,i);
            }
        }
        if(min!=1){
        	System.out.println(1);
        	return;
        }

        for(int i=0;i<n;i++){

        	while(i+1 != nums[i] && nums[i]>0){
        		int ind = nums[i]-1;

        		if(ind<n && nums[ind]!=(ind+1)){
        			int temp = nums[ind];
        			nums[ind]=nums[i];
        			nums[i]=temp;
        		}else{
					break;
				}

        	}
        }

		for(int i=0;i<n;i++){
			if(nums[i]!=i+1){
				System.out.println(min);
				return;
			}
				min+=1;
		}

        System.out.println(Arrays.toString(nums));
	}
}