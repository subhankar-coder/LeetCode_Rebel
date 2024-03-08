package MaxFreqOfAnArray;

import java.util.*;

public class MaxFreqOfAnArray{

	public static void main(String[] args) {
		
	}
	public int maxFrequencyElements(int[] nums) {

        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        int max = 0;
        Collection<Integer> values=map.values();
        Iterator<Integer> it = values.iterator();

        while(it.hasNext()){
            int a = it.next();
            max=Math.max(a,max);
        }

        final int m = max;
        
        int count = (int)values.stream().mapToInt(i->i).filter(j->j==m).count();

        return count*m;
    }
}