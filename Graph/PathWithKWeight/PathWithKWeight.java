package Graph.PathWithKWeight;

import Graph.weightedGraph.WeightedGraph;
import java.util.*;

public class PathWithKWeight {
    private static int V=9;
    private static int [][] adjMatrix;

    public static void main(String[] args) {
        WeightedGraph g = new WeightedGraph(V,false);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);

        adjMatrix=g.getGraph();
        int k=60;
        List<Integer> visited=new ArrayList<>();
        pathFromSourceWithKWeight(k,0,visited);

    }
    public static boolean pathFromSourceWithKWeight(int k,int source,List<Integer> visited){
        if(k<0){
            return true;
        }
        if(!visited.contains(source)){
            visited.add(source);
            for(int i=0;i<V;i++){
                if(adjMatrix[source][i]!=0 && !visited.contains(i)){
                    pathFromSourceWithKWeight(k-adjMatrix[source][i],i,visited);
                }

            }
        }
        visited.remove(visited.size()-1);
        return false;
    }
}
