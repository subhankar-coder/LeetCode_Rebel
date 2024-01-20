package BackTracking.SubsetSub;
import java.util.*;

public class subSetSum {

    static ArrayList<ArrayList<Integer>> result=new ArrayList<>();
    public static void main(String[] args) {
        int [] array = {1,2,3};
        int target=3;
        ArrayList<Integer> arr=new ArrayList<>();
        subsetSum(array,0,target,arr);
        System.out.println(result);
    }
    public static void subsetSum(int [] array,int source,int target,ArrayList<Integer> arr){

        for(int i=source;i<array.length;i++){
            arr.add(array[i]);
            int sum=arr.stream().mapToInt(Integer::intValue).sum();
            if(sum==target){
                result.add(new ArrayList<>(arr));
            }
            subsetSum(array,i+1,target,arr);
            arr.remove(arr.size()-1);
        }
    }
}
