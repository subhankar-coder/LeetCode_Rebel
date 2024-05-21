package LongestIncreasingSubSequence;


import java.util.*;

public class LongestIncreasingSubSequence{
	public static void main(String[] args) {
	
		int [] array = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
		int size = array.length;
		System.out.println(size);
		List<Integer> list = new ArrayList<>();

		for(int i=0;i<size;i++){
			if(list.isEmpty()){
				list.add(array[i]);
			}

			int index = Collections.binarySearch(list,array[i]);
			if(index<0){
				index = -1*(index+1);
			}
			if(array[i]>list.get(list.size()-1)){
				list.add(array[i]);
			}else{

				list.set(index,array[i]);
			}
		}

		System.out.println(list);

	}
}

