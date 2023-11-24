package Array.RotateArray;
import java.util.*;
public class RotateArray {
    public static void main(String[] args) {
        int [] array = {-1,100,3,99};
        int k=2;
        int part = k%array.length;
        int div = k/array.length;
        int startIndex=0;
        if(part ==0 && div%2==1)
        {
            Collections.reverse(Arrays.asList(array));
            return;
        }else if(part ==0 && div%2==0)
            return;
        int []partArray = new int [part];
        int partIndex=array.length-part;
        for(int i=0;i<part && partIndex<array.length;i++,partIndex++){
            partArray[i]=array[partIndex];
        }
        int lastIndex=array.length-1;
        for(int i=array.length-part-1,j=array.length-1;i>=0&&j>=part;i--,j--){
            array[j]=array[i];
        }
        for(int i=0;i<part;i++){
            array[i]=partArray[i];
        }
        System.out.println(Arrays.toString(array));
    }
}
