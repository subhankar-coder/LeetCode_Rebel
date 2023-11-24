package Array.Candy;
import java.util.*;
public class Candy {
    public static void main(String[] args) {
        int [] array = {1,2,2};
        int [] up= new int [array.length];
        int [] down= new int[array.length];
        Arrays.fill(up,1);
        Arrays.fill(down,1);
        for(int i=1,j=array.length-2;i<array.length && j>=0;i++,j--){
            if(array[i]>array[i-1]){
                up[i]=up[i-1]+1;
            }
            if(array[j]>array[j+1])
                down[j]=down[j+1]+1;
        }
        int sum=0;
        for(int i=0;i<array.length;i++){
            if(i+1<array.length && i-1>=0 && array[i]>array[i+1] && array[i]>array[i-1]){
                if(up[i-1]<down[i+1]){
                    sum+=down[i+1]+1;
                }else{
                    sum+=up[i-1]+1;
                }
            }
            else if(i+1<array.length && array[i]>array[i+1]){
                sum+=down[i+1]+1;
            }
            else if(i-1>=0 && array[i]>array[i-1]){
                sum+=up[i-1]+1;
            }else{
                sum+=1;
            }
        }
        System.out.println(sum);

    }
}
