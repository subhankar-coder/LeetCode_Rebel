package Graph.CycleInGraph;
import Graph.*;
import Graph.weightedGraph.*;
import java.util.*;

public class CycleInDirectedGraph {
    private static int V=5;
    private static int [][] adjMatrix;
    public static void main(String[] args) {
        // WeightedGraph g = new WeightedGraph(V,false);
        // g.addEdge(0, 1, 4);
        // g.addEdge(0, 7, 8);
        // g.addEdge(1, 2, 8);
        // g.addEdge(1, 7, 11);
        // g.addEdge(2, 3, 7);
        // g.addEdge(2, 8, 2);
        // g.addEdge(2, 5, 4);
        // g.addEdge(3, 4, 9);
        // g.addEdge(3, 5, 14);
        // g.addEdge(4, 5, 10);
        // g.addEdge(5, 6, 2);
        // g.addEdge(6, 7, 1);
        // g.addEdge(6, 8, 6);
        // g.addEdge(7, 8, 7);
        
        Graph.createGraph(5,false);
        Graph.addEdge(0,1);
        // Graph.addEdge(0,2);
        Graph.addEdge(0,3);
        Graph.addEdge(1,2);
        Graph.addEdge(3,4);
        adjMatrix = Graph.getGraph();
        isCyclic(adjMatrix);

    }
    public static void isSimplePath(int [][]adjMatrix){
        int source =0;
        int dest=7;
        int [] visited= new int [V];
        Arrays.fill(visited,0);
        System.out.println(isSimplePathUtil(adjMatrix,source,dest,visited));
    }
    public static boolean isSimplePathUtil(int [][] adjMatrix,int source,int dest,int []visited){
        if(visited[source]==0){
            visited[source]=1;
            if(source==dest)
                return true;
            for(int i=0;i<V;i++){
                if(adjMatrix[source][i]!=0 && visited[i]==0)
                    return isSimplePathUtil(adjMatrix,i,dest,visited);
            }
            
        }
        return false;
    }
    public static void isCyclic(int [][] adjMatrix){
        int [] visited=new int [V];
        Arrays.fill(visited,0);
        for(int i=0;i<V;i++){
            if(visited[i]==0 ){
                if(isCyclicUtil(visited,i,-1,adjMatrix)){
                    System.out.println(true);
                    return;
                }
             }
        }
        System.out.println(false);

    }
    public static boolean isCyclicUtil(int [] visited,int source,int parent,int [][] adjMatrix){
        if(visited[source]==0){
            visited[source]=1;
            for(int i=0;i<V;i++){
                if(adjMatrix[source][i]!=0){
                    if(visited[i]==0){
                        if(isCyclicUtil(visited,i,source,adjMatrix)){
                            return true;
                        }
                    }
                    else if(i!=parent)
                        return true;
                }
            }

        }   
        return false;
    }
}
