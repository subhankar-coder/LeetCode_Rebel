package Array.MajorityElement;
import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        int [] array = {3,2,3};
        int freq=1;
        Arrays.sort(array);
        for(int i=0;i<array.length-1;i++){
            if(array[i]==array[i+1]){
                freq++;
                if(freq>=(array.length/2)+1)
                    System.out.println(array[i]);
            }else{
                freq=1;
            }
        }
    }
    
}
