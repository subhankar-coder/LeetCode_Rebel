package Array.MergedArray;
import java.util.*;
public class MergedArray {
    public static void main(String[] args) {
        int []arr1={1,2,3,0,0,0};
        int [] arr2={2,4,5};
        int m=3;
        int n=3;
        mergeTwoList(arr1,arr2,m,n);
        System.out.println(Arrays.toString(arr1));

    }
    public static void mergeTwoList(int [] nums1,int [] nums2,int m,int n){
        int k=m+n;
        int index=0;
        int index2=0;
        int temp=0;
        while(index<k){
            if(index2<n && nums2[index2]<=nums1[index]){
                temp=nums1[index];
                for(int i=index+1;i<k;i++){
                    
                        int curr=nums1[i];
                        nums1[i]=temp;
                        temp=curr;
                }
                nums1[index]=nums2[index2];
                index2++;
                m++;
            }else if(index>=m && index2<n && nums1[index]==0){
                nums1[index]=nums2[index2];
                index2++;
            }
            index++;
        }
    }
    
}
