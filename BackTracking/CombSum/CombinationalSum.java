package BackTracking.CombSum;
import java.util.*;

public class CombinationalSum {
    static List<List<Integer>> set= new ArrayList<>();
    public static void main(String[] args) {
        int [] array = {2,3,5};
        int target =8;
        printCombSum(array, target, new ArrayList<>());
    }
    public static void printCombSum(int [] array,int target,List<Integer> path){
        if(target<0)
            return;
        if(target==0){
            List<Integer>temp=new ArrayList<>();
            for(int item:path)temp.add(new Integer(item));
            quickSort(temp, 0, temp.size()-1);

            if(!set.contains(temp)){
                set.add(temp);
                System.out.println(temp);
            }
            return;
        }
        for(int i=0;i<array.length;i++){
            int ele=array[i];
            target=target-ele;
            path.add(ele);
            printCombSum(array, target, path);
            target=target+ele;
            path.remove(path.size()-1);

        }
    }
    public static  void quickSort(List<Integer> list,int start,int end){
        if(start>=end)
            return;

        int pivot=partition(list,start,end);
        quickSort(list, start, pivot-1);
        quickSort(list, pivot+1, end);
    }
    public static int partition(List<Integer> list,int start,int end){
        int i=start-1;
        int pivot=end;
        int j=start;
        while (j<pivot) {
            if(list.get(j)<list.get(pivot)){
                i++;
                swap(list, i, j);
            }
            j++;
        }
        swap(list, pivot, i+1);

        return i+1;
    }
    public static void swap(List<Integer>list,int i,int j){
        int temp=list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    
}
