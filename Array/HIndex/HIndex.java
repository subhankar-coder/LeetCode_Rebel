package Array.HIndex;
import java.util.*;
import java.util.Arrays;

public class HIndex {

    public static void main(String[] args) {
        int [] citations={3,0,1,5,6};
        int hIndex=0;
        Arrays.sort(citations);
        for(int i=0;i<citations.length;i++){
            
                hIndex=Math.max(hIndex,Math.min(citations[i],citations.length-i));
            
        }
        System.out.println(hIndex);
    }
    
}
