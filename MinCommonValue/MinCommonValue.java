package MinCommonValue;

import java.util.*;

public class MinCommonValue{

	public static void main(String[] args) {
		
		int [] nums1={1,2,3,6};
		int [] nums2={2,3,4,5};

		int len1=nums1.length;
		int len2 = nums2.length;

		int i=0;
		int j=0;

		while(i<len1 && j<len2){
			if(nums1[i]==nums2[j]){
				System.out.println(nums1[i]);
				break;
			}

			if(nums1[i]<nums2[j]){
				i++;
			}else if(nums1[i]>nums2[j]){
				j++;
			}

		}

		System.out.println(-1);
	}
}