package Graph.ShortestPath;

import java.util.*;

public class DijktrasAlgo {
    static int N;
    public static void main(String[] args) {
        int [][] graph = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
        { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
        { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
        { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
        { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
        { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
        { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
        { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
        { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        N = graph.length;
        int [] sptSet=new int [N];
        int [] dist = new int [N];
        for(int i=0;i<N;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        solve(graph,sptSet,dist,0);
        System.out.println(Arrays.toString(dist));
    }
    public static void solve(int [][]graph,int []sptSet,int []dist,int source){
        dist[source]=0;
        for(int i=0;i<N-1;i++){
            int u=minDist(sptSet,dist);
            sptSet[u]=1;
            for(int v=0;v<N;v++){
                if(sptSet[v]==0 && graph[u][v]!=0 && dist[u]+graph[u][v]<dist[v])
                    dist[v]=dist[u]+graph[u][v];
            }
        }
    }
    public static int minDist(int []sptSet,int []dist){
        int minIndex=-1;
        int minValue=Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            if(sptSet[i]==0 && dist[i]<=minValue){
                minValue=dist[i];
                minIndex=i;
            }
        }
        return minIndex;
    }
    
}
