package KthEleOfTwoSortedArraays;

import java.util.*;

public class KthEleOfTwoSortedArrays{
	public static void main(String[] args) {
		
	}
	public static int solve(ArrayList<Integer> arr1,ArrayList<Integer> arr2,int k,int start1,int end1,int start2,int end2){
      
        if(start1==end1){
        return arr2.get(start2+k);
        }

        if(start2==end2){
        return arr1.get(start1+k);
        }

        int mid1 = (start1+end1)/2;
        int mid2 = (start2+end2)/2;

        if(mid1-start1+mid2-start2 <k){
        if(arr1.get(mid1)>arr2.get(mid2)){
            return solve(arr1,arr2,k-(mid2-start2)-1,start1,end1,mid2+1,end2);
        }else{
            return solve(arr1,arr2,k-(mid1-start1)-1,mid1+1,end1,start2,end2);
        }
        }else{
        if(arr1.get(mid1)>arr2.get(mid2)){
            return solve(arr1,arr2,k,start1,mid1,start2,end2);
        }else{
            return solve(arr1,arr2,k,start1,end1,start2,mid2);
        }
    }
  }
}