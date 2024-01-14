package MedianTwoSortedArray;

public class MedianTwoSortedArray {

     public static void main(String[] args) {
        int [] nums1={1,2};
        int [] nums2={3,4};
        
        System.out.println(findTheMedian(nums1, nums2));
     }

     public static double findTheMedian(int [] arr1,int [] arr2){
      
         int m = arr1.length;
         int n = arr2.length;
         if(m>n){
            return findTheMedian(arr2, arr1);
         }

         int leftOverSize = (m+n+1)/2;
         int start =0;
         int end = m;

         while(start<=end){
            int midA = (start+end)/2;
            int midB=leftOverSize-midA;

            int l1= midA>0 ?arr1[midA-1]:Integer.MIN_VALUE;
            int l2=midB>0? arr2[midB-1]:Integer.MIN_VALUE;
            
            int r1=midA<m?arr1[midA]:Integer.MAX_VALUE;
            int r2=midB<n?arr2[midB]:Integer.MAX_VALUE;

            if(l1<=r2 && l2<=r1){
               if((m+n)%2==0){
                  return (Math.max(l1,l2)+Math.min(r1, r2))/2.0;
               }else{
                  return Math.max(l1, l2);
               }
            }else if(l1>r2){
               end=midA-1;
            }else {
               start=midA+1;
            }
         }
         return 0.0;
     }
}