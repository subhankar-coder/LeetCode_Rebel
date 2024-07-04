package KruksalsAlgo;

import java.util.*;

public class KruksalsMST{
	static int [] parent ;
	static int [] rank;
	public static void main(String[] args) {
		
		int V = 4;
		int E=6;
		parent=new int [V];
		rank = new int[V];

		ArrayList<ArrayList<Integer>> edges= new ArrayList<>();
		edges.add(new ArrayList(Arrays.asList(0,1,3)));
		edges.add(new ArrayList(Arrays.asList(0,2,1)));
		edges.add(new ArrayList(Arrays.asList(0,3,2)));
		edges.add(new ArrayList(Arrays.asList(1,2,5)));
		edges.add(new ArrayList(Arrays.asList(1,3,2)));
		edges.add(new ArrayList(Arrays.asList(2,3,4)));

		Collections.sort(edges,(a,b)->a.get(2)-b.get(2));

		System.out.println(kruksals(edges,V));
	}

	public static int kruksals(ArrayList<ArrayList<Integer>> edges,int V){
		
		for(int i=0;i<V;i++){
			parent[i]=i;
			rank[i]=0;
		}
		
		int j=0;
		int noOfEdges = 0;
		int sum=0;

		while(noOfEdges<V-1){
			int a = edges.get(j).get(0);
			int b = edges.get(j).get(1);

			if(find(a)!=find(b)){
				noOfEdges++;
				sum+=edges.get(j).get(2);
				unionByRank(a,b);
			}
			j++;
		}

		return sum;

	}

	public static int find(int i){
		if(i==parent[i])
			return i;
		parent[i]= find(parent[i]);
		return parent[i];
	}
	public static void unionByRank(int a,int b){
		int aParent= find(a);
		int bParent = find(b);

		if(aParent==bParent)
			return ;

		int aRank = rank[aParent];
		int bRank = rank[bParent];

		if(aRank<bRank){
			parent[aParent]=bParent;
		}else if(bRank<aRank){
			parent[bParent]=aParent;
		}else{
			parent[aParent]=bParent;
			rank[bParent]=rank[bParent]+1;
		}
	}
}