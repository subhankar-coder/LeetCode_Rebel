package StronglyConnectedComponent;

import java.util.*;

public class StronglyConnectedComponent{

	static List<List<Integer>> adj;
	public static void main(String[] args) {
		
		int V=5;
		int E=6;


		ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
		edges.add(new ArrayList<>(Arrays.asList(0,1)));
		edges.add(new ArrayList<>(Arrays.asList(1,2)));
		edges.add(new ArrayList<>(Arrays.asList(1,4)));
		edges.add(new ArrayList<>(Arrays.asList(2,3)));
		edges.add(new ArrayList<>(Arrays.asList(3,2)));
		edges.add(new ArrayList<>(Arrays.asList(4,0)));

		adj=new ArrayList<>();
		for(int i=0;i<V;i++){
			adj.add(new ArrayList<>());
		}

		for(ArrayList<Integer> edge: edges){
			adj.get(edge.get(0)).add(edge.get(1));
		}

		findSCC(V);
	}
	public static void findSCC(int V){

		List<Integer> is_scc = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();

		for(int i=0;i<V;i++)
				is_scc.add(0);

		for(int i=0;i<V;i++){

			if(is_scc.get(i)==0){
				is_scc.set(i,1);
				List<Integer> scc= new ArrayList<>();
				scc.add(i);
				for(int j=0;j<V;j++){
					if(is_scc.get(j)==0 && isPath(i,j) && isPath(j,i)){
						is_scc.set(j,1);
						scc.add(j);
					}
				}

				res.add(scc);
			}
		}
		System.out.println(res);
	}
	public static boolean isDFS(int src,int dest,Set<Integer> visited){

		if(src==dest)
				return true;
		
		if(!visited.contains(src)){
			visited.add(src);
			List<Integer> neighbour = adj.get(src);

			if(neighbour!=null){
				for(int ele: neighbour){
					if(!visited.contains(ele) && isDFS(ele,dest,visited)){
							return  true;
					}
				}
			}
		}
		return false;
	}

	public static boolean isPath(int src,int dest){
		return isDFS(src,dest,new HashSet<>());
	}
}

