package Heap_Sort.KSmallestPair;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;


public class KSmallestPairs {


    public static void main(String[] args) {
        int []nums1 = {1};
        int [] nums2= {3,5,6,7,8,100};
        int k=4;
        Set<List<Integer>> set = new HashSet<>();
        PriorityQueue<Map.Entry<Integer,List<Integer>>> queue= new PriorityQueue<>((a,b)->a.getKey()-b.getKey());

        int m =nums1.length;
        int n = nums2.length;
        
        queue.add(new AbstractMap.SimpleEntry<Integer,List<Integer>>(nums1[0]+nums2[0],Arrays.asList(0,0)));
        int index=0;
        int i=0;
        int j=0;
        List<List<Integer>> res = new ArrayList<>();

        while(index<k && i<m && j<n ){
            // Map.Entry<Integer,List<Integer>> entry= new AbstractMap.SimpleEntry<Integer,List<Integer>>(nums1[i+1]+nums2[j], Arrays.asList(nums1[i+1],nums2[j]));
            if(i+1<m ){
                Map.Entry<Integer,List<Integer>> entry= new AbstractMap.SimpleEntry<Integer,List<Integer>>(nums1[i+1]+nums2[j], Arrays.asList(i+1,j));
                if(!set.contains(entry.getValue())){

                    queue.add(entry);
                    set.add(entry.getValue());
                }
            }
            if (j+1 <n){
                Map.Entry<Integer,List<Integer>> entry= new AbstractMap.SimpleEntry<Integer,List<Integer>>(nums1[i]+nums2[j+1],Arrays.asList(i,j+1));
                
                if(!set.contains(entry.getValue())){

                    queue.add(entry);
                    set.add(entry.getValue());
                }
            }
            index++;
            Map.Entry<Integer,List<Integer>> entry=queue.poll();
            i=entry.getValue().get(0);
            j=entry.getValue().get(1);
            res.add(Arrays.asList(nums1[i],nums2[j]));
        }

        System.out.println(res);
        
        // while (k>0 && !queue.isEmpty()) {
        //     Map.Entry<Integer,List<Integer>> entry=queue.poll();
        //     System.out.println(entry.getValue());
        //     k--;
        // }
    }
    
}
