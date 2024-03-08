package WaterSupplyInVillage;

import java.util.*;
import java.util.stream.Collectors;

public class WaterSupplyInVillage{

	static int [] parent;
	static int [] rank;
	public static void main(String[] args) {
		
		int n=4;
		int k =4; 
		parent=new int [n+1];
		rank=new int [n+1];

		for(int i=0;i<=n;i++){
			parent[i]=i;
			rank[i]=0;
		}

		int [] wells = {1,2,1,2};
		int [][] pipes = {{1, 2 ,1}, {1 ,3 ,3},{2 ,3 ,3}, {3 ,4 ,1}};

		List<List<Integer>> graph = new ArrayList<>();

		for(int i=1;i<=n;i++){
			graph.add(new ArrayList(Arrays.asList(0,i,wells[i-1])));
		}
		for(int [] pipe: pipes){
			
			List<Integer> li = new ArrayList<>();
			li.add(pipe[0]);
			li.add(pipe[1]);
			li.add(pipe.length==3?pipe[2]:0);

			graph.add(li);
		}
		Collections.sort(graph,(a,b)->a.get(2)-b.get(2));
		System.out.println(krusksalsAlgo(graph,n,k));
	}
	public static int krusksalsAlgo( List<List<Integer>> graph,int n,int k){

			int j=0;
			int numOfEdges=0;
			int cost=0;
			while(j<n+k && numOfEdges<n){

				int a = graph.get(j).get(0);
				int b = graph.get(j).get(1);

				if(find(a)!=find(b)){
					numOfEdges++;
					cost+=graph.get(j).get(2);
					unionByRank(a,b);
				}
				j++;
			}
			return cost;
	}
	public static int find(int i){
		if(parent[i]==i)
				return i;

		parent[i]= find(parent[i]);
		return parent[i];
	}
	public static void unionByRank(int a,int b){

		int aParent = find(a);
		int bParent = find(b);

		int aRank = rank[aParent];
		int bRank = rank[bParent];

		if(aParent==bParent){
			return ;
		}
		if(aRank<bRank){
			parent[aParent]=bParent;
		}else if( bRank<aRank){
			parent[bParent]=aParent;
		}else{
			parent[aParent]=bParent;
			rank[bParent]+=1;
		}
	}
}