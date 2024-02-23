package ChippestFlightWithinKStops;

import java.util.*;

public class ChippestFlightWithinKStops{

	static int visited[];

	public static void main(String[] args) {
		int n =3;
		int [][]flights = {{0,1,100},{1,2,100},{0,2,500}};
		int k = 0;
		int src=0;
		int des = 2;
		Map<Integer,List<int []>> map = new HashMap<>();
		visited= new int [n];
		for(int [] arr: flights){
			int from = arr[0];
			int  [] to = Arrays.copyOfRange(arr,1,3);
			
			if(!map.containsKey(from)){
				map.put(from,new ArrayList<int []>());
			}

			map.get(from).add(to);
		}
		// System.out.println(map);
		System.out.println(dijikstras(map,src,des,k,n));
	}
	public static int dijikstras(Map<Integer,List<int []>> graph,int src,int dest,int k,int n){

		// int stop=0;
		Queue<Pair> queue = new LinkedList<>();
		Pair source = new Pair(src,0,0);
		queue.add(source);
		int [] res = new int[n];
		Arrays.fill(res,Integer.MAX_VALUE); 
		while(!queue.isEmpty()){
			Pair p = queue.poll();
 
   			int addr = p.addr;
			int cost = p.cost;
			int stop=p.stop;

			System.out.println(addr+" "+cost+" "+stop);
			if(stop >k)
					continue;

		
			List<int []> li = graph.get(addr);
				// System.out.println(li);
			for (int [] arr: li){
					if(cost+arr[1]<res[arr[0]]){
						res[arr[0]]=cost+arr[1];
						Pair pair = new Pair(arr[0],cost+arr[1],stop+1);
						queue.add(pair);
					}
				}
		}	
		return res[dest]==Integer.MAX_VALUE?-1:res[dest];		
	}
}
class Pair{
	public int addr;
	public int stop;
	public int cost;
	public Pair(int addr,int cost,int stop){
		this.addr= addr;
		this.stop=stop;
		this.cost=cost;
	}
}