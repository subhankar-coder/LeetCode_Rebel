package Array.RemoveDuplicate;
import java.util.*;
public class RemoveDuplicate {
    public static void main(String[] args) {
        int [] array = {1,1,2};
        removeDuplicate(array);
        System.out.println(Arrays.toString(array));
    }
    public static void removeDuplicate(int [] array){
        int index=0;
        int lastVisited=array[index];
        for(int i=0;i<array.length-1;i++){
            if(lastVisited!=array[i+1]){
                lastVisited=array[i+1];
                array[index+1]=array[i+1];
                index++;
            }
        }
        System.out.println(index+1);
    }
}
