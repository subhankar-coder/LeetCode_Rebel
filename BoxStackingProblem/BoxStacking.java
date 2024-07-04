package BoxStackingProblem;


import java.util.*;
// import java.util.Collections

public class BoxStacking{

	public static void main(String[] args) {
		int [] height = {4 ,1 ,4 ,10};
		int [] width  = {6 ,2 ,5 ,12};
		int [] length = {7 ,3 ,6 ,32};

		int n = height.length;

		List<List<Integer>> li = new ArrayList<>();

		for(int i=0;i<n;i++){
			int [] array = {height[i],width[i],length[i]};
			generateAllCombinations(height[i],width[i],length[i],li);
		}

		Collections.sort(li,new Comparator<List<Integer>>(){
			public int compare(List<Integer> l1,List<Integer> l2){
				return -1*(l1.get(3)-l2.get(3));
			}
		});

		int len = li.size();
		int [] dp = new int [len];
		int maxHeight = Integer.MIN_VALUE;

		for(int i=0;i<len;i++){
			int current_height = li.get(i).get(0);
			int current_width=li.get(i).get(1);
			int current_length= li.get(i).get(2);
			int val =0;
			for(int j=0;j<i;j++){
				
				if(current_width<li.get(j).get(1) && current_length<li.get(j).get(2)){
					val = Math.max(val,dp[j]);
				}
			}
			dp[i]=current_height+val;
			maxHeight=Math.max(maxHeight,dp[i]);

		}
		System.out.println(Arrays.toString(dp));
		System.out.println(maxHeight);

	}
	public static void generateAllCombinations(int height,int width,int length ,List<List<Integer>> list){

		list.add(Arrays.asList(height,Math.max(width,length),Math.min(width,length),Math.max(width,length)*Math.min(width,length)));
		list.add(Arrays.asList(width,Math.max(height,length),Math.min(height,length),Math.min(height,length)*Math.max(height,length)));
		list.add(Arrays.asList(length,Math.max(width,height),Math.min(width,height),Math.min(width,height)*Math.max(width,height)));

	}
}