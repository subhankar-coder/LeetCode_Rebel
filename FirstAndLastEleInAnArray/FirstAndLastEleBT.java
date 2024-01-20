package FirstAndLastEleInAnArray;


public class FirstAndLastEleBT {
    static int startIndex=-1;
    static int endIndex=-1;
    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};
        int target=8;
        binarySearch(nums, 0, nums.length, target,nums.length);
    }
    public static boolean binarySearch(int [] nums,int start,int end,int target,int len){
        int mid=(start+end)/2;
        if(mid<len && nums[mid]==target){
            if(startIndex==-1){
                startIndex=mid;
            }
            endIndex=mid;

            System.out.println(startIndex+" "+endIndex);
            if(start>=end){
                return false;
            }
            binarySearch(nums, mid+1, end, target,len);
        }
        if(start>=end){
            return false;
        }
        if(nums[mid]<target){
           binarySearch(nums, mid+1, end, target,len);
        }else{
            binarySearch(nums, start, mid, target,len);
                
        }
        return false;

    }    
}
