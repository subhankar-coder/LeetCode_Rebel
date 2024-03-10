package TarjansAlgo;

import java.util.*;

public class TarjansAlgo{

	static int n ;
	static Map<Integer,List<Integer>> graph ;
	static int [] ids ;
	static int [] low ;
	static Stack<Integer> st;
	static boolean [] onStack;
	static int scc=0;
	static List<List<Integer>> res ;
	static int id=0;
	public static void main(String[] args) {
		n=5;
		graph = new HashMap<>();
		ids =new int [n];
		low = new int [n];
		res=new ArrayList<>();
		Arrays.fill(ids,-1);
		st=new Stack<>();
		onStack=new boolean [n];

		int [][] edges = {{0,2},{0,4},{1,2},{1,4},{3,1},{3,4},{4,3}};

		for(int [] edge : edges){
			if(graph.containsKey(edge[0])){
				graph.get(edge[0]).add(edge[1]);
			}else{
				graph.put(edge[0],new ArrayList<>(Arrays.asList(edge[1])));
			}
		}
		System.out.println(graph);
		findSccs();
	}
	public static void findSccs(){

		for(int i=0;i<n;i++){
			if(ids[i]==-1){
				dfs(i);
			}
		}

		System.out.println(res);

	}
	public static void dfs(int src){
		
		st.add(src);
		ids[src]=low[src]=id++;
		onStack[src]=true;

		List<Integer> neighbour = graph.containsKey(src)?graph.get(src):new ArrayList<>();
			System.out.println("src "+src);
			for(int to: neighbour){
				if(ids[to]==-1){
					dfs(to);
				}
				if(onStack[to]){
					System.out.println(" src "+src+" to "+to);
					low[src]=Math.min(low[src],low[to]);
				}
			}
			System.out.println("low "+Arrays.toString(low));
			System.out.println(" stack "+st);
			System.out.println(" ids "+Arrays.toString(ids));
			List<Integer> result = new ArrayList<>();
			if(ids[src]==low[src]){
				while(!st.isEmpty()){
					int ele = st.pop();
					result.add(ele);
					onStack[ele]=false;
					low[ele]= ids[src];

					if(ele==src)
							break;	
				}
				scc++;
				Collections.reverse(result);
				res.add(result);
			}
			System.out.println(scc+"  "+result);
		
	}

}

// 5 6
// 0 1
// 1 2
// 1 4
// 2 3
// 3 2
// 4 0