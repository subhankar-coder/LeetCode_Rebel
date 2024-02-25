package GCDTraversal;


import java.util.*;


public class GCDTraversal{


	// static int [][] visited;
	static int [] parent;
	static int [] rank;
	public static void main(String[] args) {
		int [] nums = {39,35,50,21,42,44,42};
		int n = nums.length;
		parent = new int [n];
		rank = new int [ n];
		for(int i=0;i<n;i++){
			parent[i]=i;
			rank [i]=0;
		}
		// System.out.println(createGraph(nums,n));

		System.out.println(createPrimeNumbers(nums,n));
	}

	public static boolean createGraph(int [] nums,int n){
		// int n = nums.length;

		// visited = new int [n][n];

		int [] sum = new int [n];

		// int s =0;
		// Map<Integer,List<Integer>> graph = new HashMap<>();
		for(int i=0;i<n;i++){

			// if(!graph.containsKey(i))
			// 		graph.put(i,new ArrayList<Integer>());
			
			// int key =n-i-1;
			// if(i==0)
			// 		sum [key]=nums[n-1];
			// else 
			// 	sum [key]= sum[key+1]+nums[key];

			for(int j=i+1;j<n;j++){
				// if(!graph.containsKey(j))
				// 		graph.put(j,new ArrayList<Integer>());

				if(gcd(nums[i],nums[j])!=1){
						unionByRank(i,j);
						// graph.get(i).add(j);
						// graph.get(j).add(i);
				}
			}
		}

		// for(Map.Entry<Integer,List<Integer>> mp: graph.entrySet()){
		// 	System.out.println(mp.getKey()+"  "+mp.getValue());
		// }
		// boolean ans = true;
		// 	for(int i=0;i<n-1;i++){
		// 		int [] visited = new int [n];
		// 		int dfsSum = dfsSum(graph,i,visited,nums);
		// 		int s=0;
		// 		for(int j=i+1;j<n;j++){
		// 			if(visited[j]==1)
		// 				s+=1;
		// 		}
		// 		ans = ans && ((n-(i+1))==s);
		// 	}

		// 	return ans;
		for(int i=0;i<n-1;i++){
			for(int j=i+1;j<n;j++){

				int aParent = find(i);
				int bParent = find (j);

				if(aParent!=bParent)
						return false;
			}
		}
		return true;
	}

	public static boolean createPrimeNumbers(int []nums ,int n){

		if(n==1)
				return true;
		Map<Integer,Integer> primes = new HashMap<>();

		for(int i=0;i<n;i++){
			int num = nums[i];

			if(nums[i]==1)
					return false;

			for(int factor = 2;factor*factor<=num;factor++){
				if(num%factor==0){
					if(!primes.containsKey(factor)){
						primes.put(factor,i);
						// rank[i]=rank[i]+1;
					}else{
						int currParent = find(i);
						System.out.println(currParent+"  "+i+"  "+primes.get(factor));
						unionByRank(currParent,primes.get(factor));
						// System.out.println(Arrays.toString(parent));
					}
					while(num%factor==0){
						num=num/factor;
					}
				}
			}
			if(num>1){
				if(!primes.containsKey(num)){
						primes.put(num,i);
						// rank[i]=rank[i]+1;
					}else{
						int currParent = find(i);
						System.out.println("else "+"num "+num+" "+currParent+"  "+i+"  "+primes.get(num));
						unionByRank(currParent,primes.get(num));
					}
			}
			System.out.println(primes);
		}

		int count =1;
		int init = parent[0];
		for(int i=1;i<n;i++){
			int f = find(i);
			if(f!=init)
					count++;
		}

		return count==1;
		// System.out.println(Arrays.toString(parent));
		// System.out.println(primes);
	}

	public static int dfsSum(Map<Integer,List<Integer>> graph,int src,int [] visited,int [] nums){

		int sum =0;
		if(visited[src]==0){
			visited[src]=1;
			sum = nums[src];
			List<Integer> neighbour = graph.get(src);
			if(neighbour!=null){
				for(int ele :neighbour){
					if(visited[ele]!=1){
						sum+= dfsSum(graph,ele,visited,nums);
					}
				}
			}
		}
		return sum;
	}

	public static int find(int i){
		if(parent[i]==i)
				return i;
		int tmp= find(parent[i]);
        parent[i]=tmp;
        return parent[i];
	}
	public static void unionByRank (int a,int b){
		int aParent = find(a);
		int bParent = find(b);
		System.out.println("parent "+aParent+"  "+bParent);
		if(aParent==bParent)
				return ;
		int aRank = rank[aParent];
		int bRank = rank[bParent];

		System.out.println(a+"   "+b+"   "+aParent+"  "+bParent+"  "+aRank+"   "+bRank);
		if(aRank>bRank){
			parent[bParent]=aParent;
		}else if(aRank<bRank){
			System.out.println("hreer");
			parent[aParent]=bParent;
		}else{
			parent[aParent]=bParent;
			rank[bParent]+=1;
		}
		System.out.println(Arrays.toString(parent));
	}
	public static int gcd(int a,int b){
		if(b==0)
			return a;

		return gcd(b,a%b);
	}
}