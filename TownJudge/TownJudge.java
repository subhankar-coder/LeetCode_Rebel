package TownJudge;

import java.util.*;

public class TownJudge{

	public static void main(String[] args) {
		
		int n =3;
		int [][] trust = {{1,3},{2,3},{3,1}};

		int [][] graph = new int [n+1][n+1];
		for(int [] arr: trust ){
			graph[arr[0]][arr[1]]=1;
		}

		Stack<Integer> st = new Stack<>();

		for (int i=1;i<=n;i++){
			st.push(i);
		}
		while(st.size()>1){
			int a = st.pop();
			int b = st.pop();
		// System.out.println(a+" "+b);

			if(graph[a][b]==1 && graph[b][a]==1)
					continue;

			if(graph[a][b]==1){
				st.push(b);
			}
			if(graph[b][a]==1)
					st.push(a);

			// System.out.println(st);
		}
		if(st.isEmpty())
			return ;
		int top = st.peek();

		for(int i=1;i<=n;i++){
			if(i!=top &&(graph[i][top]==0 || graph[top][i]==1))
				return;
		}

		System.out.println(top);
		// for(int [] arr: graph){
		// 	System.out.println(Arrays.toString(arr));
		// }
	}
}