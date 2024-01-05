package DP.Triangle;

import java.util.*;
public class Triangle {

    
    public static void main(String[] args) {
        List<List<Integer>> triangle= Arrays.asList(Arrays.asList(2),Arrays.asList(3,4),Arrays.asList(6,5,7),Arrays.asList(4,1,8,3));
        List<HashMap<Integer,List<Integer>>> dp = new ArrayList<>();
        HashMap<Integer,List<Integer>> data = new HashMap<>();
        data.put(0,triangle.get(0));
        dp.add(data);
        minPathSum(triangle,triangle.size(),dp);
    }
    public static void minPathSum(List<List<Integer>> triangle,int n,List<HashMap<Integer,List<Integer>>> dp){
        int j=0;
        for(int i=1;i<n;i++){
            j=i-1;
            HashMap<Integer,List<Integer>> temp = getTwoListSum(triangle.get(i),dp.get(j));
            dp.add(temp);
        }
        int min=Integer.MAX_VALUE;
        for(Map.Entry<Integer,List<Integer>> entry:dp.get(dp.size()-1).entrySet()){
            for(int val:entry.getValue()){
                min=Math.min(val, min);
            }
        }
        System.out.println(min);
        // System.out.println(dp);
    }
    private static HashMap<Integer,List<Integer>> getTwoListSum(List<Integer> list, Map<Integer,List<Integer>> map) {
        List<Integer> result=new ArrayList<>();
        HashMap<Integer,List<Integer>> map2=new HashMap<>();
        List<Integer> element2=new ArrayList<>();
        List<Integer> element1=new ArrayList<>();
        for(Map.Entry<Integer,List<Integer>> entry: map.entrySet()){
            int key=entry.getKey();
            List<Integer> value=entry.getValue();

            for(int ele:value){
                element1.add(list.get(key)+ele);
            }
            map2.put(key, element1);
            element1=new ArrayList<>();
            if(key+1<list.size()){
                for(int ele:value){
                    element1.add(list.get(key+1)+ele);
                }
                if(!map2.containsKey(key+1))
                    map2.put(key+1, element1);
            }
        }
        return map2;
    }

    
}
