package Array.GasStations;
import java.util.*;
public class GasStations {
    public static void main(String[] args) {
        int [] gas={5,1,2,3,4};
        int [] cost={4,4,1,5,1};
        System.out.println(solveGreedy(gas,cost));

    }
    public static int solveGreedy(int [] gas,int [] cost){
        int [] array = new int [gas.length];
        for(int i=0;i<gas.length;i++){
            array[i]=gas[i]-cost[i];
        }
        if(array.length==1 && array[0]>=0)
            return 0;
        int sum=0;
        for(int i=0;i<gas.length;i++){
            sum+=array[i];
        }
        if(sum<0)
            return -1;
        else{
                int index=0;
                for(int i=0;i<array.length;i++){
                    if(array[i]>0){
                        index=i;
                        break;
                    }
                }
                int balance=array[index];
                int ind=index;
                for(int i=index+1;i<array.length;i++){
                    if(balance<=0 && array[i]<0){
                        balance=0;
                    }
                    if(balance<=0 && array[i]>0){
                        balance=array[i];
                        ind=i;
                    }else{
                        balance+=array[i];
                    }
                    
                }
                return ind;
        } 
    }
    public static int solveBruteForce(int [] gas,int [] cost){
        int len =gas.length;
        for(int i=0;i<len;i++){
            int ind=i;
            if(gas[i]>=cost[i]){
                 int j=0;
                int unit=0;
                int iterator=i;
                while(j<len){
                    iterator=iterator%len;
                    unit+=gas[iterator];
                    if(unit<cost[iterator]){
                        break;
                    }
                    unit=unit-cost[iterator];
                    iterator++;
                    j++;
                }
                if(j>=len){
                    return ind;
                }

            }
            
        }
        return -1;
    }
    
} 
