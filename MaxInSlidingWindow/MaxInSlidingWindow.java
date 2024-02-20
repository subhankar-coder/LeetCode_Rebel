package MaxInSlidingWindow;

import java.util.*;

public class MaxInSlidingWindow{

	public static void main(String[] args) {
		
		int [] nums = {1,3,-1,-3,5,3,6,7};
		int k =3;
		int n = nums.length;
		int [] ans = new int [n-k+1];
		int index=0;
		Deque<Integer> qi = new LinkedList<>();
		int i=0;
		for(;i<k;i++){
			while(!qi.isEmpty() && nums[i]>= nums[qi.peekLast()])
					qi.removeLast();

			qi.addLast(i);
		}

		for(;i<n;i++){

			ans [index]=nums[qi.peek()];

			while(!qi.isEmpty() &&  qi.peek() <= i-k)
					qi.removeFirst();

			while(!qi.isEmpty() && nums[i]>= nums[qi.peekLast()])
					qi.removeLast();

			qi.addLast(i);
			index++;
		}
		ans[index]=qi.peek();

		System.out.println(Arrays.toString(ans));
	}
}