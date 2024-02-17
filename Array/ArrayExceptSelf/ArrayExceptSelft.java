package Array.ArrayExceptSelf;
import java.util.*;

public class ArrayExceptSelft {

    public static void main(String[] args) {

        int [] array = {-1,1,0,-3,3};
        
        int len= array.length;
        int upIndex=1;
        int downIndex=1;
        int [] up = new int [len];
        int [] down = new int [len];
        int [] res = new int [len];
        for(int i=0,j=array.length-1;i<len && j>=0;i++,j--){
            up[i]=upIndex*array[i];
            upIndex=up[i];
            down[j]=downIndex*array[j];
            downIndex=down[j];
        }
        res[0]=down[1];
        res[len-1]=up[len-2];
        for(int i=1;i<len-1;i++){
            res[i]=up[i-1]*down[i+1];
        }
        System.out.println(Arrays.toString(res));

    }
    
}
