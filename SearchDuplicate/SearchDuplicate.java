package SearchDuplicate;

public class SearchDuplicate {

    public static void main(String[] args) {
        
        int [] nums = {1,3,4,2,2};
        int fast =nums[0];
        int slow =nums[0];

        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);
 
        fast=nums[0];
        while(fast!=slow){
            fast=nums[fast];
            slow = nums[slow];
        }
        System.out.println(slow);
    }
    
    
}
