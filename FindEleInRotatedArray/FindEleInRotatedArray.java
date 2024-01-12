package FindEleInRotatedArray;

public class FindEleInRotatedArray {
    public static void main(String[] args) {
        int [] nums = {5,1,2,3,4};
        int target=1;
        binarySearch(nums, 0, nums.length, target,nums.length);
    }
    public static boolean binarySearch(int [] nums,int start,int end,int target,int len){
        int mid = (start+end)/2;
        
        if(mid<len && mid>=0 && nums[mid]==target){
            System.out.println(mid);
            return true;
        }

        if(start>=end)
            return false;
        
        if(start<mid && nums[start]>nums[mid]){
            while(mid>start && nums[mid]>nums[mid-1]){
                mid--;
            }
            if(binarySearch(nums, start, mid, target,len) || binarySearch(nums, mid+1, end, target,len)){
                return true;
            }
        }else if(mid+1<end-1 && nums[mid+1]>nums[end-1]){
            mid=mid+1;
            while(mid<end && nums[mid]>nums[end-1]){
                mid++;
            }
            if(binarySearch(nums, start, mid, target,len) || binarySearch(nums, mid+1, end, target,len)){
                return true;
            }
        }else{
            if(binarySearch(nums, start, mid, target,len) || binarySearch(nums, mid+1, end, target,len))
                return true;
        }
        return false;
        
    }
}
