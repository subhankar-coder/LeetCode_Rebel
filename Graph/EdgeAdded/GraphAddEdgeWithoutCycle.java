package Graph.EdgeAdded;
import Graph.*;
import java.util.*;

public class GraphAddEdgeWithoutCycle {
    private static int [][] adjMatrix;
    public static void main(String[] args) {
        int v = 6;
        Graph.createGraph(v,true);
        Graph.addEdge(5, 2);
        Graph.addEdge(5, 0);
        Graph.addEdge(4, 0);
        Graph.addEdge(4, 1);
        Graph.addEdge(2, 3);
        Graph.addEdge(3, 1);

       adjMatrix=Graph.getGraph();
       int [] visited = new int [v];
       Arrays.fill(visited,0);
       Stack<Integer> stack = new Stack<Integer>();
       for(int i=0;i<v;i++)
        topologicalSort(i,v,visited,stack);
    //    System.out.println(stack);
       int [] topological = new int[v];
       for(int i=0;i<v;i++){
        topological[i]=stack.pop();
       }

        checkEdgeIsThere(v,topological);
        // System.out.println(Arrays.toString(topological));
    }
    public static void topologicalSort(int start,int v,int [] visited,Stack<Integer> stack){
        if(visited[start]==0){
            visited[start]=1;  
            for(int i=0;i<v;i++){
                if(adjMatrix[start][i]!=0 && visited[i]==0){
                    topologicalSort(i,v,visited,stack);
                }
            }
            stack.add(start);
        }
    }
    public static void checkEdgeIsThere(int v,int [] topological){
        for(int i=0;i<v;i++){
            int first=topological[i];
            for(int j=i+1;j<v;j++){
                int second=topological[j];
                if(adjMatrix[first][second]==0){
                    System.out.println(first+" - "+second);
                }
            }
        }
    }

}
