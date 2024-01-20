package TwoPointers.Sum3;
import java.util.*;
public class Sum3 {

    public static void main(String[] args) {
        int [] array={-1,0,1,2,-1,-4,-2,-3,3,0,4};
        // Arrays.sort(array);
        List<List<Integer>> res=new ArrayList<>();
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<array.length;i++){
            map.put(array[i],i);
        }
        for(int i=0;i<array.length;i++){
            int target=0-array[i];
            List<Integer> list=new ArrayList<>();
            int j=array.length-1;
            for(int k=0;k<j;k++){
                list.clear();
                list.add(array[i]);
                if(k==i)
                    continue;
                if(map.containsKey(target-array[k]) && map.get(target-array[k])!=i && map.get(target-array[k])!=k){
                    list.add(array[k]);
                    list.add(target-array[k]);
                    Collections.sort(list);
                    if(!res.contains(list))
                        res.add(new ArrayList<>(list));
                }
            }
            
        }
        System.out.println(res);
    }
    
}
