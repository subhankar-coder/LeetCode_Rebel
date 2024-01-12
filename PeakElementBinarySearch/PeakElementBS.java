package PeakElementBinarySearch;

public class PeakElementBS {

    public static void main(String[] args) {
        int [] nums={1,2};
        int n=nums.length;
        int mid = n/2;
        while(mid>=0 && mid<n){
            if(mid-1>=0 && mid+1<n && nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]){
                System.out.println(nums[mid]);
                break;
            }else if(mid+1<n && nums[mid]<nums[mid+1]){
                
                mid=mid+1;
            }else if(mid+1==n && mid-1>=0 && nums[mid]>nums[mid-1]){
                System.out.println(nums[mid]);
                break;
            }else if(mid==0 && mid+1<n && nums[mid]>nums[mid+1]){
                System.out.println(nums[mid]);
                break;
            } else {
                mid=mid-1;
            }
        } 
    }
}