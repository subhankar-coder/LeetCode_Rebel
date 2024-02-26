package AllPossibleSums;

import java.util.*;

public class AllPossibleSums{

	public static void main(String[] args) {
		int [] nums = {2,-1,0};
		int n = nums.length;
		System.out.println(findAllSums(nums));
		// System.out.println(getAllPossibleSum(nums));
	}
	public static List<Integer> getAllPossibleSum(int [] nums){
		
		List<Integer> res = new ArrayList<>();
		int n = nums.length;

		int totalSet =  1<<n;

		for(int mask = 0;mask<totalSet;mask++){

			int curr =0;
			for(int i=0;i<n;i++){
				if((mask & (1 << i ) )>0){
					curr+=nums[i];
				}
			}
			res.add(curr);
		}
		return res;
	}
	public static List<List<Integer>> findAllSums(int[] numbers) {
       
		// Arrays.sort(numbers); // Sort the numbers to avoid duplicates

		List<List<Integer>> dp = new ArrayList<>();
		
		dp.add(List.of(0));

        int n = numbers.length;

		for(int i=1;i<=n;i++)
			dp.add(new ArrayList<>());

        List<Pair> sums = new ArrayList<>();
        sums.add(new Pair(0, 0)); // Base case: empty subset has sum 0
        
        // For each number in the list
        for (int i = 0; i < n; i++) {
            // For each sum computed so far
            int size = sums.size();
            for (int j = 0; j < size; j++) {
                Pair p = sums.get(j);
				int index = p.index;
				int val= p.number;
				if(index<=n-1){

					dp.get(index+1).add(val+numbers[i]);
					Pair pair = new Pair(val+numbers[i],index+1);
					sums.add(pair);
				}
            }
        }
        
        return dp;
    }
}

class Pair{
	public int number;
	public int index;

	public Pair(int number,int index){
		this.number=number;
		this.index=index;
	}
}