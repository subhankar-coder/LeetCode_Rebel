package MinNumOfPlatForms;

import java.util.*;

public class MinNumOfPlatForms{

	public static void main(String[] args) {
		
		int [] at = {41 ,1616 ,297, 2042 ,1013, 987, 2050, 525, 636, 109 };
		int [] dt = {2275, 2076, 1580, 2144, 1231, 1672, 2137, 1016, 2234, 1043}; 

		int n = at.length;
		Pair [] pairs = new Pair[n];

		for(int i=0;i<n;i++){
			pairs[i]= new Pair(at[i],dt[i]);
		}
		Arrays.sort(pairs,(a,b)->a.arrival-b.arrival);
		PriorityQueue<Integer> queue= new PriorityQueue<>();
		int count=1;

		queue.add(pairs[0].departure);

		for(int i=1;i<n;i++){
			if(queue.peek()<pairs[i].arrival){
				queue.poll();
			}else{
				count++;
			}
			queue.add(pairs[i].departure);
				
				
		}

		// System.out.println(count);

		mergeSort(at,dt,n);

	}
	public static void mergeSort(int [] at,int [] dt,int n){

		Arrays.sort(at);
		Arrays.sort(dt);

		System.out.println(" at "+Arrays.toString(at));
		System.out.println(" dt "+Arrays.toString(dt));

		int count =1;
		int i=1;
		int j=1;

		while(i<n && j<n){

			if(at[i]<=dt[j]){
				count++;
				
			}else{
				j++;
			}
			i++;
		}

		System.out.println(count);
	}
}

class Pair{
	public int arrival;
	public int departure;

	public Pair(int arrival,int departure){
		this.arrival=arrival;
		this.departure=departure;
	}
}