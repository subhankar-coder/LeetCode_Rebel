package Graph.weightedGraph;

public class WeightedGraph {


    private int V;
    private int[][] adjMatrix;
    private boolean isDirected;

    public WeightedGraph(int v,boolean isDirected){
        this.V=v;
        this.adjMatrix= new int [V][V];
        this.isDirected=isDirected;
    }
    public void addEdge(int u,int v,int w){
        adjMatrix[u][v]=w;
        if(!isDirected){
            adjMatrix[v][u]=w;
        }
    }
    public int [][] getGraph(){
        return adjMatrix;
    }
}
