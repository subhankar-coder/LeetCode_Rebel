package BackTracking.PrintAllCombination;
import java.util.*;

public class PrintAllCombination{
    public static void main(String[] args) {
        int [] array = new int[]{1,2,2};
        Arrays.sort(array);
       
        printAllComboOfArray(array,0,new ArrayList<>());
        
    }
    public static void printAllComboOfArray(int [] array,int n,List<Integer> sub){
        if(n==array.length){
            return ;
        }
        for(int i=n;i<array.length;i++){
            if(i!=n && array[i]==array[i-1])
                continue;
            sub.add(array[i]);
            System.out.println(sub);
            printAllComboOfArray(array, i+1,sub);
            sub.remove(sub.size()-1);

        }


    }
}