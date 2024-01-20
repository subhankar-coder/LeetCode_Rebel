package BackTracking.Combinations;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Combinations {

    static List<List<Integer>> reList=new ArrayList<>();
    public static void main(String[] args) {
        int n=4;
        int k=2;
        doCombination(n, k, 1, "",new ArrayList<>());
        System.out.println(reList);
    }
    public static void doCombination(int n,int k,int index,String result,List<Integer> list){
        if(k==0){
            reList.add(list);
            return;
        }
        for(int i=index;i<=n;i++){
            doCombination(n, k-1, i+1, result+String.valueOf(i),Stream.concat(list.stream(), Arrays.asList(i).stream()).collect(Collectors.toList()));
        }
    }

}
