
import java.util.*;


public class TwoAndFourWheelerRoad{

	static int [] visited;
	public static void main(String[] args) {
		
		int n =4;
		int m = 6;

		int [][] array = {
			{3 ,4 ,2},
			{2 ,3 ,3},
			{1 ,2 ,3},
			{2 ,4 ,1},
			{1 ,2 ,1},
			{1 ,3 ,1}
		};

		int [][] graph1 = new int [n][n];

		int [][] graph2 = new int [n][n];

		int [][] graph3 = new int [n][n];

		for(int [] arr: array){

			if(arr[2]==1){
				graph1[arr[0]-1][arr[1]-1]=1;
				graph1[arr[1]-1][arr[0]-1]=1;
			}else if(arr[2]==2){
				graph2[arr[0]-1][arr[1]-1]=1;
				graph2[arr[1]-1][arr[0]-1]=1;
			}else{
				graph1[arr[0]-1][arr[1]]=1;
				graph1[arr[1]-1][arr[0]-1]=1;
				graph2[arr[0]-1][arr[1]-1]=1;
				graph2[arr[1]-1][arr[0]-1]=1;

				graph3[arr[0]-1][arr[1]-1]=1;
				graph3[arr[1]-1][arr[0]-1]=1;
			}
		}

		visited=new int[n];
		DFS(graph1,0,n);
		if(Arrays.stream(visited).sum()<n){
			System.out.println(-1);
			return;
		}

		visited=new int [n];
		DFS(graph2,0,n);

		if(Arrays.stream(visited).sum()<n){
			System.out.println(-1);
			return ;
		}

		visited=new int[n];
		int count 
		for(int i=0;i<n;i++){

		}



	}

	public static void DFS(int [][] graph,int start,int n){
		if(visited[start]==0){
			visited[start]=1;
			int [] neighbours= graph[start];
			for(int i=0;i<n;i++){
				if(graph[start][i]==1 && visited[i]!=1){
					DFS(graph,i,n);
				}
			}			
		}
	}
}