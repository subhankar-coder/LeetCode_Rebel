package Array.RemoveDuplicateII;
import java.util.*;
public class RemoveDuplicateII {
    public static void main(String[] args) {
        int [] array = {0,0,1,1,1,1,2,3,3};
        removeDuplicateII(array);
        System.out.println(Arrays.toString(array));
    }
    public static void removeDuplicateII(int [] nums){
        int index=0;
        int freq=0;
        int lastVisited=nums[index];
        for(int i=0;i<nums.length;i++){
            if(lastVisited==nums[i] && freq<2){
                nums[index]=nums[i];
                index++;
                freq++;
                lastVisited=nums[i];
            }else if(lastVisited!=nums[i]){
                nums[index]=nums[i];
                lastVisited=nums[i];
                index++;
                freq=1;
            }
        }
        System.out.println(index);
    }
}
