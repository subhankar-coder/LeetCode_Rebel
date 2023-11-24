package Graph.ShortestPath;
import Graph.weightedGraph.*;

public class BellmanFord {
    static int V=6;
    static int E=8;
    public static void main(String[] args) {
        WeightedGraph weightedGraph = new WeightedGraph(6,true);
        weightedGraph.addEdge(0,1,-1);
        weightedGraph.addEdge(0,2,4);
        weightedGraph.addEdge(1,2,3);
        weightedGraph.addEdge(1,3,2);
        weightedGraph.addEdge(1,4,2);
        weightedGraph.addEdge(3,2,5);
        weightedGraph.addEdge(3,1,1);
        weightedGraph.addEdge(4,3,-3);

        int [][] graph = weightedGraph.getGraph();
        
    }
    public static void solve(int [][] graph,int src){
        for (int i=1;i<V-1;i++){
            for(int j=0;j<E;j++){
                
            }
        }
    }
    
}
