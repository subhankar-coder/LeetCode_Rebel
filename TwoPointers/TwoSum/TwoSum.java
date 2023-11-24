package TwoPointers.TwoSum;
import java.util.*;

public class TwoSum{
    public static void main(String[] args) {
        int array [] = {2,7,11,15};
        int target=9;
        int start=0;
        int [] res = new int [2];
        int end=array.length-1;
        while(start<end){
            if(array[start]+array[end]==target){
                res[0]=start;
                res[1]=end;
                break;
            }else if(array[start]+array[end]>target){
                end--;
            }else{
                start++;
            }
        }
       System.out.println(Arrays.toString(res));
    }
}