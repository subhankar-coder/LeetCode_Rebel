package BackTracking.TugOfWar;

import java.util.*;
public class TugOfWar {

    private  static int diff=Integer.MAX_VALUE;
    public static void main(String[] args) {
        int [] input={23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
        int size = input.length;
        int len1=0;
        if(size%2==0){
            len1=size/2;
        }
        else{
            len1=(size+1)/2;
        }
        int [] array1=new int [len1];
        solve(input,size,array1,len1,0,0);
        System.out.println(diff);
    }
    public static void solve(int [] input,int len,int [] array1,int len1,int source,int index){
        if(index>=len)
            return;
        if(source==len1){
            int [] list1=new int[len1];
            int [] inputClone = input.clone();
            int [] list2= new int [len-len1];
            for(int i=0;i<len1;i++){
                list1[i]=input[array1[i]];
                inputClone[array1[i]]=0;
            }
            int ind=0;
            for(int i=0;i<len;i++){
                if(inputClone[i]!=0){
                    list2[ind++]=inputClone[i];
                }
            }
            int curr = Math.abs(Arrays.stream(list1).sum()-Arrays.stream(list2).sum());
            if(curr<diff){
                diff=curr;
            System.out.println("Difference is "+curr);
            System.out.println("The arrays are "+Arrays.toString(list1)+" "+Arrays.toString(list2));
            }
            return;
        }
        array1[source]=index;
        solve(input,len,array1,len1,source+1,index+1);
        solve(input,len,array1,len1,source,index+1);
    }

}
