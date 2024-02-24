package FindPeopleWithSecret;


import java.util.*;

public class FindPeopleWithSecret{
	static int [] rank;
	static int [] parent;
	public static void main(String[] args) {
		int n = 6;
		int [][] meetings = {{2,1,1},{0,1,1},{3,2,1},{4,2,2}};
		int firstPerson = 5;

		 parent = new int [n];
		 rank = new int [n];

		rank [0]=1;
		for(int i=0;i<n;i++)
				parent[i]=i;

		Arrays.sort(meetings, (a,b)->a[2]-b[2]);

		unionByRank(0,firstPerson);
		solve(meetings,n,firstPerson);
	}
	public static void solve(int [][] meetings,int n,int firstPerson){

		int len = meetings.length;
		int i=0;
		Set<Integer> li = new HashSet<>();
		li.add(0);
		li.add(firstPerson);

		while(i<len){
			boolean isConnected = false;
			Map<Integer,List<Integer>> graph = new HashMap<>();
			System.out.println("i "+i+" "+Arrays.toString(parent));
			Set<Integer> set = new HashSet<>();
			do{

				int a = meetings[i][0];
				int b = meetings[i][1];

				int aParent = find(a);
				int bParent = find(b);
				// if(i==3){

				// }
				if(!graph.containsKey(a))
						graph.put(a, new ArrayList<>());
				if(!graph.containsKey(b))
						graph.put(b,new ArrayList<>());


				graph.get(a).add(b);
				graph.get(b).add(a);

				if(a==0 || a!=aParent){
					set.add(a);
					unionByRank(a,b);
				}
				if(b==0 || b!=bParent){
					set.add(b);
					unionByRank(a,b);
				}
				i+=1;
			}while(i<len && i-1>=0 && meetings[i][2]==meetings[i-1][2]);

			if(graph.containsKey(0)){
				graph.get(0).add(firstPerson);
			}

			if(graph.containsKey(firstPerson))
					graph.get(firstPerson).add(0);

			System.out.println(set);

			for(Map.Entry<Integer,List<Integer>> mp : graph.entrySet()){

				System.out.println(mp.getKey()+"  "+mp.getValue());
			}

			Set<Integer> visited=new HashSet<>();

			for(int a: set){
				dfs(visited,a,graph);
			}
			li.addAll(visited);

		}
		System.out.println(li);

	}

	public static void dfs(Set<Integer> visited,int src,Map<Integer,List<Integer>> graph){

		if(!visited.contains(src)){
			visited.add(src);
			List<Integer> neighbour = graph.get(src);
			if(neighbour!=null){

				for(int ele: neighbour){

					if(!visited.contains(src)){
						dfs(visited,ele,graph);
					}
				}
			}
		}

	}
	public static int find(int i){
		if(parent[i]==i)
				return parent[i];
		return find(parent[i]);
	}

	public static void unionByRank(int a,int b){

		int aParent = find(a);
		int bParent = find (b);

		if(aParent==bParent)
				return ;

		int aRank = rank [aParent];
		int bRank = rank [bParent];

		// System.out.println("rank "+aRank+" "+bRank);

		if(aRank<bRank){
			parent[aParent]=bParent;
		}else if(aRank>bRank){
			parent[bParent]=aParent;
		}else{
			parent[aParent]=bParent;
			rank[bParent]++;
		}
		// System.out.println(Arrays.toString(parent));
	}
}

// class DisjointSet{

// 	public int [] rank ;
// 	public int [] parent ;

// 	public DisjointSet(int n){
// 		rank = new int [n];
// 		parent = new int [n];
// 		for(int i=0;i<n;i++)
// 				parent[i]=i;
// 	}
// }