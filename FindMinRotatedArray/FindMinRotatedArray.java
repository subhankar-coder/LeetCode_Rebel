package FindMinRotatedArray;

public class FindMinRotatedArray{
    public static void main(String[] args) {
        int [] nums={2,3,4,5,1};
        getMinElement(nums, 0, nums.length, nums.length);
    }
    public static void getMinElement(int [] nums,int start,int end,int len){
        int mid=(start+end)/2;
        if(mid<len){
            if(mid==len-1){
                if(nums[mid-1]>nums[mid]){

                    System.out.println(nums[mid]);
                    return;
                }
            }else if(mid==0){
                if(nums[mid+1]>nums[mid]){

                    System.out.println(nums[mid]);
                    return;
                }
            }else{
                if(nums[mid+1]>nums[mid] && nums[mid-1]>nums[mid]){
                    System.out.println(nums[mid]);
                    return;
                }
            }
        }
        if(start>=end)
            return;

        if(start<mid && nums[start]>nums[mid]){
            while(start<mid && nums[mid]>nums[mid-1]){
                mid--;
            }
            getMinElement(nums, start, mid, len);
            getMinElement(nums, mid+1, end, len);
        }else if(mid+1<end-1 && nums[end-1]<nums[mid+1]){
            mid++;
            while(mid<end && nums[mid]>nums[end-1]){
                mid++;
            }
            getMinElement(nums, start, mid, len);
            getMinElement(nums, mid+1, end, len);
        }else{
            getMinElement(nums, start, mid, len);
            getMinElement(nums, mid+1, end, len);
        }
    }
}