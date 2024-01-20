package Sort.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
        public static void main(String[] args) {
            List<Integer> list = new ArrayList<>(Arrays.asList(3,2,3));
            quickSort(list, 0, list.size()-1);
            System.out.println(list);

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
