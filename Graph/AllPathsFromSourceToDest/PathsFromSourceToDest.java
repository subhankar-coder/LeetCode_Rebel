package Graph.AllPathsFromSourceToDest;

import Graph.Graph;
import java.util.*;
public class PathsFromSourceToDest {
    private static int V=4;
    private static int [][] adjMatrix;

    public static void main(String[] args) {
        Graph.createGraph(V,true);
        Graph.addEdge(0,1);
        Graph.addEdge(0,2);
        Graph.addEdge(0,3);
        Graph.addEdge(2,1);
        Graph.addEdge(2,0);
        Graph.addEdge(1,3);

        adjMatrix=Graph.getGraph();
        List<Integer> visited=new ArrayList<Integer>();
        printAllPath(2,3,visited);
    }
    public static void printAllPath(int source,int dest,List<Integer> visited){
        if(source==dest){
            System.out.println(visited);
            return;
        }
        if(!visited.contains(source)){
            visited.add(source);
            for(int i=0;i<V;i++){
                if(adjMatrix[source][i]!=0 && !visited.contains(i)){
                 printAllPath(i,dest,visited);   
                }
            }
            visited.remove(visited.size()-1);
        }
    }
}
