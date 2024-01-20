package Graph.Mcoloring;
import Graph.*;
import java.util.*;

public class GraphColoring {

    private static final int N=4; 
    public static void main(String[] args) {
        Graph.createGraph(N,false);
        Graph.addEdge(0,1);
        Graph.addEdge(0,2);
        Graph.addEdge(0,3);
        Graph.addEdge(1,0);
        Graph.addEdge(1,2);
        Graph.addEdge(2,0);
        Graph.addEdge(2,1);
        Graph.addEdge(2,3);
        Graph.addEdge(3,0);
        Graph.addEdge(3,2);

        int [][] graph = Graph.getGraph();
        int [] color = new int [N];
        Arrays.fill(color,0);
        
        int m =3;
        graphColoring(graph,color,0,m);
    }

    public static boolean isSafe(int [][] graph,int [] color,int source,int c){
        for(int i=0;i<N;i++){
            if(i!=source && graph[source][i]!=0 && c==color[i])
                return false;
        }
        return true;
    } 

    public static boolean graphColoring(int [][] graph,int [] color, int source,int m){
        if(source==N){
            System.out.println(Arrays.toString(color));
            return true;
        }
        for(int i=1;i<=m;i++){
            color[source]=i;
            if(isSafe(graph,color,source,i)){
                if(graphColoring(graph,color,source+1,m))
                    return true;
            }
            color[source]=0;
        }
        return false;
    }
}
