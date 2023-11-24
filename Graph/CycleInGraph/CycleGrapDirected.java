package Graph.CycleInGraph;
import Graph.*;
import java.util.*;

public class CycleGrapDirected {
    private static int V=4;
    private static int [][] adjMatrix;
    private static final int WHITE=0;
    private static final int GREY=1;
    private static final int BLACK=2;
    public static void main(String[] args) {
       Graph.createGraph(V,true);
       Graph.addEdge(0,1);
       Graph.addEdge(0,2);
       Graph.addEdge(1,2);
    //    Graph.addEdge(2,0);
       Graph.addEdge(2,3);
       adjMatrix = Graph.getGraph();
       int [] visited = new int[V];
       int [] restack = new int [V];
       Arrays.fill(restack,0);
       Arrays.fill(visited,0);
       isCyclicColor();
    }
    public static void isCyclic(int [] visited,int [] restack){
        for (int i=0;i<V;i++){
            if(visited[i]==0){

                if(isCyclicUtil(i,visited,restack)){
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    }
    public static boolean isCyclicUtil(int source,int [] visited,int [] restack){
        if(visited[source]==0){

            visited[source]=1;
            restack[source]=1;
            for(int i=0;i<V;i++){
                if(adjMatrix[source][i]!=0){
                    if(visited[i]==0 && isCyclicUtil(i,visited,restack))
                        return true;
                    else if(restack[i]==1)
                        return true;
                }
            
            }
        }
        restack[source]=0;
        return false;

    }
    
    public static void isCyclicColor(){
        int [] color = new int[V];
       Arrays.fill(color,WHITE);
       System.out.println(isCyclicColorUtil(0, color));

    }
    public static boolean isCyclicColorUtil(int source,int [] color){
        if(color[source]==WHITE){
            color[source]=GREY;
            for(int i=0;i<V;i++){
                if(adjMatrix[source][i]!=0){
                    if(color[i]==GREY)
                        return true;
                    else if(isCyclicColorUtil(i, color))
                        return true;
                }
            }
        }
        color[source]=BLACK;
        return false;
    }
}
